public class MinimumMovesToEqualArrayElements {

    public static void main(String[] args) {

    }

    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int x : nums) {
            min = Math.min(min, x);
            sum += x;
        }
        return sum - min * nums.length;
    }


}
