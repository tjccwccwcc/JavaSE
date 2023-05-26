package Multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        OurThread ourThread = new OurThread();
        FutureTask futureTask = new FutureTask(ourThread);
        new Thread(futureTask).start();
        try {
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class OurThread implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
        }
        return sum;
    }
}