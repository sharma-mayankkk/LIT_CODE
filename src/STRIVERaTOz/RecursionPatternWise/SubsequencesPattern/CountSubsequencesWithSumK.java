package STRIVERaTOz.RecursionPatternWise.SubsequencesPattern;

//Count all subsequences with sum K
//Problem Statement: Given an array nums and an integer k.Return the number of non-empty subsequences of nums such that the sum of all elements in the subsequence is equal to k.
public class CountSubsequencesWithSumK {
    public static int countSubsequences(int[] arr, int k) {
        return count(0, k, 0, arr);
    }

    public static int count(int index, int k, int currSum, int[] arr) {
        if (index == arr.length) {
            return currSum == k ? 1 : 0;
        }

        int take = count(index + 1, k, currSum + arr[index], arr);
        int notTake = count(index + 1, k, currSum, arr);

        return take + notTake;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1};
        System.out.println(countSubsequences(arr,2));
    }
}
