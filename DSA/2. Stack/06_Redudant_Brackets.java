import java.util.Stack;

/*
    Problem Link: https://www.geeksforgeeks.org/problems/redundant-parenthesis--170647/1

    Given a valid expression containing only binary operators '+', '-', '*', '/' and operands, remove all the redundant parenthesis.
    A set of parenthesis is said to be redundant if, removing them, does not change the value of the expression.

    Example 1:
        Input: (A*(B+C))
        Output: A*(B+C)
        Explanation: The outermost parenthesis are redundant.
    
    Example 2:
        Input: A+(B+(C))
        Output: A+B+C
        Explanation: All the parenthesis are redundant.
*/

class Solution {
    public boolean RedBrac(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                st.push(ch);
            } else {
                if (ch == ')') {
                    boolean isRed = true;
                    while (st.peek() != '(') {
                        if (st.peek() == '+' || st.peek() == '-' || st.peek() == '*' || st.peek() == '/') {
                            isRed = false;
                        }
                        st.pop();
                    }
                    if (isRed) {
                        return true;
                    }
                    st.pop();
                }
            }
        }
        return false;
    }
}