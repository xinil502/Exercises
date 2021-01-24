package leetcode;

import java.util.*;

/**
 * 5646.需要教语言的最少人数
 * <p>
 * 在一个由 m 个用户组成的社交网络里，我们获取到一些用户之间的好友关系。两个用户之间可以相互沟通的条件是他们都掌握同一门语言。
 * <p>
 * 给你一个整数 n ，数组 languages 和数组 friendships ，它们的含义如下：
 * <p>
 * 总共有 n 种语言，编号从 1 到 n 。
 * languages[i] 是第 i 位用户掌握的语言集合。
 * friendships[i] = [u​​​​​​i​​​, v​​​​​​i] 表示 u​​​​​​​​​​​i​​​​​ 和 vi 为好友关系。
 * <p>
 * 你可以选择 一门 语言并教会一些用户，使得所有好友之间都可以相互沟通。请返回你 最少 需要教会多少名用户。
 * 请注意，好友关系没有传递性，也就是说如果 x 和 y 是好友，且 y 和 z 是好友， x 和 z 不一定是好友。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, languages = [[1],[2],[1,2]], friendships = [[1,2],[1,3],[2,3]]
 * 输出：1
 * 解释：你可以选择教用户 1 第二门语言，也可以选择教用户 2 第一门语言。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 3, languages = [[2],[1,3],[1,2],[3]], friendships = [[1,4],[1,2],[3,4],[2,3]]
 * 输出：2
 * 解释：教用户 1 和用户 3 第三门语言，需要教 2 名用户。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 500
 * languages.length == m
 * 1 <= m <= 500
 * 1 <= languages[i].length <= n
 * 1 <= languages[i][j] <= n
 * 1 <= u​​​​​​i < v​​​​​​i <= languages.length
 * 1 <= friendships.length <= 500
 * 所有的好友关系 (u​​​​​i, v​​​​​​i) 都是唯一的。
 * languages[i] 中包含的值互不相同。
 */
public class LeetCode_5646 {

    class Solution {
        public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                map.put(i, new HashSet<>());
            }
            for (int i = 0; i < friendships.length; ++i) {
                int a = friendships[i][0] - 1;
                int b = friendships[i][1] - 1;
                int[] aa = languages[a];
                int[] bb = languages[b];
                boolean judge = true;
                for (int z = 0; z < aa.length; ++z) {
                    for (int x = 0; x < bb.length; ++x) {
                        if (aa[z] == bb[x]) {
                            judge = false;
                        }
                    }
                }
                if (judge) {
                    for (Iterator<Integer> ite = map.keySet().iterator(); ite.hasNext(); ) {
                        int k = ite.next();
                        boolean q = c(k, aa);
                        boolean p = c(k, bb);
                        if (q) {
                            Set<Integer> s = map.get(k);
                            s.add(b);
                            map.put(k, s);
                        } else if (p) {
                            Set<Integer> s = map.get(k);
                            s.add(a);
                            map.put(k, s);
                        } else {
                            Set<Integer> s = map.get(k);
                            s.add(b);
                            s.add(a);
                            map.put(k, s);
                        }
                    }
                }
            }
            int min = 10000;
            for (Iterator<Integer> ite = map.keySet().iterator(); ite.hasNext(); ) {
                int s = map.get(ite.next()).size();
                if (s != 0) {
                    min = Math.min(min, s);
                }
            }
            if (min == 10000) {
                return 0;
            }
            return min;
        }

        boolean c(int a, int[] b) {
            for (int i : b) {
                if (i == a) {
                    return true;
                }
            }
            return false;
        }
    }

}
