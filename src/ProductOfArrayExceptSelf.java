public class ProductOfArrayExceptSelf {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] answer = new ProductOfArrayExceptSelf().productExceptSelf(nums);
        for(int x : answer) {
            System.out.println(x);
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        setLefts(nums, answer);
        setRights(nums, answer);
        return answer;
    }

    public void setLefts(int[] nums, int[] answer) {
        answer[0] = 1;
        for(int i = 1;i < nums.length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
    }

    public void setRights(int[] nums, int[] answer) {
        int prod = nums[nums.length - 1];
        for(int i = nums.length - 2;i >= 0; i--) {
            answer[i] = prod * answer[i];
            prod = prod * nums[i];
        }
    }
}
