package Multithreading;

public class SingLetonSafety {
    public static void main(String[] args){
        Order Order1 = Order.getInstance();
        Order Order2 = Order.getInstance();
        System.out.println(Order1 == Order2);
    }
}

//懒汉式
class Order{
    //1.私有化构造器
    private Order(){}
    //2.声明当前类对象，未初始化
    //4.也得为static
    private static Order instance = null;
    //3.声明public、static的返回当前类的对象的方法
    public static Order getInstance(){
        if (instance == null) {//效率高的解决线程安全问题
            synchronized (Order.class) {
                if (instance == null)
                    instance = new Order();
            }
        }
        return instance;
    }
/*    public static synchronized Order getInstance(){
        //效率低的解决线程安全问题
        if (instance == null) instance = new Order();
        return instance;
    }*/
}