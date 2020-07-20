package leetcode;

import java.util.*;

/**
 * LeetCode_1169.查询无效交易。
 */
public class LeetCode_1169 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] transactions = new String[n];
        for (int i = 0; i < n; ++i) {
            transactions[i] = sc.next();
        }

        Solution_1169 sol = new Solution_1169();
        System.out.println(sol.invalidTransactions(transactions));
    }
}


class Solution_1169 {
    public List<String> invalidTransactions(String[] transactions) {
        List<Node_1169> l = new ArrayList<>();
        for (int i = 0; i < transactions.length; ++i) {
            String[] str = transactions[i].split(",");
            Node_1169 node = new Node_1169();
            node.name = str[0];
            node.time = Integer.valueOf(str[1]);
            node.price = Integer.valueOf(str[2]);
            node.city = str[3];
            l.add(node);
        }

        Set<String> str = new HashSet<>();

        for (int i = l.size() - 1; i >= 0; --i) { //金额超过1000
            if (l.get(i).price > 1000) {
                str.add("" + l.get(i).name + "," + l.get(i).time + "," + l.get(i).price + "," + l.get(i).city);
            }
        }
        for (int i = 0; i < l.size(); ++i) {
            for (int j = 0; j < l.size(); ++j) {
                if (l.get(i).name.equals(l.get(j).name) && !l.get(i).city.equals(l.get(j).city) && Math.abs(l.get(i).time - l.get(j).time) <= 60) {
                    str.add("" + l.get(j).name + "," + l.get(j).time + "," + l.get(j).price + "," + l.get(j).city);
                    str.add("" + l.get(i).name + "," + l.get(i).time + "," + l.get(i).price + "," + l.get(i).city);
                }
            }
        }

        List<String> list = new ArrayList<>();
        for (Iterator<String> ite = str.iterator(); ite.hasNext(); ) {
            list.add(ite.next());
        }
        return list;
    }
}

class Node_1169 {
    String name;
    int time;
    int price;
    String city;
}