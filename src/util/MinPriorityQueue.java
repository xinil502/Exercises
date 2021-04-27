package util;

import java.util.Comparator;

/**
 * @Author: Xinil
 * @Date: 2021/4/17 14:37
 */
public class MinPriorityQueue<T> {
    private T[] items;

    private int N;

    private Comparator e;

    public MinPriorityQueue(int size, Comparator<? super T> e) {
        items = (T[]) new Object[size + 1];
        this.e = e;
        N = 0;
    }

    /**
     * 获取队列中元素的个数
     */
    public int size() {
        return N;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 获得队列中最小的元素
     */
    public T findMin() {
        return items[1];
    }

    /**
     * 删除队列中最小的元素,并返回这个最小元素
     */
    public T delMin() {
        T max = items[1];
        exch(1, N);
        items[N] = null;
        N--;
        sink(1);
        return max;
    }

    /**
     * 往队列中插入一个元素
     */
    public void insert(T o) {
        N++;
        items[N] = o;
        swim(N);
    }

    /**
     * 判断堆中索引i处的元素是否大于索引j处的元素(与维护的优先队列相反，便于上浮下沉时进行判断)
     */
    private boolean more(int i, int j) {
        return e.compare(items[i], items[j]) > 0;
    }

    /**
     * 交换堆中i索引和j索引处的值
     */
    private void exch(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    /**
     * 使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
     */
    private void swim(int k) {
        while (k > 1) {
            if (more(k / 2, k)) { //结点 k 比父节点小，就要上浮。
                exch(k / 2, k);
                k /= 2;
            } else {
                break;
            }
        }
    }

    /**
     * 使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
     */
    private void sink(int k) {
        while (k * 2 <= N) {
            //找到子结点中的较小者
            int min = 2 * k;
            if (2 * k + 1 <= N) {//存在右子结点
                if (more(2 * k, 2 * k + 1)) {//且右子节点值更小
                    min = 2 * k + 1;
                }
            }

            //比较当前结点和子结点中的较大者
            if (more(k, min)) {
                exch(k, min);
                k = min;
            } else {
                break;
            }

        }
    }
}
