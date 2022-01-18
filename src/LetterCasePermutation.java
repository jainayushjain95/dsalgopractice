import java.util.*;

public class LetterCasePermutation {
    public static void main(String[] args) {
        List<String> perms = new LetterCasePermutation().letterCasePermutation("a1b2");
        System.out.println(perms);
    }

    public List<String> letterCasePermutation(String s) {
        List<String> perms = new ArrayList<>();
        letterCasePermutationSolve(s, perms, 0, new StringBuilder());
        return perms;
    }

    public void letterCasePermutationSolve(String s, List<String> perms, int currentIndex, StringBuilder curr) {
        if(currentIndex >= s.length()) {
            perms.add(curr.toString());
            return;
        }

        char c = s.charAt(currentIndex);
        if(isNumeric(c)) {
            curr.append(c);
            letterCasePermutationSolve(s, perms, currentIndex + 1, curr);
            curr.deleteCharAt(curr.length() - 1);
        } else if(isLowerCase(c)) {
            curr.append(c);
            letterCasePermutationSolve(s, perms, currentIndex + 1, curr);
            curr.deleteCharAt(curr.length() - 1);

            curr.append(toUpperCase(c));
            letterCasePermutationSolve(s, perms, currentIndex + 1, curr);
            curr.deleteCharAt(curr.length() - 1);

        } else {
            curr.append(c);
            letterCasePermutationSolve(s, perms, currentIndex + 1, curr);
            curr.deleteCharAt(curr.length() - 1);

            curr.append(toLowerCase(c));
            letterCasePermutationSolve(s, perms, currentIndex + 1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }


    public char toUpperCase(char c) {
        return (char) ((int) c - 32);
    }

    public char toLowerCase(char c) {
        return (char) ((int) c + 32);
    }


    public boolean isLowerCase(char c) {
        int n = (int) c;
        return n >= 97 && n <= 122;
    }

    public boolean isNumeric(char c) {
        int n = (int) c;
        return n >= 48 && n <= 57;
    }

}
