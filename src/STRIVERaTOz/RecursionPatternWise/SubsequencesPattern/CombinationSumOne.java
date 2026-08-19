package STRIVERaTOz.RecursionPatternWise.SubsequencesPattern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Combination Sum - 1
//Given an array of distinct integers and a target, you have to return the list of all unique combinations where the chosen numbers sum to target. You may return the combinations in any order.
//
//The same number may be chosen from the given array an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
//
//It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
public class CombinationSumOne {

    static Set<List<Integer>> set = new HashSet<>();

    public static void getAllCombination(int[] arr, int index, int target, List<List<Integer>> ans, List<Integer> combination) {

        if (index == arr.length || target < 0) {
            return;
        }

        if (target == 0) {
            if (!set.contains(combination)) {
                ans.add(new ArrayList<>(combination));
                set.add(new ArrayList<>(combination));
            }
            return;
        }

        combination.add(arr[index]);
        //single choice
        getAllCombination(arr, index + 1, target - arr[index], ans, combination);
        //multiple choice
        getAllCombination(arr, index, target - arr[index], ans, combination);

        combination.removeLast();

        //No selection
        getAllCombination(arr, index + 1, target, ans, combination);
    }

    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        getAllCombination(arr, 0, target, ans, combination);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        System.out.println(combinationSum(arr, 7));
    }
}
