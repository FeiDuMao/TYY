package leetcode;

public class Offer51 {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     * 示例 1:
     * 输入: [7,5,6,4]
     * 输出: 5
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        int ans=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if (nums[i]>nums[j]){
                    ans++;
                }
            }
        }
        return ans;
    }
}
