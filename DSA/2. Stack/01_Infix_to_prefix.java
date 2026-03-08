import java.util.*;

class InfixToPrefix {
    
    static boolean isOperator(char c) {
        return (!Character.isLetter(c) && !Character.isDigit(c));
    }
    
    static int getPriority(char C) {
        if (C == '-' || C == '+')
            return 1;
        else if (C == '*' || C == '/')
            return 2;
        else if (C == '^')
            return 3;
        return 0;
    }
    
    static String infixToPostfix(String infix) {
        infix = '(' + infix + ')';
        int l = infix.length();
        Stack<Character> char_stack = new Stack<>();
        StringBuilder output = new StringBuilder();
        
        for (int i = 0; i < l; i++) {
            if (Character.isLetter(infix.charAt(i)) || Character.isDigit(infix.charAt(i))) {
                output.append(infix.charAt(i));
            } else if (infix.charAt(i) == '(') {
                char_stack.push('(');
            } else if (infix.charAt(i) == ')') {
                while (char_stack.peek() != '(') {
                    output.append(char_stack.peek());
                    char_stack.pop();
                }
                char_stack.pop();
            } else {
                if (isOperator(char_stack.peek())) {
                    if (infix.charAt(i) == '^') {
                        while (getPriority(infix.charAt(i)) <= getPriority(char_stack.peek())) {
                            output.append(char_stack.peek());
                            char_stack.pop();
                        }
                    } else {
                        while (getPriority(infix.charAt(i)) < getPriority(char_stack.peek())) {
                            output.append(char_stack.peek());
                            char_stack.pop();
                        }
                    }
                    char_stack.push(infix.charAt(i));
                }
            }
        }
        
        while (!char_stack.isEmpty()) {
            output.append(char_stack.peek());
            char_stack.pop();
        }
        
        return output.toString();
    }
    
    static String infixToPrefix(String infix) {
        int l = infix.length();
        
        StringBuilder reversed = new StringBuilder(infix).reverse();
        
        for (int i = 0; i < l; i++) {
            if (reversed.charAt(i) == '(') {
                reversed.setCharAt(i, ')');
            } else if (reversed.charAt(i) == ')') {
                reversed.setCharAt(i, '(');
            }
        }
        
        String prefix = infixToPostfix(reversed.toString());
        
        return new StringBuilder(prefix).reverse().toString();
    }
    
    public static void main(String[] args) {
        String s = "x+y*z/w+u";
        System.out.println(infixToPrefix(s));
    }
}