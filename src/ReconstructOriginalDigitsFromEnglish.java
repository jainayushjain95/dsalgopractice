import java.util.HashMap;
import java.util.Map;

public class ReconstructOriginalDigitsFromEnglish {

    public static String[] words;

    public static void main(String[] args) {
        String s =  "zeroonetwothreefourfivesixseveneightnine";
        String solve = new ReconstructOriginalDigitsFromEnglish().originalDigits(s);
        System.out.println(solve);
    }

    public String originalDigits(String s) {
        initialize();
        int[] alpha = setAlpha(s);
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i < words.length; i++) {
            boolean exists = getFreq(alpha, words[i]);
            if(exists) {
                sb.append(i);
            }
        }

        return sb.toString();
    }

    public int[] setAlpha(String s) {
        int[] alpha = new int[26];
        for(int i = 0;i < s.length(); i++) {
            alpha[getIndex(s.charAt(i))]++;
        }
        return alpha;
    }

    public static void initialize() {
        words = new String[10];
        words[0] = "zero";
        words[1] = "one";
        words[2] = "two";
        words[3] = "three";
        words[4] = "four";
        words[5] = "five";
        words[6] = "six";
        words[7] = "seven";
        words[8] = "eight";
        words[9] = "nine";
    }

    public static boolean getFreq(int[] alpha, String input) {
        int freq = Integer.MAX_VALUE;
        for(int i = 0;i < input.length(); i++) {
            freq = Math.min(freq, alpha[getIndex(input.charAt(i))]);
        }

        if(freq < Integer.MAX_VALUE && freq > 0) {
            for(int i = 0;i < input.length(); i++) {
                alpha[getIndex(input.charAt(i))]--;
            }
            return true;
        }
        return false;
    }

    public static int getIndex(char c) {
        return (c - '0') - 49;
    }
}
