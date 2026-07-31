package CODING_NINJA;

import java.util.ArrayList;
import java.util.List;
//Problem statement
//You have been given an integer 'N'. Your task is to generate and return all binary strings of length 'N' such that there are no consecutive 1's in the string.
//
//
//
//A binary string is that string which contains only ‘0’ and ‘1’.
//
//
//
//For Example:
//Let ‘N'=3, hence the length of the binary string would be 3.
//
//We can have the following binary strings with no consecutive 1s:
//000 001 010 100 101
public class generateAllBString {
    public static void helper(int n, StringBuilder sb, int last , List< String > ans){
        if(sb.length() == n){
            ans.add(sb.toString());
            return;
        }

        sb.append('0');
        helper(n,sb,0,ans);
        sb.deleteCharAt(sb.length() - 1);

        if (last == 0) {
            sb.append('1');
            helper(n, sb, 1, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static List< String > generateString(int N) {
        // Write your code here.
        List<String> ans = new ArrayList<>();
        helper(N, new StringBuilder(), 0, ans);

        return ans;
    }
}
