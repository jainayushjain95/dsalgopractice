import java.util.*;

public class Subsets2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = new Subsets2().subsetsWithDup(nums);
        System.out.println(subsets);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return  subsetsBitsMasking(nums);
    }

    public void subsetsBacktrack(int[] nums, int currIndex, List<Integer> currentSet, List<List<Integer>> subsets) {
        if(currIndex == nums.length) {
            subsets.add(currentSet);
            return;
        }

        subsetsBacktrack(nums, currIndex + 1, new ArrayList<>(currentSet), subsets);

        currentSet.add(nums[currIndex]);
        subsetsBacktrack(nums, currIndex + 1, new ArrayList<>(currentSet), subsets);
    }

    public List<List<Integer>> subsetsBitsMasking(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        Set<String> sets = new HashSet<>();
        subsets.add(new ArrayList<>());
        int noOfSubsets = (int)Math.pow(2, nums.length);
        for(int i = 1;i < noOfSubsets; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            int index = nums.length - 1;
            List<Integer> curr = new ArrayList();
            int bitSet = i;
            while(bitSet > 0) {
                if(isLastBitSet(bitSet)) {
                    curr.add(0, nums[index]);
                    stringBuilder.append((nums[index]));
                    stringBuilder.append(".");
                }
                index--;
                bitSet = bitSet >> 1;
            }
            String set = stringBuilder.toString();
            if(!sets.contains(set)) {
                subsets.add(curr);
                sets.add(set);
            }
        }
        return subsets;
    }

    public boolean isLastBitSet(int bitSet) {
        return (bitSet & 1) > 0;
    }
}
