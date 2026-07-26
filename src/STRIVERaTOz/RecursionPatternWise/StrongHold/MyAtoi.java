package STRIVERaTOz.RecursionPatternWise.StrongHold;
//Recursive Implementation of atoi()

//Problem Statement: Implement the function myAtoi(s) which converts the given string s to a 32-bit signed integer (similar to the C/C++ atoi function).
//
//Steps to Implement: 1. First, ignore any leading whitespace characters ' ' until the first non-whitespace character is found.
//2. Check the next character to determine the sign. If it’s a '-', the number should be negative. If it’s a '+', the number should be positive. If neither is found, assume the number is positive.
//3. Read the digits and convert them into a number. Stop reading once a non-digit character is encountered or the end of the string is reached. Leading zeros should be ignored during conversion.
//4. The result should be clamped within the 32-bit signed integer range: [-2147483648, 2147483647]. If the computed number is outside this range, return -2147483648 if the number is less than -2147483648, or return 2147483647 if the number is greater than 2147483647.
//5. Finally, return the computed number after applying all the above steps.
public class MyAtoi {
    public static int solve(String s, int index, long ans, int sign) {
        if (index >= s.length() || !Character.isDigit(s.charAt(index))) {
            return (int) (sign * ans);
        }

        int digit = s.charAt(index) - '0';

        if (ans > (Integer.MAX_VALUE - digit) / 10) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        ans = ans * 10 + digit;

        return solve(s, index + 1, ans, sign);
    }

    public static int myAtoi(String s) {

        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') index++;

        if(index == s.length()) return 0;

        int sign = 1;
        if (index < s.length() && s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (index < s.length() && s.charAt(index) == '+') {
            index++;
        }

        return solve(s, index, 0, sign);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-123456101010101010"));
    }
}
