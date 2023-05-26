package Multithreading;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

public class StatusTest {
    static volatile boolean running = true;
    //sleep
    @Test
    public void test() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                while (running) {
                    System.out.println("tl running is false,tl将sleep");
                    Thread.sleep(10000L);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("new t1 t1 的状态:" + t1.getState()); // new
        t1.start();
        Thread.sleep(2000L);
        running = false;
        Thread.sleep(2000L);
        System.out.println("t1.sleep()时的状态: " + t1.getState()); // timed_waiting
    }

    //join
    @Test
    public void test1() throws InterruptedException{
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                System.out.println("t2中执行t1.join(5000L)");
                t1.join(5000L); //t2等待t1 5s
                System.out.println("t2中执行t1.join()");
                t1.join(); //t2等待t1执行完
                System.out.println("t2执行完");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(1000L);
        System.out.println("t2的状态:"+ t2.getState());
        Thread.sleep(5000L);
        System.out.println("t2的状态: " + t2.getState());
        Thread.sleep(10000L);
    }

    //synchronized
    @Test
    public void test2() throws InterruptedException{
        Thread t1 = new Thread(() -> {
            synchronized (StatusTest.class){
                System.out.println("t1抢到锁");
            }
        });
        synchronized (StatusTest.class){
            t1.start();
            Thread.sleep(1000L);
            System.out.println("t1抢不到锁的状态：" + t1.getState());
        }
    }

    //wait
    @Test
    public void test3() throws InterruptedException{
        Object object = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (object) {
                try {
                    System.out.println("t1将wait(1000L)");
                    object.wait(1100L);
                    System.out.println("t1将wait");
                    object.wait();
                    System.out.println("t1将执行完");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread.sleep(1000L);
        synchronized (object) {
            System.out.println("t1的状态: " + t1.getState());
            object.notify();
            Thread.sleep(1000L);
            System.out.println("t1的状态: " + t1.getState());
        }
        Thread.sleep(3000L);
        System.out.println("t1的状态:" + t1.getState());
        Thread.sleep(1000L);
        synchronized (object) {
            object.notify();
        }
        t1.sleep(0L);//切换至t1线程
        System.out.println("t1的状态: " + t1.getState());
        Thread.sleep(1000L);
        System.out.println("t1的状态: " + t1.getState());
    }

    //park
    @Test
    public void test4() throws InterruptedException{
        Thread t1 = new Thread(() -> LockSupport.park());
        t1.start();
        Thread.sleep(1000L);
        System.out.println("t1 park()后的状态:" + t1.getState());
        LockSupport.unpark(t1);
        System.out.println("t1 unpark()后的状态:" + t1.getState());
        t1.sleep(0L);//切换至t1线程
        System.out.println("t1 unpark() 切换后的状态:" + t1.getState());
    }
}