package Aggregate.Collection_tool;

import org.junit.Test;

import java.util.*;

/*
操作数组的工具类：Arrays；
Arrays.fill(List, val) 将List中所有元素换为val
Collections 是一个操作Set、List 和Map 等集合的工具类；
Collections 中提供了一系列静态的方法对集合元素进行排序、查询和修改等操作，还提供了对集合对象设置不可变、对集合对象实现同步控制等方法。
排序操作：（均为 static 方法）
    reverse(List)：反转 List 中元素的顺序。
    shuffle(List)：对 List 集合元素进行随机排序。
    sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序。
    sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序。
    swap(List，int，int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换。

·reverse(List lis)：反转 List 中元素的顺序；
·shuffle(List lis)：对 List 集合元素进行随机排序；
·sort(List lis)：根据元素的自然顺序对指定 List 集合元素按升序排序；
·sort(List lis, Comparator col)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序；
·swap(List lis, int i, int j)：将指定 list 集合中的 i 处元素和 j 处元素进行交换；
·Object max(Collection col)：根据元素的自然顺序，返回给定集合中的最大元素。
·Object max(Collection col,Comparator com)：根据 Comparator 指定的顺序，返回给定集合中的最大元素；
·Object min(Collection col)；
·Object min(Collection col,Comparator com)；
·int frequency(Collection col, Object obj)：返回指定集合中指定元素的出现次数；
·void copy(List dest, List src)：将 src 中的内容复制到 dest 中；
·boolean replaceAll(List lis, Object oldVal, Object newVal)：使用新值替换 List 对象的所有旧值。
 */

public class CollectionToolTest {
    @Test
    public void test() {
        List list = new ArrayList();
        list.add(123); list.add(43); list.add(765);
        list.add(765); list.add(765);
        list.add(-97); list.add(0);
        System.out.println(list);
//        Collections.reverse(list);
//        Collections.shuffle(list);
//        Collections.sort(list);
//        Collections.swap(list,1,2);
        int frequency = Collections.frequency(list, 765);
        System.out.println(list);
        System.out.println(frequency);
    }
    @Test
    public void test2() {
        List list = new ArrayList();
        list.add(123); list.add(43);
        list.add(765); list.add(-97);
        list.add(0);
//        报异常：IndexOutOfBoundsException("Source does not fit in dest")
//        List dest = new ArrayList();
//        Collections.copy(dest,list);
        // 正确的：
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());// list.size();
        Collections.copy(dest, list);
        System.out.println(dest);
        // 2
        List dest1 = new ArrayList();
        for(Object obj : list) {
            Collections.addAll(dest1, obj);
        }
        System.out.println(dest1);
        // 返回的list1 即为线程安全的List
        List list1 = Collections.synchronizedList(list);
        System.out.println(list1);
    }
}
