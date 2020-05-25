package leetcode;

import java.util.Scanner;

public class LeetCode_146 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LRUCache_146 lru = new LRUCache_146(sc.nextInt());
        lru.put(sc.nextInt(), sc.nextInt());
        lru.put(sc.nextInt(), sc.nextInt());
        lru.put(sc.nextInt(), sc.nextInt());
        lru.put(sc.nextInt(), sc.nextInt());
        System.out.println(lru.get(sc.nextInt()));
        System.out.println(lru.get(sc.nextInt()));
        System.out.println(lru.get(sc.nextInt()));
        System.out.println(lru.get(sc.nextInt()));
        lru.put(sc.nextInt(), sc.nextInt());
        System.out.println(lru.get(sc.nextInt()));
    }
}

class LRUCache_146 { //使用链表
    ListNode_146 start, q, p;

    public LRUCache_146(int capacity) {
        q = start = new ListNode_146(capacity);
    }

    public int get(int key) {
        if (start.key == key) {
            return start.val;
        }
        p = start;
        int num = -1;
        while (p.next != null) {
            if (p.next.key == key) { //如果找到key值，，更新返回值num并截取该结点至链表头。
                num = p.next.val;
                q = start;
                start = p.next;
                p.next = p.next.next;
                start.next = q;
                break;
            }
            p = p.next;
        }
        return num;
    }

    public void put(int key, int value) { //若能找到该key，则提至表头，更新value
        if (this.get(key) != -1) {
            start.val = value;
        } else {  //若不能找到，则直接将链表的值向后推。
            int kk, vv;
            p = start;
            while (p != null) {
                kk = p.key;
                vv = p.val;
                p.key = key;
                p.val = value;
                key = kk;
                value = vv;
                p = p.next;
            }
        }
    }
}

class ListNode_146 {
    int key;
    int val;
    ListNode_146 next;

    public ListNode_146(int len) {
        key = -2147483648; //没有被使用过的key值初始化为最小int
        val = -1;
        if (len == 1) {
            next = null;
        } else {
            next = new ListNode_146(len - 1); //递归创建链表。
        }
    }
}