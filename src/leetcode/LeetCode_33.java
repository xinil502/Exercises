package leetcode;

import java.util.Scanner;

public class LeetCode_33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; ++i){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        Solution_33_1 sol = new Solution_33_1();
        System.out.println(sol.search(nums, target));
    }
}


class Solution_33_1 {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        //根据153，154题的解法先求出旋转点，比较端点值后，在有序的左部分或右部分使用二分搜索。
        int l = 0, r = nums.length - 1,mid;
        while (l < r) {
            mid = (l+r)/2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if(r == 0){  //根据旋转点 与 target值 确定新的有序数组区间
            l = 0;
            r = nums.length-1;
        }else if(target >=nums[0]){
            l = 0;
            --r;
        }else{
            r = nums.length - 1;
        }
        while (l < r) {  //经典的二分法查找target
            mid = (l+r)/2;
            if(nums[mid] == target){  //早找到早退出。
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        if(nums[r] == target){
            return r;
        }else{
            return -1;
        }
    }
}

class Solution_33_2{
    public int search(int[] nums, int target){
        if(nums.length == 0){
            return -1;
        }
        int l = 0, r = nums.length-1, mid;
        while(l < r){
            mid = (l+r)/2;
            if(nums[mid] == target){ //找到target！
                return mid;
            }

            //先判断mid在左部分还是右部分，再判断target在mid划分出来的左部分还是右部分。
            if(nums[mid] < nums[r]){
                if(nums[mid] < target && target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else{
                if(nums[l] <= target && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        if(nums[l] == target){
            return l;
        }else{
            return -1;
        }
    }
}
