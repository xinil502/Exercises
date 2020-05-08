package leetcode;
/*
LeetCode_33题延伸题目,数组中存在重复数字。
 */
import java.util.Scanner;

public class LeetCode_81 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int target = sc.nextInt();
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n; ++i){
            num[i] = sc.nextInt();
        }


        Solution_81 sol = new Solution_81();
        System.out.println(sol.search(num, target));
    }
}

class Solution_81 {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){ //判断空数组或长度为空。
            return false;
        }
        int l=0, r = nums.length-1, mid;
        while(l<r){ //寻找旋转点
            mid = (l+r)/2;
            if(nums[mid] == nums[r] && nums[r-1]<=nums[r]){
                //中间和右端相等 且 右端自减不会跳到左半部分时，如：11111111111211111111111
                --r;
            }else if(nums[mid] >= nums[r]){  //左端大于等于右端时。
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        if(l == 0){ //数组无旋转，整体升序。
            l = 0;
            r = nums.length - 1;
        }else if(target >= nums[0]){  //位于左边
            l = 0;
            --r;  //r不为零，可以自减。
        }else{ //位于右边
            r = nums.length - 1;
        }
        while(l < r){
            mid = (l+r)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid; //mid其实已经偏左了.
            }
        }
        if(nums[l] == target){
            return true;
        }else{
            return false;
        }
    }
}