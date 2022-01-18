import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        new NextPermutation().nextPermutation(nums);
        for(int x : nums) {
            System.out.println(x);
        }
    }

    public void nextPermutation(int[] nums) {
        int pivotIndex = getPivotIndex(nums);
        if(pivotIndex == -1) {
            Arrays.sort(nums);
        } else {
            int nextElementIndex = getNextElementIndex(nums, pivotIndex);
            swap(nums, pivotIndex, nextElementIndex);
            reverse( nums, pivotIndex + 1, nums.length - 1);
        }
    }

    public void reverse(int[] nums, int beginIndex, int endIndex) {
        while(beginIndex < endIndex) {
            swap(nums, beginIndex, endIndex);
            beginIndex++;
            endIndex--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int getNextElementIndex(int[] nums, int pivotIndex) {
        int nextElementIndex = nums.length - 1;
        while(nextElementIndex >= 0 && nums[nextElementIndex] <= nums[pivotIndex]) {
            nextElementIndex--;
        }
        return nextElementIndex;
    }

    public int getPivotIndex(int[] nums) {
        int pivotIndex = -1;
        for(int i = nums.length - 2;i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                pivotIndex = i;
                break;
            }
        }
        return pivotIndex;
    }

}
