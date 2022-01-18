public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(new MaxConsecutiveOnes3().longestOnes(nums, 3));
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, noOfZeroes = 0;
        int maxLength = 0;

        while(right < nums.length) {
            if(nums[right] == 0) {
                noOfZeroes++;
            }

            while(noOfZeroes > k) {
                if(nums[left] == 0) {
                    noOfZeroes--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);

            right++;
        }

        return maxLength;
    }

}
