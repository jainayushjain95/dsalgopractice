import java.util.ArrayList;
import java.util.List;

class Pair {
    int left;
    int right;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class IntervalListIntersections {
    public static void main(String[] args) {
        int[][] firstList = {
                {0, 2}, {5, 10}, {13, 23}, {24, 25}
        };
        int[][] secondList = {
                {1, 5}, {8, 12}, {15, 24}, {25, 26}
        };
        int[][] solve = new IntervalListIntersections().intervalIntersection(firstList, secondList);
        for(int[] pair : solve) {
            System.out.println(pair[0] + ", " + pair[1]);
        }
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<Pair> list = new ArrayList<>();
        int i = 0, j = 0;

        while(i < firstList.length && j < secondList.length) {
            int low = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(firstList[i][1], secondList[j][1]);

            if(low <= high) {
                list.add(new Pair(low, high));
            }

            if(firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        int[][] solve = new int[list.size()][2];
        int index = 0;

        for(Pair pair : list) {
            solve[index][0] = pair.left;
            solve[index++][1] = pair.right;
        }
        return solve;
    }
}
