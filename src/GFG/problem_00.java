package GFG;
//Given an array arr[]. The task is to find the largest element and return it.
public class problem_00 {
    public static int largest(int[] arr) {
        // code here
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>largest){
                largest = arr[i];
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        int[] arr = {11,33,72,57};
        System.out.println(largest(arr));
    }
}
