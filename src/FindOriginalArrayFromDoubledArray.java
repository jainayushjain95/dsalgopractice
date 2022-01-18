import java.util.*;

public class FindOriginalArrayFromDoubledArray {
    public static void main(String[] args) {
        int[] changed = {4, 4};
        int[] originalArray = new FindOriginalArrayFromDoubledArray().findOriginalArray(changed);
        for(int x : originalArray) {
            System.out.println(x);
        }
    }

    public int[] findOriginalArray(int[] changed) {
        int[] originalArray = new int[0];
        boolean exists = true;
        if(changed.length % 2 == 0) {
            originalArray = new int[changed.length / 2];
            int index = 0;
            int max = getMax(changed);
            if(max % 2 == 0) {
                int[] freqArray = getFreqArray(changed, max);
                for(int i = 0;exists && i < freqArray.length; i++) {
                    while(freqArray[i] > 0) {
                        if(2*i <= max && freqArray[2 * i] > 0) {
                            freqArray[i]--;
                            freqArray[2 * i]--;
                            originalArray[index++] = i;
                        } else {
                            exists = false;
                            break;
                        }
                    }
                }
            } else {
                exists = false;
            }
        }
        return exists ? originalArray : new int[0];
    }

    public int getMax(int[] changed) {
        int max = -1;
        for(int x : changed) {
            max = Math.max(max, x);
        }
        return max;
    }

    public int[] getFreqArray(int[] changed, int max) {
        int[] freqArray = new int[max + 1];
        for(int x : changed) {
            freqArray[x]++;
        }
        return freqArray;
    }

}
