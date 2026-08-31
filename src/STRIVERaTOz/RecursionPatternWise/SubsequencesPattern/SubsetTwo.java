package STRIVERaTOz.RecursionPatternWise.SubsequencesPattern;

import java.util.*;

public class SubsetTwo {
    // Recursive helper to find all subsets
    public void findSubsets(int ind, int[] nums, List<Integer> ds, Set<List<Integer>> result) {
        // Base case: if all elements are considered, add the subset to the result set
        if (ind == nums.length) {
            result.add(new ArrayList<>(ds));
            return;
        }

        // Choice 1: Include the current element
        ds.add(nums[ind]);
        findSubsets(ind + 1, nums, ds, result);
        // Backtrack by removing the element to explore the other path
        ds.remove(ds.size() - 1);

        // Choice 2: Do not include the current element
        findSubsets(ind + 1, nums, ds, result);
    }

    public void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Add current subset to result
        result.add(new ArrayList<>(current));

        // Iterate over array from 'start' index
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            // Include nums[i] in current subset
            current.add(nums[i]);

            // Recurse for next index
            backtrack(i + 1, nums, current, result);

            // Backtrack: remove last element
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums); // Sort to handle duplicates
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    // Main function to get all unique subsets
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        // Sort the array to handle duplicates consistently
        Arrays.sort(nums);
        findSubsets(0, nums, new ArrayList<>(), result);

        // Convert the set to a list for the final output
        return new ArrayList<>(result);
    }
}
