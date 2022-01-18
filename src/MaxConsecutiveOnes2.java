public class MaxConsecutiveOnes2 {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};
        System.out.println(new MaxConsecutiveOnes2().findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0;
        int left = 0, right = 0, noOfZeroes = 0;

        while(right < nums.length) {
            if(nums[right] == 0) {
                noOfZeroes++;
            }
            while(noOfZeroes == 2) {
                if(nums[left] == 0) {
                    noOfZeroes--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return  maxLength;
    }
}
