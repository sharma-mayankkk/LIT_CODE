package LEETCODE;

import java.util.ArrayList;
import java.util.List;

//Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
//
//The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
//
//

public class leetCode_39 {
    public static void getAllCombination(int[] arr, int index, int target, List<List<Integer>> ans, List<Integer> combination) {
        if (target == 0) {
            ans.add(new ArrayList<>(combination));
            return;
        }

        if (index == arr.length || target < 0) {
            return;
        }

        combination.add(arr[index]);


        getAllCombination(arr, index, target - arr[index], ans, combination);

        combination.removeLast();
        getAllCombination(arr, index + 1, target, ans, combination);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        getAllCombination(candidates, 0, target, ans, combination);
        return ans;
    }
}
