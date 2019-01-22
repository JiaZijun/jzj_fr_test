package redis;

/**
 * 分布锁redis测试
 * 
 * @author jzj
 * @date 2019年1月22日 下午2:38:49
 * @desc
 */
public class ThreadTest {

	   public static void main(String[] args) {
	        Service service = new Service();
	        for (int i = 0; i < 50; i++) {
	            ThreadA threadA = new ThreadA(service);
	            threadA.start();
	        }
	    }
}
