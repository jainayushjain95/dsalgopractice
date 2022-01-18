public class MinimumSwapsToGroupAll1sTogether {
    public static void main(String[] args) {
        int[] data = {1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1};
        System.out.println(new MinimumSwapsToGroupAll1sTogether().minSwaps(data));
    }

    public int minSwaps(int[] data) {
        int length = getNoOfOnes(data);
        return length - getLongestOneLength(data, length);
    }

    public int getNoOfOnes(int[] data) {
        int count = 0;
        for(int x : data) {
            if(x == 1) {
                count++;
            }
        }
        return count;
    }

    public int getLongestOneLength(int[] data, int length) {
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            if(data[i] == 1) {
                maxLength++;
            }
        }

        int currLength = maxLength;

        for(int i = 1; i <= data.length - length; i++) {
            currLength = currLength - data[i - 1] + data[i + length - 1];
            maxLength = Math.max(maxLength, currLength);
        }

        return maxLength;
    }
}
