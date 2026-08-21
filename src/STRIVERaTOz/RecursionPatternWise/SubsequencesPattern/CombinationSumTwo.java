package STRIVERaTOz.RecursionPatternWise.SubsequencesPattern;
//Combination Sum II - Find all unique combinations

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem Statement: Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target. Each number in candidates may only be used once in the combination.
public class CombinationSumTwo {
    public static void getAllCombinations(int[] arr, int target, int index ,List<List<Integer>> ans, List<Integer> combination){
        if (target ==0){
            ans.add(new ArrayList<>(combination));
            return;
        }

        if (index == arr.length || target < 0) {
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }

            combination.add(arr[i]);
            getAllCombinations(arr, target - arr[i], i + 1, ans, combination);
            combination.removeLast();
        }
    }
    public static List<List<Integer>> combinationSum(int[] arr, int target){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        Arrays.sort(arr);
        getAllCombinations(arr,target,0,ans,combination);

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 6, 7};
        System.out.println(combinationSum(arr, 7));
    }
}
