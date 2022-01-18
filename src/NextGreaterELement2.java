public class NextGreaterELement2 {

    public static void main(String[] args) {
        int n = 1999999999;
        int element = new NextGreaterELement2().nextGreaterElement(n);
        System.out.println(element);
    }

    public int nextGreaterElement(int n) {
        int[] digitsArray = getDigitsArray(n);
        int pivotIndex = getPivotIndex(digitsArray);

        if(pivotIndex != -1) {
            int nextGreaterIndexFromRight = getNextGreaterIndexFromRight(digitsArray, pivotIndex);
            swap(digitsArray, pivotIndex, nextGreaterIndexFromRight);
            reverse(digitsArray, pivotIndex + 1, digitsArray.length - 1);
            String num = getNumFromArray(digitsArray);
            try {
             return Integer.parseInt(num);
            } catch (Exception e) {
                return -1;
            }
        }
        return -1;
    }

    public static String getNumFromArray(int[] digitsArray) {
        String n = "";
        for(int i = digitsArray.length - 1;i >= 0; i--) {
            n = digitsArray[i] + n;
        }
        return n;
    }

    public static int getNextGreaterIndexFromRight(int[] digitsArray, int pivotIndex) {
        int nextGreaterIndexFromRight = digitsArray.length - 1;
        while(nextGreaterIndexFromRight >= 0 && digitsArray[nextGreaterIndexFromRight] <= digitsArray[pivotIndex]) {
            nextGreaterIndexFromRight--;
        }
        return nextGreaterIndexFromRight;
    }

    public static int[] getDigitsArray(int n) {
        int[] digitsArray = new int[(n + "").length()];
        int index = digitsArray.length - 1;

        while(n > 0) {
            digitsArray[index--] = n % 10;
            n = n / 10;
        }

        return digitsArray;
    }

    public static int getPivotIndex(int[] digitsArray) {
        int pivotIndex = -1;
        for(int i = digitsArray.length - 2;i >= 0; i--) {
            if(digitsArray[i] < digitsArray[i + 1]) {
                pivotIndex = i;
                break;
            }
        }
        return pivotIndex;
    }

    public void reverse(int[] nums, int beginIndex, int endIndex) {
        while(beginIndex < endIndex) {
            swap(nums, beginIndex, endIndex);
            beginIndex++;
            endIndex--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
