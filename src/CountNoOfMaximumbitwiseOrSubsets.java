import java.util.*;

public class CountNoOfMaximumbitwiseOrSubsets {

    int count;
    int maxOr;

    public static void main(String[] args) {
        int[] nums = {1, 4, 3};
        int maxCount = new CountNoOfMaximumbitwiseOrSubsets().countMaxOrSubsets(nums);
        System.out.println(1 | 4 | 3);
    }

    public int countMaxOrSubsets(int[] nums) {
        count = 0;
        maxOr = 0;
        countMaxOrSubsetsSolve(nums, 0, 0);
        return count;
    }

    public void countMaxOrSubsetsSolve(int[] nums, int currentIndex, int currOr) {
        if(currentIndex >= nums.length) {
            if(currOr > maxOr) {
                count = 1;
                maxOr = currOr;
            }  else if(currOr == maxOr){
                count++;
            }
            return;
        }

        countMaxOrSubsetsSolve(nums, currentIndex + 1, currOr | nums[currentIndex]);

        countMaxOrSubsetsSolve(nums, currentIndex + 1, currOr);
    }

    public int countMaxOrSubsetsBF2(int[] nums) {
        return countMaxFromSubsets(subsetsBitsMasking(nums));
    }

    public List<List<Integer>> subsetsBitsMasking(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int noOfSubsets = (int)Math.pow(2, nums.length);
        for(int i = 1;i < noOfSubsets; i++) {
            int index = nums.length - 1;
            List<Integer> curr = new ArrayList();
            int bitSet = i;
            while(bitSet > 0) {
                if(isLastBitSet(bitSet)) {
                    curr.add(0, nums[index]);
                }
                index--;
                bitSet = bitSet >> 1;
            }
            subsets.add(curr);
        }
        return subsets;
    }

    public boolean isLastBitSet(int bitSet) {
        return (bitSet & 1) > 0;
    }


    public int countMaxOrSubsetsBF1(int[] nums) {
        List<List<Integer>> subsets = getAllSubsets1(nums);
        return countMaxFromSubsets(subsets);
    }

    public List<List<Integer>> getAllSubsets1(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        getAllSubsets1Solve(nums, subsets, 0, new ArrayList<>());
        return subsets;
    }

    public void getAllSubsets1Solve(int[] nums, List<List<Integer>> subsets, int currentIndex, List<Integer> currentSubset) {
        if(currentIndex >= nums.length) {
            subsets.add(new ArrayList<>(currentSubset));
            return;
        }

        getAllSubsets1Solve(nums, subsets, currentIndex + 1, currentSubset);

        currentSubset.add(nums[currentIndex]);
        getAllSubsets1Solve(nums, subsets, currentIndex + 1, currentSubset);
        currentSubset.remove(currentSubset.size() - 1);
    }

    public int countMaxFromSubsets(List<List<Integer>> subsets) {
        int count = 0, maxOr = 0;
        for(int i = 1; i < subsets.size(); i++) {
            List<Integer> subset = subsets.get(i);
            int or = getOr(subset);
            if(or > maxOr) {
                count = 1;
                maxOr = or;
            }  else if(or == maxOr){
                count++;
            }
        }
        return count;
    }

    public int getOr(List<Integer> subset) {
        int or = subset.get(0);
        for(int i = 1;i < subset.size(); i++) {
            or = or | subset.get(i);
        }
        return or;
    }
}
