package leetcode;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode_648.单词替换
 */
public class LeetCode_648 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; ++i) {
            list.add(sc.next());
        }
        sc.nextLine();

        Solution_648 sol = new Solution_648();
        System.out.println(sol.replaceWords(list, sc.nextLine()));
    }
}

class Solution_648 {
    public String replaceWords(List<String> dict, String sentence) {
        String[] str = sentence.split(" ");
        String[] s = Arrays.copyOf(str, str.length);

        for (int i = 0; i < str.length; ++i) {
            for (int j = 0; j < dict.size(); ++j) {
                if (str[i].startsWith(dict.get(j))) {
                    if (s[i].length() > dict.get(j).length()) {
                        s[i] = dict.get(j);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s[0]);
        for (int i = 1; i < s.length; ++i) {
            sb.append(" " + s[i]);
        }
        return sb.toString();
    }
}