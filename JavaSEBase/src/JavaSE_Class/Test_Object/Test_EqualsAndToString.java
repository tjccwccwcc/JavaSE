package JavaSE_Class.Test_Object;

public class Test_EqualsAndToString {
    public static void main(String[] args){
        String str1 = null;
        String str2 = "null";
        EqualsAndToString test = new EqualsAndToString(1,1.0,str1);
        EqualsAndToString test1 = new EqualsAndToString(1,1.0,"");
        EqualsAndToString test2 = new EqualsAndToString(1,1.0,str1);
        System.out.println(test.equals(test1));
        System.out.println(test1.equals(test2));
        System.out.println(test);
        System.out.println(test1.toString());
        System.out.println(test2.toString());
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str1 == str2);
        System.out.println(str1 == null);
        System.out.println("*******************************");
        //System.out.println(str1.toString());//报错
        //System.out.println(str1.equals(str2));//报错
    }
}
