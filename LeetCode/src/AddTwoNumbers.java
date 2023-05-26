import java.util.ArrayList;
/*
给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0开头。


示例 1：
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.

示例 2：
输入：l1 = [0], l2 = [0]
输出：[0]

示例 3：
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]

提示：
每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        int carry = 0;
        ArrayList value = new ArrayList();
        while(l1 != null || l2 != null){
            int num = l1 != null ? l1.val : 0;
            int num1 = l2 != null ? l2.val : 0;
            value.add((num + num1 + carry) % 10);
            carry = num + num1 + carry >= 10 ? 1 : 0;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            if (l1 == null && l2 == null && carry == 1)
                value.add(carry);
        }
        ListNode[] l4 = new ListNode[value.size()];
        for (int i = 0; i < l4.length; i++) {
            l4[i] = new ListNode();
        }
        for (int i = 0; i < value.size() - 1; i++) {
            l4[i].val = (int) value.get(i + 1);
            l4[i].next = l4[i + 1];
        }
        if (value.size() >= 2){
            l4[value.size() - 2].next = null;
            l3.val = (int) value.get(0);
            l3.next = l4[0];
        }
        else {
            l3.val = (int) value.get(0);
        }
        return l3;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode l4 = l3;
        int carry = 0;
        while(l1 != null || l2 != null){
            int num = l1 != null ? l1.val : 0;
            int num1 = l2 != null ? l2.val : 0;
            ListNode l5 = new ListNode((num + num1 + carry) % 10);
            l4.next = l5;
            l4 = l5;
            carry = num + num1 + carry >= 10 ? 1 : 0;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            if (l1 == null && l2 == null && carry == 1)
                l4.next = new ListNode(carry);
        }
        return l3.next;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l1 = new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9,
                        new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
//        ListNode l1 = new ListNode(0);
//        ListNode l2 = new ListNode(0);
        ListNode l3 = addTwoNumbers(l1, l2);
        ListNode l4 = addTwoNumbers1(l1, l2);
        while(l3 != null){
            System.out.print(l3.val);
            l3 = l3.next;
        }
        while(l4 != null){
            System.out.print(l4.val);
            l4 = l4.next;
        }
    }
}
