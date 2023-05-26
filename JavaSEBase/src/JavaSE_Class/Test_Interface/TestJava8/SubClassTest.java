package JavaSE_Class.Test_Interface.TestJava8;

public class SubClassTest {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method2();
        subClass.method3();
        //subClass.method1();//报错，接口中static方法只能接口自己使用
        Java8Test.method1();
    }
}
class SubClass extends SuperClass implements Java8Test,Java8Test2{
    @Override
    public void method3() {//接口冲突,但如果父类中有该方法则不会冲突
        Java8Test.super.method3();
        Java8Test2.super.method3();
    }
//    @Override
//    public void method2() {
//        Java8Test.super.method2();//调用接口中的方法
//        //System.out.println("广东");
//    }

}
class SuperClass {
    public void method2(){
        System.out.println("广西");
    }
}