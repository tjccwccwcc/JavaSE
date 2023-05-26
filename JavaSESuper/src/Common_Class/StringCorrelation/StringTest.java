package Common_Class.StringCorrelation;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringTest {
    @Test
    public void test1(){
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);
        s1 = "hello";
        String s3 = "abc";
        s3 += "def";
        System.out.println(s2);
        String s5 = s2.replace("a","m");
        System.out.println(s2);
        System.out.println(s5);
    }

    @Test
    public void test2(){
        String str1 = "abc";//地址指向常量池
        String str2 = "abc";
        String str3 = new String("abc");//地址指向堆中实例化的对象
        String str4 = new String("abc");
        System.out.println(str1 == str2);
        System.out.println(str3 == str4);
        System.out.println(str1 == str3);

        System.out.println("************************************");
        Person p1 = new Person("Tom",12);
        Person p2 = new Person("Tom",12);
        System.out.println(p1.getName() == p2.getName());
        System.out.println(p1.getName().equals(p2.getName()));
    }

    @Test
    public void test3(){
        String s1 = "a";
        String s2 = "bc";

        String s3 = "abc";
        String s4 = "a" + "bc";//常量在方法区
        String s5 = s1 +"bc";//变量在堆中，相当与new String()
        String s6 = "a" + s2;
        String s7 = s1 + s2;

        String s8 = s5.intern();//返回常量池中的字符串

        final String s9 = "bc";//相当于常量
        String s10 = "a" + s9;
        String s11 = s1 + s9;

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s5 == s6);
        System.out.println(s5 == s7);
        System.out.println(s6 == s7);
        System.out.println(s3 == s8);
        System.out.println(s3 == s10);
        System.out.println(s3 == s11);
        System.out.println(s3.hashCode());
        System.out.println(s7.hashCode());
    }

    @Test
    public void test4(){
        StringTest1 ex = new StringTest1();
        ex.change(ex.str, ex.ch);//对象类型的参数，传递的为地址
        System.out.println(ex.str);//good
        System.out.println(ex.ch);//best
        System.out.println(ex.str.hashCode());
        System.out.println(ex.str1.hashCode());
    }

    class StringTest1 {
        String str = new String("good");
        String str1 = "good";
//        String str = "good";
        char[] ch = { 't', 'e', 's', 't' };
        public void change(String str, char ch[]) {
            System.out.println("before: " + str.hashCode());
            str = "test ok";//改变的是新创建的对象的地址，而非原对象的地址，且string的不可变性
            System.out.println("after: " + str.hashCode());
            ch[0] = 'b';
        }
    }

    @Test
    public void test5(){
        int num = 10;
        String s = String.valueOf(num);
        String s1 = num + "";
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s == s1);
    }

    @Test
    public void test6(){
        String str = "abc123456";
        char[] charryList = str.toCharArray();
        for (int i = 0; i < charryList.length; i++) {
            System.out.print(charryList[i]);
        }

        System.out.println();
        char[] charryList2 = {'a','b','c','4','5','6'};
        String str2 = new String(charryList2);
        System.out.println(str2);
    }

    @Test
    public void test7() throws UnsupportedEncodingException {
        String str = "abc123中国";
        byte[] bytesList = str.getBytes();
        System.out.println(Arrays.toString(bytesList));

/*        System.out.println(bytesList);
        for (int i = 0; i < bytesList.length; i++) {
            System.out.print(bytesList[i]);
        }
        System.out.println();*/
        byte[] gbks = str.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));

        String s = new String(bytesList);
        String s1 = new String(gbks);
        String gbk = new String(gbks, "gbk");
        System.out.println(s);
        System.out.println(s1);
        System.out.println(gbk);
    }

    @Test
    public void test8(){
        String[] arr = {"he", "llo", "world"};
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        System.out.println(s);

        String[] arr1 = {"he", "llo", "world"};
        StringBuilder s1 = new StringBuilder();
        for (String value : arr1) {
            s1.append(value);
        }
        System.out.println(s1);
    }
}

class Person{
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;//true
        this.age = age;
//        this.name = new String(name);//false
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
