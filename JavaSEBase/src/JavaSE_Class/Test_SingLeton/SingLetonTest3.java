package JavaSE_Class.Test_SingLeton;

public class SingLetonTest3 {
    public static void main(String[] args){
        TestOther test1 = TestOther.instance;
        //不设为final就无法控制对instance的set方法
        //private可以控制get和set方法
        //TestOther.instance = null;
        TestOther test2 = TestOther.instance;
        System.out.println(test1 == test2);
        //报错
//        String a = null;
//        String b = null;
//        if (a == b) System.out.println(a.equals(b));
//        if (a.equals(b)) System.out.println(a.equals(b));
    }
}


class TestOther{
    private TestOther(){}
    //public static TestOther instance = new TestOther();
    //解决方法
    public static final TestOther instance = new TestOther();
}