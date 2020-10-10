package leetcode;

import java.util.Scanner;

/**
 * LeetCode_142.环形链表Ⅱ
 * <p>
 * 环形链表寻找入环结点：(快慢指针)
 * 1.快指针为NULL，无环。
 * 2.两指针最终相遇。
 * 1.假设头结点距离环入口为a步， 环长为b步。
 * 2.快指针的步数是慢指针的两倍。    fastLength = 2 * slowLength
 * 3.假设快指针比满指针夺走了n圈。   fastLength = nb + slowLength
 * 4.解得 slowLength = nb  慢指针从出发到相遇也是走了n圈。
 * 5.思考：a+nb刚好在入环点。因此只要让慢指针再走a步，就可以到达入环点。
 * 6.让fast回到头结点，与慢指针同时出发，一次一步，两指针相遇，得到入环点。
 */
public class LeetCode_142 {
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

        Solution_142 sol = new Solution_142();
        System.out.println(sol.detectCycle(list).val);
    }
}

class Solution_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast, slow;
        fast = slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (true) {
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        return fast;
    }
}