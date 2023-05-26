package Common_Class.StringCorrelation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringMethodTest {
    @Test
    public void test(){
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(9));
//        System.out.println(s1.charAt(10));
        System.out.println(s1.isEmpty());

        System.out.println("---------------");
        String s2 = s1.toLowerCase();
//        s2 = s1.toUpperCase();
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("---------------");
        String s3 = "    H e llo Wo  rld  ";
        String s4 = s3.trim();
        System.out.println("----" + s3 + "----");
        System.out.println("----" + s4 + "----");
    }

    @Test
    public void test1(){
        String s1 = "helloworld";
        String s2 = "HelloWorld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = s2.concat(s1);
        String s4 = "HelloWorldhelloworld";
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s3 == s4);

        String s5 = "abc";
        String s6 = "abe";
        System.out.println(s5.compareTo(s6));

        String s7 = s4.substring(10);
        String s8 = s4.substring(0,10).intern();//[0,10)
        System.out.println(s7);
        System.out.println(s8);
        System.out.println(s7 == s1);
        System.out.println(s8 == s2);
    }
    @Test
    public void test2(){
        String s1 = "helloworld";
        System.out.println(s1.endsWith("world"));
        System.out.println(s1.startsWith("hello"));
        System.out.println(s1.startsWith("llowo",2));
        String s2 = "wor";
        System.out.println(s1.contains(s2));
        System.out.println("----------------------");
        System.out.println(s1.indexOf("lo"));
        System.out.println(s1.indexOf("lof"));
        System.out.println(s1.indexOf("lo",5));
        System.out.println("----------------------");
        String s3 = "hellorworld";
        System.out.println(s3.lastIndexOf("or"));
        System.out.println(s3.lastIndexOf("or",6));
    }
    @Test
    public void test3(){
        String s1 = "天才和天才学习";
        String s2 = s1.replace("天","人");
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("--------------------------------");
        String str = "12hello34world5java7891mysql456";
        String string = str.replaceAll("\\d+", ",");
        String string1 = str.replaceAll("\\d+", ",")
                .replaceAll("^,|,$", "");
        System.out.println(string);
        System.out.println(string1);

        System.out.println("--------------------------------");
        String str1 = "12345e";//12345
        boolean matches = str1.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-453428910";//0571-4534289
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);

        System.out.println("--------------------------------");
        str = "hello|world|java";
        String[] strs = str.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();
        String str2 = "hello.world.java";
        String[] strs2 = str2.split("\\.");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }
    }

    @Test
    public void test4(){
        String s3 = "    H e llo Wo  rld      ";
        String s4 = newTrim(s3);
        System.out.println("----" + s3 + "----");
        System.out.println("----" + s4 + "----");
    }

    @Test
    public void test5(){
        String str1 = "abcdefg";
        try {
            String str2 = newReserve(str1,2,5);
            System.out.println(str1);
            System.out.println(str2);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Test
    public void test6(){
        String s1 = "ab";
        String s2 = "abkkcadkabkebfkabkskab";
        System.out.println(numberOfString(s1,s2));
    }

    @Test
    public void test7(){
        String str1 = "abhellocwerthellobyuiodellobnf";
        String str2 = "cvhellobmhellobn";
        System.out.println(maxSubString(str1,str2));
    }

    public static String newTrim(String a){
        for (int i = 0; i < a.length()-1; i++) {
            if(a.charAt(0) == ' ')
                a = a.substring(1);
            else
                break;
        }
        for (int i = a.length()-1; i >= 0; i--) {
            if(a.charAt(i) == ' ')
                a = a.substring(0,i);
            else
                break;
        }
        return a;
    }

    public static String newReserve(String a,int b,int c) throws Exception{
        if(a == null) return null;
        if(b > c || b < 0 || c >= a.length())
            throw new Exception("输入有误");
        //方式一
/*        char[] chars = a.toCharArray();
        for (int i = b; i <= c; i++) {
            chars[i] = a.charAt(c+b-i);
        }
        a = new String(chars);
        return a;*/
        //方式二
//        String reserveA = a.substring(0,b);
//        for (int i = c; i >= b; i--) {
//            reserveA += a.charAt(i);
//        }
//        reserveA += a.substring(c+1);
//        return reserveA;
        //方式三 效率高
        StringBuffer stringBuffer = new StringBuffer(a.length());
        stringBuffer.append(a.substring(0,b));
        for (int i = c; i >= b; i--) {
            stringBuffer.append(a.charAt(i));
        }
        stringBuffer.append(a.substring(c+1));
        return stringBuffer.toString();
    }

    public static int numberOfString(String a,String b){
        String temp;
        int count = 0;
        if (a.length() > b.length()){
            temp = a;
            a = b;
            b = temp;
        }
        for (int i = 0; i < b.length(); i++) {
            if (b.startsWith(a, i)){
                count ++;
            }
/*            if (i+a.length() <= b.length() &&
                    b.substring(i,i+a.length()).equals(a)){
                count ++;
            }*/
        }
        return count;
    }

    public static List<String> maxSubString(String a, String b){
        String temp;
        String sub = "";
//        int len1;
//        int len2;
//        int len3;
        ArrayList<String> list = new ArrayList<>();
        if (a.length() < b.length()){
            temp = a;
            a = b;
            b = temp;
        }
        //方法一：依次查找子集
/*        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                len3 = b.length();
                if(i + j < len3 && a.contains(b.substring(i,len3-j))) {
                    len1 = sub.length();
                    len2 = b.substring(i, b.length()-j).length();
                    if(len1 == len2){
                        sub = b.substring(i, b.length()-j);
                        if(!list.contains(sub))
                            list.add(sub);
                    }
                    if(len1 < len2) {
                        list = new ArrayList<>();
                        sub = b.substring(i, b.length() - j);
                        list.add(sub);
                    }
                }
            }
        }*/
        //方法二，从大到小查找子集
        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if(a.contains(b.substring(j,b.length()-i+j))){
                    //1、若满足条件的子集长度变小，跳出循环
//                    len1 = b.substring(j,b.length()-i+j).length();
//                    if(len1 < sub.length()) break;
                    sub = b.substring(j,b.length()-i+j);
                    if(!list.contains(sub))
                        list.add(sub);
                }
            }
            //2、若找到子集，跳出循环，此时所有同长度子集都已查过
            if(list.size() > 0) break;
        }
        return list;
    }
}
