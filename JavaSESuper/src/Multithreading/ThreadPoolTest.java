package Multithreading;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service = (ThreadPoolExecutor) executorService;
//        System.out.println(executorService.getClass());
        service.setCorePoolSize(10);
//        service.setKeepAliveTime(2000L,null);
        service.setMaximumPoolSize(20);

        executorService.execute(new NumberThread());//Runnable
        executorService.submit(new NumberThread1());//Callable
        executorService.shutdown();
    }
}
class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
class NumberThread1 implements Callable {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        return null;
    }
}