package leetcode;

import java.util.Scanner;

/*
将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class LeetCode_21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode l1 = new ListNode(sc.nextInt());
        l1.BuildList();
        ListNode l2 = new ListNode(sc.nextInt());
        l2.BuildList();

        Solution_21 sol = new Solution_21();
        l1 = sol.mergeTwoLists(l1, l2);
        while(l1 != null){
            System.out.print(l1.val+" ");
            l1 = l1.next;
        }
    }
}

class Solution_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){ //若有一个链表为空，则返回另一个链表。
            return l2;
        }else if(l2 == null){
            return  l1;
        }
        ListNode list, head;  //创建链表头结点
        if(l1.val<l2.val){
            head = list = new ListNode(l1.val);
            l1 = l1.next;
        }else {
            head = list = new ListNode(l2.val);
            l2 = l2.next;
        }
        while(true){  //有一个链表为空时，，将另一个链表接上并返回。
            if(l1 == null){
                list.next = l2;
                break;
            }
            if(l2 == null){
                list.next = l1;
                break;
            }
            if(l1.val<l2.val){  //比较大小，，将较小的值续在后面。
                list.next = l1;
                l1 = l1.next;
                list = list.next;
            }else {
                list.next = l2;
                l2 = l2.next;
                list = list.next;
            }
        }
        return head;
    }
}