package leetcode;

import java.util.Scanner;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
        val = 0;
        next = null;
    }
    public ListNode(int x){
        val = x;
        next = null;
    }

    public void BuildList(){
        Scanner scanner = new Scanner(System.in);
        int judge = scanner.nextInt();
        ListNode node = this;
        this.val = scanner.nextInt();
        while (1 == scanner.nextInt()) {
            node.next = new ListNode(scanner.nextInt());
            node = node.next;
        }
    }

    public static ListNode createList() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (0 == n) {
            scanner.close();
            return null;
        }
        ListNode head, p;
        head = p = new ListNode();
        while (0 != n--) {
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
        }
        return head.next;
    }

    public void BuildList(int len) {
        Scanner scanner = new Scanner(System.in);
        val = scanner.nextInt();
        ListNode p = this;
        while (len != 1) {
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
            --len;
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

    @Override
    public String toString() {
        ListNode p = this;
        StringBuffer sb = new StringBuffer();
        while (p != null) {
            sb.append(p.val);
            p = p.next;
        }
        return sb.toString();
    }
}
