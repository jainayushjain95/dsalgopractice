import java.util.*;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = new Subsets().subsetsBitsMasking(nums);
        System.out.println(subsets);
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

    public void setSubsets(int[] nums, List<List<Integer>> subsets, int currentIndex) {
        if(currentIndex >= nums.length) {
            return;
        }
        setSubsets(nums, subsets, currentIndex + 1);
        int size = subsets.size();
        for(int i = 0;i < size; i++) {
            LinkedList<Integer> subset = new LinkedList<Integer>(subsets.get(i));
            subset.addFirst(nums[currentIndex]);
            subsets.add(subset);
        }

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsetsBacktrack(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    public void subsetsBacktrack(int[] nums, int currIndex, List<Integer> currentSet, List<List<Integer>> subsets) {
        if(currIndex == nums.length) {
            subsets.add(new ArrayList<>(currentSet));
            return;
        }

        subsetsBacktrack(nums, currIndex + 1, currentSet, subsets);

        currentSet.add(nums[currIndex]);
        subsetsBacktrack(nums, currIndex + 1, currentSet, subsets);
        currentSet.remove(currentSet.size() - 1);
    }





}
