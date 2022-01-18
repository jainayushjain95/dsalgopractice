public class NoOfSubstringsContainingAll3Chars {
    public static void main(String[] args) {
        System.out.println(new NoOfSubstringsContainingAll3Chars().numberOfSubstrings("abcabc"));
    }

    public int numberOfSubstrings(String s) {
        int noOfSubstrings = 0;
        int aCount = 0, bCount = 0, cCount = 0;
        int left = 0, right = 0;

        while(right < s.length()) {
            char c = s.charAt(right);
            if(c == 'a') {
                aCount++;
            } else if(c == 'b') {
                bCount++;
            } else {
                cCount++;
            }

            while(aCount > 0 && bCount > 0 && cCount > 0) {
                noOfSubstrings += s.length() - right;
                c = s.charAt(left);
                if(c == 'a') {
                    aCount--;
                } else if(c == 'b') {
                    bCount--;
                } else {
                    cCount--;
                }
                left++;
            }
            right++;
        }

        return noOfSubstrings;
    }

}
