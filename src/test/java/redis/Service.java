package redis;

import org.apache.commons.lang.StringUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Service {
    private static JedisPool pool = null;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(200);
        // 设置最大空闲数
        config.setMaxIdle(8);
        // 设置最大等待时间
        config.setMaxWaitMillis(1000 * 100);
        // 在borrow一个jedis实例时，是否需要验证，若为true，则所有jedis实例均是可用的
        config.setTestOnBorrow(true);
        pool = new JedisPool(config, "127.0.0.1", 6379, 3000);
//        pool = new JedisPool(config, "47.74.237.68", 6379, 3000, "saasKHRedisPass");
    }

    RedisLockTest lock = new RedisLockTest(pool);

    int n = 500;

    public void seckill() {
        // 返回锁的value值，供释放锁时候进行判断
        String indentifier = lock.lockWithTimeout("token", 3000, 10000);
        if(StringUtils.isNotEmpty(indentifier)){
        	System.out.println(Thread.currentThread().getName() + "获得了锁,锁标识为："+indentifier);	
        	System.out.println(--n);
            Jedis jedis = pool.getResource();
            jedis.set("token", "HHAHAHAHA");
            lock.releaseLock("token", indentifier);
        }else{
            System.out.println(Thread.currentThread().getName() + "没有获得锁");
        }
         
    }
}
