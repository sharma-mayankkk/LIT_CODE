package STRIVERaTOz.RecursionPatternWise.StrongHold;
//Count Good numbers

//Problem Statement: A digit string is considered good if the digits at even indices (0-based) are even digits (0, 2, 4, 6, 8) and the digits at odd indices are prime digits (2, 3, 5, 7).
//
//Given an integer n, return the total number of good digit strings of length n. As the result may be large, return it modulo 109 + 7.
//
//A digit string is a string consisting only of the digits '0' through '9'. It may contain leading zeros.
public class CountGoodNumbers {
    static final long mod = 1000000007;

    public static long findPower(long a, long b) {
        if (b == 0) return 1;

        if (b % 2 == 0) return findPower(a * a % mod, b / 2);
        return (a * findPower(a * a % mod, (b - 1) / 2)) % mod;
    }

    public static int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;

        long ans = (findPower(5, even) * findPower(4, odd)) % mod;

        return (int) ans;
    }

}
