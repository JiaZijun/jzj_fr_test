package redis;


import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;




public class RedisLockTest {
	
    private final JedisPool jedisPool;
    

    public RedisLockTest(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    /**
     * 加锁
     * @param locaName  锁的key
     * @param acquireTimeout  获取超时时间
     * @param timeout   锁的超时时间
     * @return 锁标识
     */
    public String lockWithTimeout(String locaName, long acquireTimeout, long timeout) {
        Jedis conn = null;
        String retIdentifier = null;
        try {
            // 获取连接
            conn = jedisPool.getResource();
            // 随机生成一个value
            String identifier = UUID.randomUUID().toString();
            // 锁名，即key值
            String lockKey = "lock:" + locaName;
            // 超时时间，上锁后超过此时间则自动释放锁
            int lockExpire = (int)(timeout / 1000);

            // 获取锁的超时时间，超过这个时间则放弃获取锁
            long end = System.currentTimeMillis() + acquireTimeout;
            while (System.currentTimeMillis() < end) {
            	//且仅当key不存在时，set一个key为val的字符串，返回1；若key存在，则什么都不做，返回0
                if (conn.setnx(lockKey, identifier) == 1) {
                	System.out.println("重新设置key"+"key的过期时间是："+lockExpire);
                    conn.expire(lockKey, lockExpire);
                    // 返回value值，用于释放锁时间确认
                    retIdentifier = identifier;
                    return retIdentifier;
                }
                System.out.println("不需要设置key");
                // 返回-1代表key没有设置超时时间，为key设置一个超时时间
                if (conn.ttl(lockKey) == -1) {
                	System.out.println("没有设置key的超时时间");
                    conn.expire(lockKey, lockExpire);
                }

                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        } catch (JedisException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return retIdentifier;
    }

    /**
     * 释放锁
     * @param lockName 锁的key
     * @param identifier    释放锁的标识
     * @return
     */
    public boolean releaseLock(String key, String lockValue) {
    	    String luaScript = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";// lua脚
    	    Long lockReleaseOK = 1L;
    	    if(key == null || lockValue == null) {
    	        return false;
    	    }
    	    Jedis jedis = null;
    	    try {
    	         jedis = jedisPool.getResource();
    	         String lockKey = "lock:" + key;
    	         Object res =jedis.eval(luaScript,Collections.singletonList(lockKey),Collections.singletonList(lockValue));
    	       System.out.println("---lua res--"+res);
    	        return res!=null && res.equals(lockReleaseOK);
    	    } catch (Exception e) {
    	        return false;
    	    }finally {
              if (jedis != null) {
               jedis.close();
              }
    	    }
    	

//        Jedis conn = null;
//        String lockKey = "lock:" + lockName;
//        boolean retFlag = false;
//        try {
//            conn = jedisPool.getResource();
//            while (true) {
//                // 监视lock，准备开始事务
//                conn.watch(lockKey);
//                // 通过前面返回的value值判断是不是该锁，若是该锁，则删除，释放锁
//                if (identifier.equals(conn.get(lockKey))) {
//                    Transaction transaction = conn.multi();
//                    transaction.del(lockKey);
//                    List<Object> results = transaction.exec();
//                    if (results == null) {
//                        continue;
//                    }
//                    retFlag = true;
//                }
//                conn.unwatch();
//                break;
//            }
//        } catch (JedisException e) {
//            e.printStackTrace();
//        } finally {
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        return retFlag;
    }
}

