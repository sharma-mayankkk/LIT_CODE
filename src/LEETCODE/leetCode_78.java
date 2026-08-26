package LEETCODE;

import java.util.ArrayList;
import java.util.List;

//Given an integer array nums of unique elements, return all possible subsets (the power set).
//
//The solution set must not contain duplicate subsets. Return the solution in any order.
public class leetCode_78 {
    static void solve(int[] nums, List<Integer> set, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(set));
            return;
        }

        //include
        set.add(nums[index]);
        solve(nums, set, index + 1, ans);

        //exclude
        set.removeLast();
        solve(nums, set, index + 1, ans);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> set = new ArrayList<>();

        solve(nums, set, 0, ans);
        return ans;
    }
}
