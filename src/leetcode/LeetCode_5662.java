package leetcode;

/**
 * 5662. 满足三条件之一需改变的最少字符数
 */
public class LeetCode_5662 {

    class Solution {
        public int minCharacters(String a, String b) {
            int min1 = 0, min2 = Integer.MAX_VALUE, min3 = Integer.MAX_VALUE;
            char[] charA = a.toCharArray();
            char[] charB = b.toCharArray();

            //统计字符串中字符的出现次数
            int[] countA = new int[26];
            int[] countB = new int[26];
            for (char i : charA) ++countA[i - 97];
            for (char i : charB) ++countB[i - 97];

            //找出出现次数最多的字符（第一种条件）
            for (int i = 0; i < 26; ++i) {
                min1 = Math.max(min1, countA[i] + countB[i]);
            }
            min1 = a.length() + b.length() - min1;

            /**
             * 遍历一遍数组，索引值指向i，
             * aa数组 i索引值 左边的所有字符都要改成最大的
             * bb数组 i索引值 右边的所有字符都要改成最小的
             * 即可满足要求a全部大于b
             */
            int ka = 0, kb = charB.length;
            for (int i = 0; i < 25; ++i) {
                ka += countA[i];
                kb -= countB[i];
                min2 = Math.min(ka + kb, min2);
            }

            ka = charA.length;
            kb = 0;
            for (int i = 0; i < 25; ++i) {
                ka -= countA[i];
                kb += countB[i];
                min3 = Math.min(ka + kb, min3);
            }
            System.out.println(min1 + "-" + min2 + "-" + min3);
            return Math.min(min3, Math.min(min1, min2));
        }
    }

}
