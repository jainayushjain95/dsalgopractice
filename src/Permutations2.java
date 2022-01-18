import java.util.*;

public class Permutations2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> permutations = new Permutations2().permuteUnique(nums);
        System.out.println(permutations);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> freqMap = getFreqMap(nums);
        List<List<Integer>> permutations = new ArrayList<>();
        solve(nums.length, freqMap, permutations, new ArrayList<>());
        return permutations;
    }

    public void solve(int n, Map<Integer, Integer> freqMap, List<List<Integer>> permutations, List<Integer> permutation) {
        if(permutation.size() == n) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for(int element : freqMap.keySet()) {
            if(freqMap.get(element) > 0) {
                freqMap.put(element, freqMap.get(element) - 1);
                permutation.add(element);

                solve(n, freqMap, permutations, permutation);

                permutation.remove(permutation.size() - 1);
                freqMap.put(element, freqMap.get(element) + 1);
            }
        }
    }

    public Map<Integer, Integer> getFreqMap(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int x : nums) {
            freqMap.put(x, 1 + freqMap.getOrDefault(x, 0));
        }
        return freqMap;
    }
}
