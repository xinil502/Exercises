package leetcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * LeetCode_1114.按序打印
 */
public class LeetCode_1114 {
}

class Foo {
    AtomicInteger secondStart = new AtomicInteger(0);
    AtomicInteger thirdStart = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        secondStart.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (secondStart.get() == 0) {
        }
        printSecond.run();
        thirdStart.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (thirdStart.get() == 0) {
        }
        printThird.run();
    }
}