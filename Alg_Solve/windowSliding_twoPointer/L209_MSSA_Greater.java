import java.io.IOException;

public class L209_MSSA_Greater {
    public static void main(String[] args) throws IOException {
        int target = 11;
        int[] nums = new int[] {1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen(target, nums));

    }
    public static int minSubArrayLen(int target, int[] nums) {
        int totalCnt = Integer.MAX_VALUE;
        int[] memo = new int[nums.length + 1];
        int tail = 0;
        boolean canMake = false;
        for (int i = 1 ; i <= nums.length ; i++) {
            memo[i] = memo[i - 1] + nums[i - 1];

            if (memo[i] >= target) {
                canMake = true;
                while (memo[i] >= target) {
                    totalCnt = Math.min(totalCnt, i - tail);
                    memo[i] -= nums[tail++];
                }
            }
        }
        if (canMake) return totalCnt;
        else return 0;
    }
}
