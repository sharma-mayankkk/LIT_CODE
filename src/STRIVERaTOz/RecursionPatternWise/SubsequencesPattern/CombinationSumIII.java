package STRIVERaTOz.RecursionPatternWise.SubsequencesPattern;

import java.util.ArrayList;
import java.util.List;

//Combination Sum III
//
//
//2
//
//Problem Statement: Determine all possible set of k numbers that can be added together to equal n while meeting the following requirements:
//1. There is only use of numerals 1 through 9.
//2. A single use is made of each number.
//Return list of every feasible combination that is allowed. The combinations can be returned in any order, but the list cannot have the same combination twice.
public class CombinationSumIII {

    private void func(int sum, int last, List<Integer> nums, int k, List<List<Integer>> ans) {
        // If the sum is zero and the number of elements is k
        if (sum == 0 && nums.size() == k) {
            // Add the current combination to the answer
            ans.add(new ArrayList<>(nums));
            return;
        }
        // If the sum is less than or equal to zero or the number of elements exceeds k
        if (sum <= 0 || nums.size() > k) return;

        // Iterate from the last number to 9
        for (int i = last; i <= 9; i++) {
            // If the current number is less than or equal to the sum
            if (i <= sum) {
                // Add the number to the current combination
                nums.add(i);
                // Recursive call with updated sum and next number
                func(sum - i, i + 1, nums, k, ans);
                // Remove the last number to backtrack
                nums.removeLast();
            } else {
                // If the number is greater than the sum, break the loop
                break;
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        // Call the recursive function with initial parameters
        func(n, 1, nums, k, ans);
        return ans;
    }


}

