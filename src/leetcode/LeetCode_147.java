package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 147. 对链表进行插入排序
 */
public class LeetCode_147 {
    public static void main(String[] args) {
        ListNode head = Utils.createList();

        Solution_147 sol = new Solution_147();
        sol.insertionSortList(head).print();
    }
}

class Solution_147 {
    public ListNode insertionSortList(ListNode head) { //原地插入
        List<Integer> nums = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            nums.add(p.val);
            p = p.next;
        }
        nums.sort(Comparator.comparingInt(a -> a));
        p = head;
        while (p != null) {
            p.val = nums.remove(0);
            p = p.next;
        }
        return head;
    }
}