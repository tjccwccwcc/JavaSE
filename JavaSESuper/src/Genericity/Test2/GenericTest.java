package Genericity.Test2;

import org.junit.Test;

import java.util.*;

/**
 *
 * 1. 泛型在继承方面的体现
 *
 *
 * 2. 通配符的使用
 *
 * @author date
 * @create 2023 下午 2:13
 */
public class GenericTest {

    /*
    1. 泛型在继承方面的体现

      虽然类A是类B的父类，但是G<A> 和G<B>二者不具备子父类关系，二者是并列关系。

       补充：类A是类B的父类，A<G> 是 B<G> 的父类

     */
    @Test
    public void test1(){

        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;
        //编译不通过
//        Date date = new Date();
//        str = date;
        List<Object> list1 = null;
        List<String> list2 = new ArrayList<String>();
        //此时的list1和list2的类型不具有子父类关系
        //编译不通过
//        list1 = list2;
        /*
        反证法：
        假设list1 = list2;
           list1.add(123);导致混入非String的数据。出错。

         */

        show(list1);
        show1(list2);

    }



    public void show1(List<String> list){

    }

    public void show(List<Object> list){

    }

    @Test
    public void test2(){

        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;

        list1 = list3;
        list2 = list3;

        List<String> list4 = new ArrayList<>();

    }

    /*
    2. 通配符的使用
       通配符：?

       类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>


     */

    @Test
    public void test3(){
        //编译时错误因为我们不知道c 的元素类型，我们
        //不能向其中添加对象。add 方法有类型参数E 作为集合的元素类型。我们
        //传给add 的任何参数都必须是一个未知类型的子类。因为我们不知道那是
        //什么类型，所以我们无法传任何东西进去。
//        Collection<?> c = new ArrayList();
//        c.add(new Object());

        List<Object> list1 = null;
//        List<String> list2 = null;
        List<String> list2 = Arrays.asList("AA","BB");

        List<?> list = null;

        list = list1;
        list = list2;

//        System.out.println(list);
        //编译通过
//        print(list1);
//        print(list2);


        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
//        print(list);
        //添加(写入)：对于List<?>就不能向其内部添加数据。
        //除了添加null之外。
//        list.add("DD");
//        list.add('?');

        list.add(null);

        //获取(读取)：允许读取数据，读取的数据类型为Object。
        Object o = list.get(0);
        System.out.println(o);
    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    /*
    3.有限制条件的通配符的使用。
        ? extends A:
                G<? extends A> 可以作为G<A>和G<B>的父类，其中B是A的子类

        ? super A:
                G<? super A> 可以作为G<A>和G<B>的父类，其中B是A的父类

     */
    @Test
    public void test4(){

        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;



/*
        使用了<? extends Person>作为List的泛型，这表示List的元素类型可能
        是Person或者Person的子类，但是你不能往里面添加任何元素。因为编译器
        无法确定List实际存储的是什么类型，所以为了安全起见，它只允许你从中取出
        元素，而不是添加。

        <? super Person>泛型允许添加元素的原因是，它表示List的元素类型可能
        是Person或者Person的父类，所以你可以往里面添加Person或者Person的子
        类。因为编译器知道List至少能存储Person类型的对象，所以它不会报错。但是
        你不能从中取出元素，因为编译器无法确定List实际存储的是什么类型，所以为了
        安全起见，它只允许你取出Object类型的对象
 */
        //读取数据：
        list1 = list3;
        Person p = list1.get(0);
        //编译不通过
//        Student s = list1.get(0);

//        Person p1 = new Student();
        //编译不通过
//        Student s1 = new Person();

        list2 = list4;
        Object obj = list2.get(0);
        ////编译不通过
//        Person obj = list2.get(0);



        //写入数据：
//        list1.add(new Student());
//        list1.add(new Person());

        //编译通过
        list2.add(new Person());
        list2.add(new Student());

    }

}
