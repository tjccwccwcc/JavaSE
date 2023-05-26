package Multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        LockThread lockThread = new LockThread();
        Thread thread1 = new Thread(lockThread);
        Thread thread2 = new Thread(lockThread);
        Thread thread3 = new Thread(lockThread);
        thread1.setName("线程一");
        thread2.setName("线程二");
        thread3.setName("线程三");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class LockThread implements Runnable{
    private int tacket = 100;

    //1
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run(){
        while(true){
            try {
                //2
                lock.lock();

                if(tacket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + tacket);
                    tacket--;
                }
                else break;
            }
            finally{
                //3
                lock.unlock();
            }
        }
    }
}