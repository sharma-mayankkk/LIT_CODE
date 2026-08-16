package STRIVERaTOz.RecursionPatternWise.SubsequencesPattern;

//Check if there exists a subsequence with sum K
//Problem Statement: Given an array nums and an integer k. Return true if there exist subsequences such that the sum of all elements in subsequences is equal to k else false.
public class CheckSubsequenceWithSumK {
    public static boolean checkSubsequences(int[] arr, int k) {
        return solve(0, 0, k, arr);
    }

    public static boolean solve(int index, int currSum, int k, int[] arr) {
        if (index == arr.length) {
            return currSum == k;
        }

        boolean take = solve(index + 1, currSum + arr[index], k, arr);
        boolean notTake = solve(index + 1, currSum, k, arr);

        return take || notTake;
    }

    public static void main(String[] args) {

    }
}
