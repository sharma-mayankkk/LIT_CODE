package CODING_NINJA;

import java.util.Stack;

//Problem statement
//You’re given a stack consisting of 'N' integers. Your task is to sort this stack in descending order using recursion.
//
//We can only use the following functions on this stack S.
//
//is_empty(S) : Tests whether stack is empty or not.
//push(S) : Adds a new element to the stack.
//pop(S) : Removes top element from the stack.
//top(S) : Returns value of the top element. Note that this function does not remove elements from the stack.
//Note :
//1) Use of any loop constructs like while, for..etc is not allowed.
//2) The stack may contain duplicate integers.
//3) The stack may contain any integer i.e it may either be negative, positive or zero.
public class sortStackRecursive {
    public static void sortedInsert(Stack<Integer> st, int x) {
        if (st.isEmpty() || st.peek() < x) {
            st.push(x);
            return;
        }

        int top = st.pop();
        sortedInsert(st, x);
        st.push(top);
    }

    public static void sortStack(Stack<Integer> stack) {
        // Write your code here.
        if (stack.isEmpty()) return;

        int top = stack.pop();
        sortStack(stack);
        sortedInsert(stack, top);
    }
}
