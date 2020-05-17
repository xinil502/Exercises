package leetcode;

import java.util.Scanner;

public class LeetCode_25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = new ListNode(sc.nextInt());
        head.BuildList();
        int k = sc.nextInt();

        Solution_25 sol = new Solution_25();
        head.print(sol.reverseKGroup(head, k));
    }
}

class Solution_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k==0 || k==1){ //不需要反转直接返回。
            return head;
        }
        ListNode p, q , l , r, t;
        l = p = q = r = t = head;
        while(true){
            for(int i=0; i<k; ++i){ //判断是否满足k个去旋转。
                if(p == null){
                    return head;// 不满足旋转条件直接返回head
                }
                p = p.next;
            }
            p = q; //移回p
            r = r.next; // r出发
            for(int i=1; i<k; ++i){ //子链表内部反转
                q = r;
                r = r.next;
                q.next = p;
                p = q;
            }
            if(head == l){  //如果是第一次反转，。
                head = p;// 改变head的位置，
                t = p = q = r; //并将tpq置于与未遍历的链表头。
            }else{ //如果不是第一次反转，
                l.next = q; //将子链表连接到已经反转好的链表尾部。
                l = t; //更改连接好的链表尾部为当前子链表的尾部
                t = q = p = r;//并将tpq置于与未遍历的链表头。
            }
            l.next = r; //连接子链表尾部与未遍历的链表头。
        }
    }
}