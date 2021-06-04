package solution;

public class Fib {

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int f1 = 0;
        int f2 = 1;
        int f3 = 1;

        n-=2;
        while (n > 0) {
            f3  = (f1 + f2)%1000000007;
            f1 = f2;
            f2 = f3;
            n--;
        }

        return f3;

    }
    // 0  1  1 2 3 5
}
