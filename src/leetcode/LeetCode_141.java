package leetcode;

import java.util.Scanner;

public class LeetCode_141 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode list, p;
        list = new ListNode();
        list.BuildList(sc.nextInt()); //输入链表总长度
        p = list;
        p.val = sc.nextInt();
        while (p.next != null) { //链表赋值
            p.next.val = sc.nextInt();
            p = p.next;
        }
        p.next = list.next.next; //默认循环至第二个结点

        Solution_141 sol = new Solution_141();
        System.out.println(sol.hasCycle(list));
    }
}

class Solution_141 { //快慢指针
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (true) {
            if (fast == slow) {
                return true;
            }
            if (fast.next == null || fast.next.next == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}