package DP;

public class ClimbingStairs {

    int[] dp;

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(3));
    }

    public int climbStairs(int n) {
        dp = new int[n + 1];
        return climbStairsSolve3(n);
    }

    //Top to bottom
    public int climbStairsSolve1(int n) {
        if(n <= 1) {
            return 1;
        }
        return climbStairsSolve1(n - 1) + climbStairsSolve1(n - 2);
    }

    //Top to bottom Memo
    public int climbStairsSolve2(int n) {
        if(n <= 1) {
            return 1;
        }
        if(dp[n] > 0) {
            return dp[n];
        }
        dp[n] = climbStairsSolve2(n - 1) + climbStairsSolve2(n - 2);
        return dp[n];
    }

    //Bottom up
    public int climbStairsSolve3(int n) {
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2;i < dp.length; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }


}
