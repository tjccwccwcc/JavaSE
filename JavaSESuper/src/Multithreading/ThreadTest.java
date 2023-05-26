package Multithreading;

public class ThreadTest {
    public static void main(String[] args) {
        //3
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread("线程二");
        //4
        myThread.setName("线程一");
        myThread.setPriority(10);
        myThread.start();
//        myThread.start();//报错
        myThread1.start();
        new MyThread().start();

//        myThread.run();//还是主线程
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()
                    + ":" + i + "****main()****");
/*            if (i == 20) {
                try {
                    myThread.join();//将原线程阻塞，该线程运行完后再运行原线程
//                    myThread.stop();//已过时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
        }
        System.out.println(myThread.isAlive());//判断存活
        System.out.println(myThread.getPriority());//获取线程优先级 max:10 min:1 normal:5
        System.out.println(myThread1.getPriority());
        System.out.println(Thread.currentThread().getPriority());
    }
}
//1
class MyThread extends Thread{
    @Override//2
    public void run() {
        for (int i = 0; i < 100; i++) {
/*            try {
                sleep(1000);//阻塞时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            if(i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
            if (i % 20 == 0) {
                yield();//释放线程执行权
            }
        }
    }
    public MyThread(){}
    public MyThread(String name){
        super(name);
    }
}