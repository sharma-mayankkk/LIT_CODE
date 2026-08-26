package STRIVERaTOz.RecursionPatternWise.SubsequencesPattern;
import java.util.*;
public class SubsetOne {

        public static void findSubsets(int[] arr, int index, int sum, ArrayList<Integer> ans) {

            // Base case
            if (index == arr.length) {
                ans.add(sum);
                return;
            }

            // Include current element
            findSubsets(arr, index + 1, sum + arr[index], ans);

            // Don't include current element
            findSubsets(arr, index + 1, sum, ans);
        }

        public static ArrayList<Integer> subsetSums(int[] arr) {

            ArrayList<Integer> ans = new ArrayList<>();

            findSubsets(arr, 0, 0, ans);

            // Increasing order
            Collections.sort(ans);

            return ans;
        }
}
