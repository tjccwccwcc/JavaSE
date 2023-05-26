package JavaSE_Class.Test_Interface;

public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);
//        Flyable.MIN_SPEED = 2;//报错
        Plane plane = new Plane();
        plane.fly();
    }
}
interface Flyable{
    //全局常量
    public static final int MAX_SPEED = 7900;//第一宇宙速度
    int MIN_SPEED = 1;//在接口中默认为全局常量，即省略public static final

    //抽象方法
    public abstract void fly();
    void stop();//同样可省略public abstract

    //public Flyable(){}//不能使用构造器，即无法实例化
}

interface Attackable{
    void Attack();
}

class Plane implements Flyable{

    @Override
    public void fly() {
        System.out.println("通过引擎飞");
    }

    @Override
    public void stop() {
        System.out.println("驾驶员减速停止");
    }
}

abstract class Kite implements Flyable{
    @Override
    public void fly() {

    }
}

class Bullet extends Object implements Flyable,Attackable{

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void Attack() {

    }
}

interface AA{
    void method();
}
interface BB{
    void method1();
}
interface CC extends AA,BB{}
class Test1 implements CC{

    @Override
    public void method() {

    }

    @Override
    public void method1() {

    }
}

interface DD{
    void method();
}
interface EE extends DD,AA{}
class Test2 implements EE{

    @Override
    public void method() {

    }
}