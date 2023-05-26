package JavaSE_Class.Test_Interface.TestJava8;

public interface Java8Test {
    //静态方法
    static void method1() {
        System.out.println("北京");
    }
    //默认方法
    default void method2() {
        System.out.println("上海");
    }

    default void method3(){
        System.out.println("南京");
    }
}

interface Java8Test2{
    default void method3(){
        System.out.println("东京");
    }
}