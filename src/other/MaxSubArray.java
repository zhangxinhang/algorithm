package other;

public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = -1000000;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum > ans) {
                ans = sum;
            }
            if (sum < 0) {
                sum = 0;   //子串和为负数，丢掉
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(nums));
    }
}
