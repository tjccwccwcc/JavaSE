package Aggregate.Map;

import org.junit.Test;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/*
Map 的实现类的结构：
    |----Map：双列数据，存储key-value 对的数据
            --- 类似于高中的函数：y = f(x)；
        |----HashMap：作为Map 的主要实现类；线程不安全的，效率高；存储null 的key 和value；
            |----LinkedHashMap: 保证在遍历 map 元素时，可以按照添加的顺序实现遍历。
                原因：在原有的HashMap 底层结构基础上，添加了一对指针，指向前一个和后一个元素。
                    对于频繁的遍历操作，此类执行效率高于HashMap。
            |----TreeMap：保证按照添加的 key-value 对进行排序，实现排序遍历。此时考虑 key
                          的自然排序或定制排序底层使用红黑树；
            |----Hashtable：作为古老的实现类；线程安全的，效率低；不能存储 null的 key 和 value；
                |----Properties：常用来处理配置文件。key 和value 都是String类型。
        HashMap 的底层：数组+ 链表（jdk7 及之前）
                      数组+ 链表+ 红黑树（jdk 8）

Map 结构的理解：
    Map 中的 key：无序的、不可重复的，使用 Set 存储所有的 key ---> key 所在的类要重写 equals() 和 hashCode() （以 HashMap 为例）。
    Map 中的 value：无序的、可重复的，使用 Collection 存储所有的 value ---> value 所在的类要重写 equals()。
    一个键值对：key-value 构成了一个 Entry 对象。
    Map 中的 entry: 无序的、不可重复的，使用 Set 存储所有的 entry。

Map 中定义的方法：
    添加、删除、修改操作：
        ·Object put(Object key,Object value)：将指定 key-value 添加到(或修改)当前 map 对象中；
        ·void putAll(Map m): 将 m 中的所有 key-value 对存放到当前 map 中；
        ·Object remove(Object key)：移除指定 key 的 key-value 对，并返回 value；
        ·void clear()：清空当前 map 中的所有数据。

    元素查询的操作：
        ·Object get(Object key)：获取指定 key 对应的 value；
        ·boolean containsKey(Object key)：是否包含指定的 key；
        ·boolean containsValue(Object value)：是否包含指定的 value；
        ·int size()：返回 map 中 key-value 对的个数；
        ·boolean isEmpty()：判断当前 map 是否为空；
        ·boolean equals(Object obj)：判断当前 map 和参数对象 obj 是否相等。

    元视图操作的方法：
        ·Set keySet()：返回所有 key 构成的 Set 集合；
        ·Collection values()：返回所有 value 构成的 Collection 集合；
        ·Set entrySet()：返回所有 key-value 对构成的 Set 集。

    总结：常用方法：
        添加：put(Object key,Object value)
        删除：remove(Object key)
        修改：put(Object key,Object value)
        查询：get(Object key)
        长度：size()
        遍历：keySet() / values() / entrySet()
*/
/*
Map 实现类之一：HashMap
    ·HashMap 是 Map 接口使用频率最高的实现类。
    ·允许使用 null 键和 null 值，与 HashSet 一样，不保证映射的顺序。
    ·所有的 key 构成的集合是 Set：无序的、不可重复的。所以，key 所在的类要重写：equals() 和 hashCode()。
    ·所有的 value 构成的集合是 Collection：无序的、可以重复的。所以，value 所在的类要重写：equals()。
    ·一个 key-value 构成一个 entry。
    ·所有的 entry 构成的集合是 Set：无序的、不可重复的。
    ·HashMap 判断两个 key 相等的标准是：两个 key 通过 equals() 方法返回 true，hashCode 值也相等。
    ·HashMap 判断两个 value 相等的标准是：两个 value 通过equals() 方法返回 true。

HashMap 源码中的重要常量
    ·DEFAULT_INITIAL_CAPACITY：HashMap 的默认容量，16；
    ·MAXIMUM_CAPACITY：HashMap 的最大支持容量，2^30；
    ·DEFAULT_LOAD_FACTOR：HashMap 的默认加载因子；0.75
    ·TREEIFY_THRESHOLD：Bucket 中链表长度大于该默认值，转化为红黑树；8
    ·UNTREEIFY_THRESHOLD：Bucket 中红黑树储存的 Node 小于该默认值，转化为链表；
    ·MIN_TREEIFY_CAPACITY：桶中的 Node 被树化时最小的 hash 表容量；64
    ·数量大道需要变红黑树时，若 hash 表容量小于 MIN_TREEIFY_CAPACITY 时，此时应执行；
    ·resize 扩容操作这个 MIN_TREEIFY_CAPACITY 的值至少是 TREEIFY_THRESHOLD 的 4 倍。）；
    ·table：储存元素的数组，总是2 的n 次幂；
    ·entrySet：储存具体元素的集；
    ·size：HashMap 中储存的键值对的数量；
    ·modCount：HashMap 扩容和结构改变的次数；
    ·threshold：扩容的临界值，= 容量* 填充因子；16 * 0.75 => 12
    ·loadFactor：填充因子。

HashMap 的底层实现原理
    jdk7 说明：
        HashMap 的内部存储结构其实是数组和链表的结合。当实例化一个 HashMap 时，系统会创建一个长度为 Capacity 的 Entry 数组，这个长度在哈
        希表中被称为容量(Capacity)，在这个数组中可以存放元素的位置我们称之为“桶”(bucket)，每个 bucket 都有自己的索引，系统可以根据索引快速
        的查找 bucket 中的元素。每个 bucket 中存储一个元素，即一个 Entry 对象，但每一个 Entry 对象可以带一个引用变量，用于指向下一个元素，
        因此，在一个桶中，就有可能生成一个 Entry 链。而且新添加的元素作为链表的head。

        HashMap map = new HashMap()：
            在实例化以后，底层创建了长度是 16 的一维数组 Entry[] table。
            ... 可能已经执行过多次 put...
            map.put(key1,value1)：
            首先，调用 key1 所在类的 hashCode() 计算 key1 哈希值，此哈希值经过某种算法计算以后，得到在 Entry 数组中的存放位置。
            如果此位置上的数据为空，此时的 key1-value1 添加成功。-- 情况1
            如果此位置上的数据不为空，(意味着此位置上存在一个或多个数据(以链表形式存在)), 比较 key1 和已经存在的一个或多个数据的哈希值：
                如果 key1 的哈希值与已经存在的数据的哈希值都不相同，此时 key1-value1 添加成功。-- 情况2
                如果 key1 的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同，继续比较：
                调用 key1 所在类的 equals(key2) 方法，比较：
                    如果equals() 返回 false：此时 key1-value1 添加成功。-- 情况3
                    如果equals() 返回 true：使用 value1 替换value2。

            补充：关于情况2 和情况3：此时 key1-value1 和原来的数据以链表的方式存储。
            在不断的添加过程中，会涉及到扩容问题，当超出临界值(且要存放的位置非空)时，扩容。默认的扩容方式：扩容为原来容量的2倍，并将原
        有的数据复制过来。

    HashMap 的扩容：
        当 HashMap 中的元素越来越多的时候，hash 冲突的几率也就越来越高，因为数组的长度是固定的。所以为了提高查询的效率，就要对 HashMap
        的数组进行扩容，而在 HashMap 数组扩容之后，最消耗性能的点就出现了：原数组中的数据必须重新计算其在新数组中的位置，并放进去，这就是
        resize。

    HashMap 什么时候进行扩容：
        当 HashMap 中的元素个数超过数组大小 (数组总大小 length,不是数组中个数 size)*loadFactor 时，就会进行数组扩容，loadFactor 的默
        认值 (DEFAULT_LOAD_FACTOR) 为 0.75，这是一个折中的取值。也就是说，默认情况下，数组大小 (DEFAULT_INITIAL_CAPACITY) 为 16，
        那么当 HashMap 中元素个数超过 16*0.75=12（这个值就是代码中的 threshold 值，也叫做临界值）的时候，就把数组的大小扩展为 2*16=32，
        即扩大一倍，然后重新计算每个元素在数组中的位置，而这是一个非常消耗性能的操作，所以如果我们已经预知 HashMap 中元素的个数，那么预设元素的
        个数能够有效的提高 HashMap 的性能。

    jdk8 相较于 jdk7 在底层实现方面的不同：
        HashMap 的内部存储结构其实是数组+链表+红黑树的结合。当实例化一个 HashMap 时，会初始化 initialCapacity 和 loadFactor，
        在 put 第一对映射关系时，系统会创建一个长度为 initialCapacity 的 Node 数组，这个长度在哈希表中被称为容量(Capacity)，在
        这个数组中可以存放元素的位置我们称之为“桶”(bucket)，每个 bucket 都有自己的索引，系统可以根据索引快速的查找 bucket 中的元素。

        每个 bucket 中存储一个元素，即一个 Node 对象，但每一个 Node 对象可以带一个引用变量 next，用于指向下一个元素，因此，在一个桶
        中，就有可能生成一个 Node 链。也可能是一个一个 TreeNode 对象，每一个 TreeNode 对象可以有两个叶子结点 left 和 right，因此，
        在一个桶中，就有可能生成一个 TreeNode 树。而新添加的元素作为链表的 last，或树的叶子结点。

        总结：
        1.new HashMap(): 底层没有创建一个长度为 16 的数组；
        2.jdk 8 底层的数组是：Node[], 而非 Entry[]；
        3.首次调用 put() 方法时，底层创建长度为 16 的数组；
        4.jdk7 底层结构只有：数组+ 链表。jdk8 中底层结构：数组+ 链表+ 红黑树。
            4.1 形成链表时，七上八下（jdk7：新的元素指向旧的元素。jdk8：旧的元素指向新的元素）；
            4.2 当 HashMap 中的其中一个链的对象个数如果达到了 8 个，此时如果 capacity 没有达到 64，那么 HashMap 会先扩容解决，
                如果已经达到了 64，那么这个链会变成红黑树，结点类型由 Node 变成 TreeNode 类型。当然，如果当映射关系被移除后，下次
                resize 方法时判断树的结点个数低于 6个，也会把红黑树再转为链表。

    关于映射关系的 key 是否可以修改？ answer：不要修改
        映射关系存储到 HashMap 中会存储 key 的 hash 值，这样就不用在每次查找时重新计算每一个 Entry 或 Node（TreeNode）的 hash 值了，
        因此如果已经 put 到 Map 中的映射关系，再修改 key 的属性，而这个属性又参与 hashcode 值的计算，那么会导致匹配不上。
*/
/*
Map 实现类之二：LinkedHashMap
    LinkedHashMap 是 HashMap 的子类。
    在 HashMap 存储结构的基础上，使用了一对双向链表来记录添加元素的顺序。
    与 LinkedHashSet 类似，LinkedHashMap 可以维护 Map 的迭代顺序：迭代顺序与 Key-Value 对的插入顺序一致。

    HashMap 中的内部类：Node。
    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;
    }

    LinkedHashMap 中的内部类：Entry
    static class Entry<K, V> extends HashMap.Node<K, V> {
        Entry<K, V> before, after; // 能够记录添加的元素的先后顺序
        Entry(int hash, K key, V value, Node<K, V> next) {
            super(hash, key, value, next);
        }
    }
 */
/*
Map 实现类之三：TreeMap
    ·TreeMap 存储 Key-Value 对时，需要根据 key-value对进行排序。TreeMap 可以保证所有的 Key-Value 对处于有序状态。
    ·TreeSet 底层使用红黑树结构存储数据。
    ·TreeMap 的 Key 的排序：
        ·自然排序：TreeMap 的所有的 Key 必须实现 Comparable 接口，而且所有的 Key 应该是同一个类的对象，否则将会抛出
                ClassCastException。
        ·定制排序：创建 TreeMap 时，传入一个 Comparator 对象，该对象负责对 TreeMap 中的所有 key 进行排序。此时不需
                要 Map 的 Key 实现 Comparable 接口。
    ·TreeMap 判断两个 key 相等的标准：两个 key 通过 compareTo() 方法或者 compare() 方法返回 0。
 */
/*
Map 实现类之四：Hashtable
    ·Hashtable 是个古老的 Map 实现类，JDK1.0 就提供了。不同于 HashMap，Hashtable 是线程安全的。
    ·Hashtable 实现原理和 HashMap 相同，功能相同。底层都使用哈希表结构，查询速度快，很多情况下可以互用。
    ·与 HashMap 不同，Hashtable 不允许使用 null 作为 key 和 value。
    ·与 HashMap 一样，Hashtable 也不能保证其中 Key-Value 对的顺序。
    ·Hashtable 判断两个 key 相等、两个 value 相等的标准与HashMap 一致。
 */
/*
Map 实现类之五：Properties
    ·Properties 类是 Hashtable 的子类，该对象用于处理属性文件。
    ·由于属性文件里的 key、value 都是字符串类型，所以 Properties 里的 key 和 value 都是字符串类型。
    ·存取数据时，建议使用setProperty(String key,String value) 方法和 getProperty(String key) 方法。

    Properties pros = new Properties();
    pros.load(new FileInputStream("jdbc.properties"));
    String user - pros.getProperty("user");
    System.out.println(user);
 */

public class MapTest {
    /**
     * 元素查询的操作：
     Object get(Object key)：获取指定key 对应的value ；
     boolean containsKey(Object key)：是否包含指定的key ；
     boolean containsValue(Object value)：是否包含指定的value ；
     int size()：返回map 中key-value 对的个数 ；
     boolean isEmpty()：判断当前map 是否为空；
     boolean equals(Object obj)：判断当前map 和参数对象obj 是否相等。
     */
    @Test
    public void test() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);
        // Object get(Object key)
        System.out.println(map.get(45));
        // containsKey(Object key)
        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);
        isExist = map.containsValue(123);
        System.out.println(isExist);
        map.clear();
        System.out.println(map.isEmpty());
    }
    /**
     * 添加、删除、修改操作：
     Object put(Object key,Object value)：将指定key-value 添加到( 或修改)
     当前map 对象中；
     void putAll(Map m):将m 中的所有key-value 对存放到当前map 中
     Object remove(Object key)： 移除指定key 的key-value 对， 并返回
     value
     void clear()：清空当前map 中的所有数据
     */
    @Test
    public void test1() {
        Map map = new HashMap();
        // 添加
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);
        // 修改
        map.put("AA", 87);
        System.out.println(map);
        Map map1 = new HashMap();
        map1.put("CC", 123);
        map1.put("DD", 456);
        map.putAll(map1);
        System.out.println(map);
        // remove(Object key)
        Object value = map.remove("CC");
        System.out.println(value);
        System.out.println(map);
        // clear()
        map.clear();// 与map = null 操作不同
        System.out.println(map.size());
        System.out.println(map);
    }
    /**
     元视图操作的方法： Set keySet()：返回所有key 构成的Set 集合
     Collection values()：返回所有value 构成的Collection 集合
     Set entrySet()：返回所有key-value 对构成的Set 集合
     */
    @Test
    public void test2() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 1234);
        map.put("BB", 56);
        // 遍历所有的key 集：keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("*****************");
        // 遍历所有的values 集：values()
        Collection values = map.values();
        for (Object obj : values) {
            System.out.println(obj);
        }
        System.out.println("***************");
        // 遍历所有的key-values
        // 方式一：
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            // entrySet 集合中的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.
                    getValue());
        }
        System.out.println("/");
        // 方式二：
        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while (iterator2.hasNext()) {
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "=====" + value);
        }
    }

    /**
     * 面试题：
     * 1. HashMap 的底层实现原理？
     * 2. HashMap 和 Hashtable 的异同？
     *      2.1.HashMap 与 Hashtable 都实现了 Map 接口。由于H ashMap 的非线程安全性，效率上可能高于 Hashtable。
     *          Hashtable 的方法是 Synchronize 的，而 HashMap 不是，在多个线程访问 Hashtable 时，不需要自己为
     *          它的方法实现同步，而 HashMap 就必须为之提供外同步。
     *      2.2.HashMap 允许将 null 作为一个 entry 的 key 或者 value，而 Hashtable不允许。
     *      2.3.HashMap 把 Hashtable 的 contains 方法去掉了，改成 containsvalue 和 containsKey。因为 contains
     *          方法容易让人引起误解。
     *      2.4.Hashtable 继承自 ictionary 类，而 HashMap 是 Java1.2 引进的 Map interface 的一个实现。
     *      2.5.Hashtable 和 HashMap 采用的 hash/rehash 算法都大概一样，所以性能不会有很大的差异。
     * 3. CurrentHashMap 与 Hashtable 的异同？（暂时不讲）
     */
    @Test
    public void test3() {
        Map map = new HashMap();
        // map = new Hashtable();
        map.put(null, 123);
    }
    @Test
    public void test4(){
        Map map = new ConcurrentHashMap();
        map.put(new User("Tom",12), 123);
        map.put(new User("Tom",13), 456);
        map.put(45, 123);
        map.put("BB", 56);
        map.put("AA", 87);
        System.out.println(map);
    }
}


class User implements Comparable{
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("User equals()....");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

//        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() { //return name.hashCode() + age;
        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + age;
        return result;
    }

    //按照姓名从大到小排列,年龄从小到大排列
    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User user = (User)o;
//            return -this.name.compareTo(user.name);
            int compare = -this.name.compareTo(user.name);
            if(compare != 0){
                return compare;
            }else{
                return Integer.compare(this.age,user.age);
            }
        }else{
            throw new RuntimeException("输入的类型不匹配");
        }

    }
}