public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        new SortColors().sortColors(nums);
        for(int x : nums) {
            System.out.println(x);
        }
    }

    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;
        while(i <= k) {
            if(nums[i] == 0) {
                swap(nums, i++, j++);
            } else if(nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, k--);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
