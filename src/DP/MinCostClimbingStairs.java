package DP;

public class MinCostClimbingStairs {

    int[] dp;

    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int mincost = new MinCostClimbingStairs().minCostClimbingStairs(cost);
        System.out.println(mincost);
    }

    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length + 1];
        for(int i = 0;i < dp.length; i++) {
            dp[i] = -1;
        }
        return minCostClimbingStairs1(cost, -1);
    }

    //Top down + Memo
    public int minCostClimbingStairs1(int[] cost, int currentIndex) {
        if(currentIndex >= cost.length) {
            return 0;
        }

        if(currentIndex > -1 && dp[currentIndex] != -1) {
            return dp[currentIndex];
        }

        int minCost = ((currentIndex > -1) ? cost[currentIndex] : 0) +
                Math.min(
                        minCostClimbingStairs1(cost, currentIndex + 1),
                        minCostClimbingStairs1(cost, currentIndex + 2)
                );
        if(currentIndex > -1) {
            dp[currentIndex] = minCost;
        }
        return  minCost;
    }

}
