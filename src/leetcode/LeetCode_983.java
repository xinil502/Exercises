/*
在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。

火车票有三种不同的销售方式：


	一张为期一天的通行证售价为 costs[0] 美元；
	一张为期七天的通行证售价为 costs[1] 美元；
	一张为期三十天的通行证售价为 costs[2] 美元。


通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。

返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package leetcode;

import java.util.Scanner;

public class LeetCode_983 {
    public static void main(String[] args) {
        int m, n;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        int[] days = new int[m];
        int[] costs = new int[3];

        for(int i = 0; i<m; ++i){
            days[i] = sc.nextInt();
        }
        for(int i =0; i<3; ++i){
            costs[i] = sc.nextInt();
        }
        sc.close();

        Solution_983 sol = new Solution_983();
        System.out.println(sol.mincostTickets(days, costs));
    }
}

class Solution_983 {
    public int mincostTickets(int[] days, int[] costs) {
        int i, j;
        int[] sum = new int[366];
        int[] cost = new int[3];
        for(i=1, j=0; i<366; ++i){ //截至第i天，最少需要多少钱。
            if(i == days[j]){
                cost[0] = sum[i-1]+costs[0]; //买单日票多少钱
                cost[1] = 2147483647;
                cost[2] = 2147483647;
                if(i-7 >= 0){  //买周票最少多少钱。
                    cost[1] = sum[i-7] + costs[1];
                }else{
                    cost[1] = costs[1];
                }
                if(i-30>=0){   //买月票最少多少钱
                    cost[2] = sum[i-30] + costs[2];
                }else{
                    cost[2] = costs[2];
                }
                sum[i] = min(cost[0], cost[1], cost[2]);  //三种票比较，前i天最少花多少钱。
                ++j;
                if(j == days.length){
                    break;
                }
            }else{
                sum[i] = sum[i-1];
            }
        }
        return sum[i];
    }
    int min(int a,int b, int c){
        if(a<b&&a<c){
            return a;
        }
        return b<c?b:c;
    }
}