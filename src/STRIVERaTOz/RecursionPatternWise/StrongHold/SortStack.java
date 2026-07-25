package STRIVERaTOz.RecursionPatternWise.StrongHold;

import java.util.Arrays;
import java.util.Stack;

public class SortStack {
    public static void sortedInsert(Stack<Integer> stack, int x) {
        if (stack.isEmpty() || stack.peek() < x) {
            stack.push(x);
            return;
        }
        int top = stack.pop();
        sortedInsert(stack, x);
        stack.push(top);
    }

    public static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) return;

        int top = st.pop();
        sortStack(st);
        sortedInsert(st, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(9);

        sortStack(stack);
        System.out.println(Arrays.toString(stack.toArray()));
    }
}
