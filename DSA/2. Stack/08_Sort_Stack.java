import java.util.*;

/*
    Problem Link: https://www.geeksforgeeks.org/problems/sort-a-stack/1
*/

class Solution {
    
    void SortedInsert(Stack<Integer> st, int x) {
        if (st.isEmpty() || st.peek() >= x) {
            st.push(x);
        } else {
            int temp = st.pop();
            SortedInsert(st, x);
            st.push(temp);
        }
    }
    
    void SortStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }
        
        int temp = st.pop();
        SortStack(st);
        SortedInsert(st, temp);
    }
}