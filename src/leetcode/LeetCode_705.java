package leetcode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 705. 设计哈希集合
 *
 * @Author: Xinil
 * @Date: 2021/3/13 14:24
 */
public class LeetCode_705 {
    class MyHashSet {
        private static final int BASE = 769;
        private LinkedList[] data;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            data = new LinkedList[BASE];
            for (int i = 0; i < BASE; ++i) {
                data[i] = new LinkedList<Integer>();
            }
        }

        public void add(int key) {
            int h = hash(key);
            Iterator<Integer> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Integer element = iterator.next();
                if (element == key) {
                    return;
                }
            }
            data[h].offerLast(key);
        }

        public void remove(int key) {
            int h = hash(key);
            Iterator<Integer> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Integer element = iterator.next();
                if (element == key) {
                    data[h].remove(element);
                    return;
                }
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int h = hash(key);
            Iterator<Integer> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Integer element = iterator.next();
                if (element == key) {
                    return true;
                }
            }
            return false;
        }

        private int hash(int key) {
            return key % BASE;
        }
    }
}
