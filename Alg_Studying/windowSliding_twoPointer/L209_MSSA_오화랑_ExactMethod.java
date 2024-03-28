import java.io.IOException;

public class L209_MSSA_오화랑_ExactMethod {
    static boolean canMake;
    public static void main(String[] args) throws IOException {
        int target = 20;
        int[] nums = new int[] {2, 16, 14, 15};
        System.out.println(minSubArrayLen(target, nums));

    }
    public static int minSubArrayLen(int target, int[] nums) {
        int[] weightMemo = new int[target];
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] > target) continue;

            for (int w = target - nums[i]  - 1 ; w >= 0  ; w--) {
                if (weightMemo[w] > 0) {
                    weightMemo[w + nums[i]] = weightMemo[w + nums[i]] == 0
                            ? weightMemo[w] + 1 : Math.min(weightMemo[w + nums[i]], weightMemo[w] + 1);
                }
            }
            weightMemo[nums[i] - 1] = 1;

        }
        return weightMemo[target - 1];
    }
}