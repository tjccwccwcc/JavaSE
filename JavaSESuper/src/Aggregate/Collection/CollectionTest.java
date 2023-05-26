package Aggregate.Collection;

import org.junit.Test;

import java.util.*;

/**
 * 一、集合框架的概述
 *
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 *  说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi，数据库中）
 *
 * 2.1 数组在存储多个数据方面的特点：
 *      > 一旦初始化以后，其长度就确定了。
 *      > 数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
 *       比如：String[] arr;int[] arr1;Object[] arr2;
 * 2.2 数组在存储多个数据方面的缺点：
 *      > 一旦初始化以后，其长度就不可修改。
 *      > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 *      > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *      > 数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 *
 * 二、集合框架
 *      |----Collection接口：单列集合，用来存储一个一个的对象
 *          |----List接口：存储有序的、可重复的数据。  -->“动态”数组
 *              |----ArrayList、LinkedList、Vector
 *
 *          |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 *              |----HashSet、LinkedHashSet、TreeSet
 *
 *      |----Map接口：双列集合，用来存储一对(key - value)一对的数据   -->高中函数：y = f(x)
 *              |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *
 * 三、Collection接口中的方法的使用
 *
 * @author date
 * @create 2022-11-16 16:40
 */
public class CollectionTest {
    @Test
    public void test(){
        Collection coll = new ArrayList();

        //add(Object obj)
        coll.add("AA");
        coll.add(123);
        coll.add(new Date());
        System.out.println(coll);
        System.out.println(coll.size());

        //addAll(Collection col)
        Collection coll1 = new ArrayList();
        coll1.add("CC");
        coll1.add(456);
        coll.addAll(coll1);
        System.out.println(coll);
        System.out.println(coll.size());

        //clear()
        coll.clear();

        //isEmpty()
        System.out.println(coll.isEmpty());
    }

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        Person jerry = new Person("Jerry", 20);
        Person jerry1 = new Person("Jerry", 20);
        coll.add(123);
        coll.add(false);
        coll.add(new String("Tom"));
        coll.add(jerry);

        //contains():调用equals()方法
        System.out.println(coll.contains(123));
//        System.out.println("Tom" == new String("Tom"));
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(jerry1));//有四个元素，比四次

        //containsAll(Collection col)
        Collection coll1 = Arrays.asList(123,false);
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        Person jerry = new Person("Jerry", 20);
        coll.add(123);
        coll.add(false);
        coll.add(new String("Tom"));
        coll.add(jerry);
        coll.add(456);

        //remove()
        coll.remove(123);
        System.out.println(coll.remove(1234));
        System.out.println(coll);
        coll.remove(new Person("Jerry", 20));
        System.out.println(coll);

        //removeAll(Collection col)
        Collection coll1 = Arrays.asList(456,false);
        System.out.println(coll.removeAll(coll1));
        System.out.println(coll);
    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        Collection coll1 = Arrays.asList(456,false,789,"Cat");
        Person jerry = new Person("Jerry", 20);
        coll.add(123);
        coll.add(false);
        coll.add(new String("Tom"));
        coll.add(jerry);
        coll.add(456);

        //retainAll(Collection col)
        coll.retainAll(coll1);
        System.out.println(coll);

        //equals(Object obj)
//        Collection coll2 = Arrays.asList(456,false,789,"Cat");
        //ArrayList有序
        Collection coll2 = Arrays.asList(false,456,789,"Cat");
        System.out.println(coll1.equals(coll2));
    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        Person jerry = new Person("Jerry", 20);
        coll.add(123);
        coll.add(false);
        coll.add(new String("Tom"));
        coll.add(jerry);
        coll.add(456);

        //hashCode()
        System.out.println(coll.hashCode());

        //toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //asList
//        String[] str = {"123"};
//        String[] str1 = new String[]{"456"};
        List<String> strings = Arrays.asList(new String[]{"123", "456", "AA", "abB"});
        System.out.println(strings);

        List<int[]> ints = Arrays.asList(new int[]{123, 456});
        List ints1 = Arrays.asList(123,456);
        List<Integer> integers = Arrays.asList(new Integer[]{123, 456});
        System.out.println(ints);
        System.out.println(ints1);
        System.out.println(integers);
    }

    @Test
    public void IteratorTest(){
        Person jerry = new Person("Jerry", 20);
        Collection coll = Arrays.asList(123,false,"Tom",jerry,456);

        Iterator iterator = coll.iterator();
/*        for (int i = 0; i < coll.size() + 1; i++) {
            System.out.println(iterator.next());
        }*/

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //错误写法，会报错且跳着输出
/*        while (iterator.next() != null){
            System.out.println(iterator.next());
        }*/

        //错误写法，会死循环
/*        while (iterator.hasNext()){
            System.out.println(coll.iterator().next());
        }*/
    }

    @Test
    public void removeTest(){
        Person jerry = new Person("Jerry", 20);
        Collection coll = new ArrayList<>(Arrays.asList(123,false,"Tom",jerry,456));
        System.out.println(coll.getClass());
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
//            iterator.remove();//IllegalStateException
            Object obj = iterator.next();
            if ("Tom".equals(obj)){
                iterator.remove();//Arrays.asList不允许remove
//                iterator.remove();//IllegalStateException
            }
        }
        Iterator iterator1 = coll.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }

    @Test
    public void forEachTest(){
        Person jerry = new Person("Jerry", 20);
        Collection coll = Arrays.asList(123,false,"Tom",jerry,456);
        System.out.println(coll.getClass());
        //内部仍然使用Iterator
        for(Object obj : coll){
            System.out.println(obj);
        }

        int[] arr = new int[]{1,2,3,4,5,6};
//        for(Object obj : arr){
        for(int i : arr){
            System.out.println(i);
        }
    }

    @Test
    public void xiaoTest(){
        String[] strings = new String[]{"DD","DD","DD"};
        for (int i = 0; i < strings.length; i++) {
            strings[i] = "GG";
        }
        for(String s : strings){//使用了新对象
            s = "MM";
        }
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + " ");
        }
    }
}

class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("you use my equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
