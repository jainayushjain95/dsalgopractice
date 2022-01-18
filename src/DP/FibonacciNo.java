package DP;

public class FibonacciNo {
    public static void main(String[] args) {

    }

    public int fib(int n) {
        int a, b, c;
        if(n <= 1) {
            c = n;
        } else {
            a = 0;
            b = 1;
            c = 0;
            for(int i = 2;i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
        }
        return c;
    }
}
