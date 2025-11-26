package LEETCODE;
/*
LeetCode problem number 7:
problem statement:
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 */
public class leetCode_7 {
    public static int reverseInteger(int x){
        int reverse = 0;
        while(x != 0){
            int lastDigit = x%10;
            if(reverse>Integer.MAX_VALUE/10 || reverse<Integer.MIN_VALUE/10){
                return 0;
            }
            reverse =(reverse*10)+lastDigit;
            x = x/10;
        }
        return reverse;
    }
    public static void main(String[] args) {
        System.out.println(reverseInteger(789));
    }
}

