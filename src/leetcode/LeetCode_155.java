package leetcode;

import java.util.Scanner;

public class LeetCode_155 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MinStack stack = new MinStack();
        for(int i=0; i<n; ++i){
            char a = sc.next().charAt(0);
            if(a == '+'){
                stack.push(sc.nextInt());
            }else if(a == '-'){
                stack.pop();
            }else if(a == '#'){
                System.out.println(stack.top());
            }else if(a == 'm'){
                System.out.println(stack.getMin());
            }
        }
        sc.close();
    }
}

class MinStack {
    int[] stack = new int[153908]; //存放进栈元素 ('153908'面向测试样例编程)
    int[] minStack = new int[153908]; //辅助栈存放前i个q进栈元素的最小值
    int i;
    public MinStack() {
        i=0;
    }

    public void push(int x) {
        stack[i] = x;
        if(i>0 && minStack[i-1]<x){
            minStack[i] = minStack[i-1];
        }else{
            minStack[i] = x;
        }
        ++i;
    }

    public void pop() {
        --i;
    }

    public int top() {
        return stack[i-1];
    }

    public int getMin() {
        return minStack[i-1];
    }
}