package LEETCODE;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
//
//The solution set must not contain duplicate subsets. Return the solution in any order.
public class leetCode_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        generateSubsets(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void generateSubsets(
            int[] nums,
            int index,
            List<Integer> current,
            List<List<Integer>> ans) {

        ans.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {

            // Skip duplicate choices at the same recursion level
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);

            generateSubsets(nums, i + 1, current, ans);

            current.remove(current.size() - 1);
        }
    }
}
