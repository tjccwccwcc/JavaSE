package JavaSE_Class.Test_WrapperClass;

import org.junit.Test;

/*
 * 包装类的使用:
 * 1.java提供了8种基本数据类型对应的包装类，使得基本数据类型的变量具有类的特征
 *
 * 2.掌握的：基本数据类型、包装类、String三者之间的相互转换
 *
 */
public class WrapperTest {
    //基本数据类型 --->包装类：调用包装类的构造器
    @Test
    public void test(){
        int num = 10;
        Integer in = new Integer(num);
        System.out.println(in.toString());

        Integer in1 = new Integer("123");
        System.out.println(in1.toString());
//wrong
//        Integer in2 = new Integer("123abc");
//        System.out.println(in2.toString());

        Float f1 = new Float(12.3f);
        Float f2 = new Float("12.3");
        System.out.println(f1);
        System.out.println(f2);

        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("TrUe");
        System.out.println(b2);
        Boolean b3 = new Boolean("true123");
        System.out.println(b3);//false

        Order order = new Order();
        System.out.println(order.isMale);//false
        System.out.println(order.isFemale);//null
    }

    //包装类--->基本数据类型:调用包装类Xxx的xxxValue()
    @Test
    public void test1(){
        Integer in1 = new Integer(12);

        int i1 = in1.intValue();
        System.out.println(i1 + 1);


        Float f1 = new Float(12.3);
        float f2 = f1.floatValue();
        System.out.println(f2 + 1);
    }

    /*
     * JDK 5.0 新特性：自动装箱 与自动拆箱
     */
    @Test
    public void test2(){
//		int num1 = 10;
//		//基本数据类型-->包装类的对象
//		method(num1);
        //自动装箱：基本数据类型 --->包装类
        int num2 = 10;
        Integer in1 = num2;//自动装箱
        boolean b1 = true;
        Boolean b2 = b1;//自动装箱
        //自动拆箱：包装类--->基本数据类型
        System.out.println(in1.toString());
        System.out.println(in1);
        int num3 = in1;//自动拆箱
    }
    public void method(Object obj){
        System.out.println(obj);
    }

    //基本数据类型、包装类--->String类型：调用String重载的valueOf(Xxx xxx)
    @Test
    public void test3(){

        int num1 = 10;
        //方式1：连接运算
        String str1 = num1 + "";
        //方式2：调用String的valueOf(Xxx xxx)
        float f1 = 12.3f;
        String str2 = String.valueOf(f1);//"12.3"

        Double d1 = new Double(12.4);
        String str3 = String.valueOf(d1);
        System.out.println(str2);
        System.out.println(str3);//"12.4"

    }

    //String类型 --->基本数据类型、包装类：调用包装类的parseXxx(String s)
    @Test
    public void test4(){
        String str1 = "123";
        //错误的情况：
//		int num1 = (int)str1;
//		Integer in1 = (Integer)str1;
        //可能会报NumberFormatException
        int num2 = Integer.parseInt(str1);
        System.out.println(num2 + 1);

        String str2 = "true1";
        boolean b1 = Boolean.parseBoolean(str2);
        System.out.println(b1);
    }

    @Test
    public void test5() {
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);// 1.0

    }

    @Test
    public void test6() {
        Object o2;
        if (true)
            o2 = new Integer(1);
        else
            o2 = new Double(2.0);
        System.out.println(o2);// 1

    }

    @Test
    public void test7() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);//false

        //Integer内部定义了IntegerCache结构，IntegerCache中定义了Integer[],
        //保存了从-128~127范围的整数。如果我们使用自动装箱的方式，给Integer赋值的范围在
        //-128~127范围内时，可以直接使用数组中的元素，不用再去new了。目的：提高效率

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);//true

        Integer x = 128;//相当于new了一个Integer对象
        Integer y = 128;//相当于new了一个Integer对象
        System.out.println(x == y);//false
    }
}

class Order{
    boolean isMale;
    Boolean isFemale;
}