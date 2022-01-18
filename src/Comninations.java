import java.util.*;

public class Comninations {
    public static void main(String[] args) {
        List<List<Integer>> combinations = new Comninations().combine(4, 2);
        System.out.println(combinations);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        solve(n, k, combinations, new ArrayList<>(), 1);
        return combinations;
    }

    public void solve(int n, int k, List<List<Integer>> combinations, List<Integer> combination, int currentNumber) {
        if(combination.size() == k) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for(int number = currentNumber; number <= n; number++) {
            combination.add(number);
            solve(n, k, combinations, combination, number + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
