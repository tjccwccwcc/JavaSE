package JavaSE_Class.Test_InnerClass;

public class InnerClassTest {
    public static void main(String[] args) {
        Person.Brain p = new Person.Brain();
        p.think();
//        Person.eyes p = new Person.eyes();
        Person p1 = new Person();
        Person.Eyes p2 = p1.new Eyes();
        p2.see();
        p2.display("小丑");
    }
}
class Person{
    String name = "牛逼";
    int age;
    public void eat(){
        System.out.println("吃饭");
    }
    //静态成员内部类
//    abstract static class brain{
    static class Brain{
        String structure;
        public Brain(){}
        public void think(){
            System.out.println("思考");
//            eat();
        }
    }
    //非静态成员内部类
//    final class eyes{
     class Eyes{
        String construction;
        String name = "牛逼之眼";
        public void see(){
            System.out.println("看东西");
            eat();
            Person.this.eat();
        }
        public void display(String name){
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Person.this.name);
            System.out.println(age);
        }
    }
    public void method(){
        //局部内部类
        class AA{

        }
    }
    {
        //局部内部类
        class BB{

        }
    }
    public Person(){
        //局部内部类
        class CC{

        }
    }

    //返回一个实现Comparable接口的对象
    public Comparable getComparable(){
        //创建一个实现该接口的局部内部类
        //方式一
//        class MyComparable implements Comparable{
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        }
//        return new MyComparable();

        //方式二
        //匿名实现类的匿名对象
        return new Comparable(){
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
}
