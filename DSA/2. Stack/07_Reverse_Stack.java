import java.util.Stack;

/*
    Problem Link: https://www.geeksforgeeks.org/problems/reverse-a-stack/1
*/

class Solution {
    Stack<Character> st = new Stack<>();
    
    void insert_at_bottom(char x) {
        if (st.size() == 0) {
            st.push(x);
        } else {
            char a = st.pop();
            insert_at_bottom(x);
            st.push(a);
        }
    }
    
    void reverse() {
        if (st.size() > 0) {
            char x = st.pop();
            reverse();
            insert_at_bottom(x);
        }
    }
}