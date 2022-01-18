import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(new SubarraySumEqualsK().subarraySum(nums, 2));
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0;i < nums.length; i++) {
            prefixSum += nums[i];
            count += map.getOrDefault(prefixSum - k, 0);
            map.put(prefixSum, 1 + map.getOrDefault(prefixSum, 0));
        }
        return count;
    }
}
