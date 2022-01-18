import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = new Permutations().permute(nums);
        System.out.println(permutations);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        solve2(permutations, nums, 0);
        return permutations;
    }

    public void solve2(List<List<Integer>> permutations, int[] nums, int currentIndex) {
        if(currentIndex == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for(int x : nums) {
                permutation.add(x);
            }
            permutations.add(permutation);
            return;
        }

        for(int index = currentIndex; index < nums.length; index++) {
            swap(nums, currentIndex, index);
            solve2(permutations, nums, currentIndex + 1);
            swap(nums, currentIndex, index);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void solve1(boolean[] visited, List<List<Integer>> permutations, List<Integer> permutation, int[] nums) {
        if(permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for(int index = 0;index < nums.length; index++) {
            if(!visited[index]) {
                visited[index] = true;
                permutation.add(nums[index]);
                solve1(visited, permutations, permutation, nums);
                permutation.remove(permutation.size() - 1);
                visited[index] = false;
            }
        }
    }
}
