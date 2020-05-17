package leetcode;

import java.util.Scanner;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x){
        val = x;
        next = null;
    }

    public void BuildList(){
        Scanner sc = new Scanner(System.in);
        int judge = sc.nextInt();
        if(judge == 1){
            next = new ListNode(sc.nextInt());
            next.BuildList();
        }
    }

    public void print(ListNode head){
        if(head == null){
            return;
        }
        System.out.print(head.val);
        while(head.next != null){
            head = head.next;
            System.out.print(" " + head.val);
        }
    }
}
