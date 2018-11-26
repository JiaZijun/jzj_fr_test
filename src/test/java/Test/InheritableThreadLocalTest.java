package Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;

/**
 *测试线程池提交任务
 * 主线程设置的线程变量，子线程可以共享
 * @author jzj
 * @date 2018年11月19日 下午5:39:33
 * @desc
 */
public class InheritableThreadLocalTest {
	
	public static void main(String[] args) {
        // TODO Auto-generated method stub

        ExecutorService executorService=Executors.newFixedThreadPool(10);
        AirShoppingResultHolder.set("haha");
    	AirShoppingResultHolder.set("hahaa");
        System.out.println(Thread.currentThread().getName()+AirShoppingResultHolder.get());
        for ( int i = 0; i < 5; i++) {
        	executorService.execute(new Runnable() {
                
                @Override
                public void run() {
                	System.out.println(Thread.currentThread().getName()+"----"+AirShoppingResultHolder.get());
                	AirShoppingResultHolder.set("子线程hahha");
                	System.out.println(Thread.currentThread().getName()+"----"+AirShoppingResultHolder.get());
                }
            });
		}
    }

}

 class AirShoppingResultHolder{


    private static InheritableThreadLocal<String> airShoppingResultHolder = new InheritableThreadLocal<String>();

    public static void set(String string) {
        airShoppingResultHolder.set(string);
    }

    public static String get() {
        return airShoppingResultHolder.get();
    }

    public static void clear() {
        airShoppingResultHolder.remove();
    }

}
