package leetcode;

import java.util.Scanner;

public class LeetCode_128 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        Solution_128 sol = new Solution_128();
        System.out.println(sol.longestConsecutive(nums));
    }
}

class Solution_128 { //遍历一遍，用单链表去记录序列
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        ListNode_128 head = new ListNode_128(0), p, n;
        head.next = new ListNode_128(nums[0]);
        for (int i = 1; i < nums.length; ++i) { //遍历数组元素
            p = head;
            int k = 0;
            while (p.next != null) { //插入至链表中
                if (nums[i] < p.next.start - 1) { //头部加入新结点
                    n = p.next;
                    p.next = new ListNode_128(nums[i]);
                    p.next.next = n;
                    k = 1;
                    break;
                } else if (p.next.start - 1 == nums[i]) { //--结点start值
                    k = 1;
                    --p.next.start;
                    break;
                } else if (nums[i] <= p.next.end) { //值已经包含，不需要操作链表
                    k = 1;
                    break;
                } else if (nums[i] == p.next.end + 1) { //++结点end值
                    ++p.next.end;
                    k = 1;
                    break;
                }
                p = p.next;
            }
            if (k == 0) { //未操作链表，在末尾插入数组元素
                p.next = new ListNode_128(nums[i]);
            }
        }
        int max = 0, num = head.next.end - head.next.start + 1, end = head.next.end;
        max = num;
        p = head.next;
        while (p.next != null) {
            if (end >= p.next.end) {  //前一个链表变化容纳了后一个链表。
                p = p.next;
                continue;
            }
            if (end + 1 >= p.next.start) { //续上了
                num += p.next.end - end;
            } else {
                num = p.next.end - p.next.start + 1;
            }
            end = p.next.end;
            max = Math.max(max, num);
            p = p.next;
        }
        return max;
    }
}

class ListNode_128 {
    int start, end;
    ListNode_128 next;

    ListNode_128(int n) {
        start = end = n;
        next = null;
    }
}