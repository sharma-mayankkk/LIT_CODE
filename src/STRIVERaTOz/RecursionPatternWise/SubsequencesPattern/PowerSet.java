package STRIVERaTOz.RecursionPatternWise.SubsequencesPattern;
import java.util.*;
public class PowerSet {
    private void helper(String s, int index, StringBuilder current, List<String> result) {
        // Base case: if index reaches string length, add current subsequence to result
        if (index == s.length()) {
            result.add(current.toString());
            return;
        }

        // Exclude current character and recurse
        helper(s, index + 1, current, result);

        // Include current character and recurse
        current.append(s.charAt(index));
        helper(s, index + 1, current, result);

        // Backtrack by removing last character
        current.deleteCharAt(current.length() - 1);
    }

    // Method to return all subsequences of string s
    public List<String> getSubsequences(String s) {
        // List to store all subsequences
        List<String> result = new ArrayList<>();

        // StringBuilder to store current subsequence
        StringBuilder current = new StringBuilder();

        // Start recursion from index 0
        helper(s, 0, current, result);

        // Return list of subsequences
        return result;
    }
}
