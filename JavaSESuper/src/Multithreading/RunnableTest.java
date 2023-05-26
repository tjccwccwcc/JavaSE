package Multithreading;

/**
 * 开发中更常用
 * 没有单继承局限性
 * 不用static即可设置共享的属性
 */
public class RunnableTest {
    public static void main(String[] args) {
        YourThread yourThread = new YourThread();
        Thread thread = new Thread(yourThread);
        Thread thread1 = new Thread(yourThread);
        thread.start();
        thread1.start();
    }
}
class YourThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}