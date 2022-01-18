public class KthLexicographicStringOfAllHappy {

    String solution;
    char[] chars;
    int length;
    int pos;

    public static void main(String[] args) {
        System.out.println(new KthLexicographicStringOfAllHappy().getHappyString(3, 9));
    }

    public String getHappyString(int n, int k) {
        solution = "";
        chars = new char[]{'a', 'b', 'c'};
        length = n;
        pos = k;
        solve(new StringBuilder());
        return solution;
    }

    public void solve(StringBuilder currString) {
        if(currString.length() == length) {
            pos--;
            if(pos == 0) {
                solution = currString.toString();
            }
            return;
        }
        if(solution.length() == 0) {
            for(char c : chars) {
                if(currString.length() == 0 || c != currString.charAt(currString.length() - 1)) {
                    currString.append(c);
                    solve(currString);
                    currString.deleteCharAt(currString.length() - 1);
                }
            }
        }
    }
}
