import java.util.Stack;

/*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    An input string is valid if:
        - Open brackets must be closed by the same type of brackets.
        - Open brackets must be closed in the correct order.
        - Every close bracket has a corresponding open bracket of the same type.
    
    Example 1:
        Input: s = "()"
        Output: true

    Example 2:
        Input: s = "()[]{}"
        Output: true

    Example 3:
        Input: s = "(]"
        Output: false

    Example 4:
        Input: s = "([])"
        Output: true

    Example 5:
        Input: s = "([)]"
        Output: false

    Constraints:
        - 1 <= s.length <= 104
        - s consists of parentheses only '()[]{}'.
*/

// TC: O(N)
// SC: O(N)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int j = 0; j < s.length(); j++) {
            char i = s.charAt(j);
            if (i == '(' || i == '[' || i == '{') {
                st.push(i);
            } else {
                if (st.isEmpty()) return false;
                if ((i == ')' && st.peek() != '(') || 
                    (i == ']' && st.peek() != '[') || 
                    (i == '}' && st.peek() != '{')) {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}