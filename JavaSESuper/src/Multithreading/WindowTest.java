package Multithreading;

public class WindowTest {
    public static void main(String[] args) {
        //一
        Window window = new Window();
        Thread thread = new Thread(window);
        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        thread.setName("窗口一");
        thread1.setName("窗口二");
        thread2.setName("窗口三");
        thread.start();
        thread1.start();
        thread2.start();
        //二
/*        Window1 window1 = new Window1();
        Window1 window2 = new Window1();
        Window1 window3 = new Window1();
        window1.setName("窗口一");
        window2.setName("窗口二");
        window3.setName("窗口三");
        window1.start();
        window2.start();
        window3.start();*/
    }
}
class Window implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            synchronized (Window.class) {//this
                Window.class.notifyAll();//this.notifyAll()
                if (ticket > 0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()
                            + ":" + ticket);
                    ticket--;
                    try {
                        Window.class.wait();//this.wait()
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    break;
                }
            }
        }
    }
}
class Window1 extends Thread{
    private static int ticket = 100;//必须要static
    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName()
                        + ":" + ticket);
                ticket--;
            }
            else {
                break;
            }
        }
    }
}