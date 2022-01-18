public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int index = new SearchInRotatedSortedArray().search(nums, 0);
        System.out.println(index);
    }

    public int search(int[] nums, int target) {
        int beginIndex = 0, endIndex = nums.length - 1;
        while(beginIndex <= endIndex) {
            int midIndex = getMidIndex(beginIndex, endIndex);
            if(nums[midIndex] == target) {
                return midIndex;
            } else if(nums[midIndex] >= nums[beginIndex]) {
                if(nums[beginIndex] <= target && nums[midIndex] >= target) {
                    endIndex = midIndex;
                } else {
                    beginIndex = midIndex + 1;
                }
            } else {
                if(nums[endIndex] >= target && nums[midIndex] <= target) {
                    beginIndex = midIndex;
                } else {
                    endIndex = midIndex -1;
                }
            }
        }
        return -1;
    }

    public int getMidIndex(int beginIndex, int endIndex) {
        return (endIndex - beginIndex)/2 + beginIndex;
    }

}
