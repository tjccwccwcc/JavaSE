package Aggregate.Map;

import java.util.*;


public class Person {
    private Integer age;

    public Person(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }


    public static void main(String[] args) {
        TreeMap<Person, String> treeMap = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                int num = person1.getAge() - person2.getAge();
                return Integer.compare(num, 0);
            }
        });
        treeMap.put(new Person(3), "person1");
        treeMap.put(new Person(18), "person2");
        treeMap.put(new Person(35), "person3");
        treeMap.put(new Person(16), "person4");
        long[] startTime = new long[7];
        long[] endTime = new long[7];
        //一:stream Api
        startTime[0] = System.nanoTime();
        treeMap.entrySet().stream().forEach(personStringEntry -> {
            System.out.println(personStringEntry.getValue());
        });
        //Stream 循环中删除数据非安全
//        treeMap.entrySet().stream().forEach(personStringEntry -> {
//            if (personStringEntry.getKey().equals(new Person(3))) {
//                System.out.println("del:" + personStringEntry.getKey());
//                treeMap.remove(personStringEntry.getKey());
//            } else {
//                System.out.println("show:" + personStringEntry.getKey());
//            }
//        });
        //Stream 循环的正确方式
//        treeMap.entrySet().stream().filter(m -> !m.getKey().
//                equals(new Person(3))).forEach((entry) -> {
//            if (entry.getKey().equals(new Person(3))) {
//                System.out.println("del:" + entry.getKey());
//            } else {
//                System.out.println("show:" + entry.getKey());
//            }
//        });
        endTime[0] = System.nanoTime();
        System.out.println("streamApi:" + (endTime[0] - startTime[0]));
        //多线程
        startTime[1] = System.nanoTime();
        treeMap.entrySet().parallelStream().forEach(personStringEntry -> {
            System.out.println(personStringEntry.getValue());
        });
        endTime[1] = System.nanoTime();
        System.out.println("parallelStreamApi:" + (endTime[1] - startTime[1]));
        //二:Lambda表达式
//        treeMap.entrySet().forEach(personStringEntry -> {
//            System.out.println(personStringEntry.getValue());
//        });
        startTime[2] = System.nanoTime();
        treeMap.forEach((key, value) -> System.out.println(value));
        //Lambda 循环中删除数据非安全
//        treeMap.forEach((key, value) -> {
//            if (key.equals(new Person(3))) {
//                System.out.println("del:" + key);
//                treeMap.remove(key);
//            } else {
//                System.out.println("show:" + key);
//            }
//        });
        //Lambda 删除的正确方式
//        treeMap.keySet().removeIf(key -> key.equals(new Person(3)));
//        treeMap.forEach((key, value) -> System.out.println(value));
        endTime[2] = System.nanoTime();
        System.out.println("Lambda表达式:" + (endTime[2] - startTime[2]));
        //三：ForEach 循环中删除数据非安全
        startTime[3] = System.nanoTime();
        for (Map.Entry<Person, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getValue());
        }
        endTime[3] = System.nanoTime();
        System.out.println("ForEach entry:" + (endTime[3] - startTime[3]));
        startTime[4] = System.nanoTime();
        for (Person key : treeMap.keySet()) {
            System.out.println(treeMap.get(key));
        }
        endTime[4] = System.nanoTime();
        System.out.println("ForEach key:" + (endTime[4] - startTime[4]));
        //四：迭代器 循环中删除数据安全
        startTime[5]= System.nanoTime();
        Iterator<Map.Entry<Person, String>> iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Person, String> entry = iterator.next();
            System.out.println(entry.getValue());
//            if (entry.getKey().equals(new Person(3))) {
//                // 删除
//                System.out.println("del:" + entry.getKey());
//                iterator.remove();
//            } else {
//                System.out.println("show:" + entry.getKey());
//            }
        }
        endTime[5] = System.nanoTime();
        System.out.println("迭代器 entry:" + (endTime[5] - startTime[5]));
        startTime[6] = System.nanoTime();
        Iterator<Person> iterator1 = treeMap.keySet().iterator();
        while (iterator1.hasNext()) {
            Person key = iterator1.next();
            System.out.println(treeMap.get(key));
        }
        endTime[6] = System.nanoTime();
        System.out.println("迭代器 key:" + (endTime[6] - startTime[6]));
    }
}