import java.util.*;

public class GrayCode {
    public static void main(String[] args) {
        List<Integer> grayCodes = new GrayCode().grayCode(2);
        System.out.println(grayCodes);
    }

    public List<Integer> grayCode(int n) {
        return grayCode1(n);
    }

    public List<Integer> grayCode1(int n) {
        if(n == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(1);
            return list;
        }
        List<Integer> smallerGrayCodes = grayCode1(n - 1);
        List<Integer> grayCodes = new ArrayList<>();

        for(int i = 0;i < smallerGrayCodes.size(); i++) {
            grayCodes.add(smallerGrayCodes.get(i));
        }

        int base = (int)Math.pow(2, n - 1);

        for(int i = smallerGrayCodes.size() - 1;i >= 0; i--) {
            grayCodes.add(base + smallerGrayCodes.get(i));
        }

        return grayCodes;
    }

}
