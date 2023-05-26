package JavaSE_Class.Test_AnonymousObject;

public class AllTest {
    public static void main(String[] args){
        method1(new Student());//匿名对象

        Student s = new Student();
        method(s);//非匿名类和非匿名对象

        //创建匿名子类的对象p
        Person p = new Person() {
            @Override
            public void eat() {
                System.out.println("爱吃饭");
            }
        };
        method(p);

        //创建匿名子类的匿名对象
        method(new Person() {
            @Override
            public void eat() {
                System.out.println("不爱吃饭");
            }
        });
    }
    public static void method(Person p){
        p.eat();
    }
    public static void method1(Student s){
        s.eat();
    }
}
