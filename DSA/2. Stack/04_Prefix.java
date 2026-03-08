import java.util.*;

class PrefixEvaluation {
    
    static boolean isOperand(char c) {
        return Character.isDigit(c);
    }
    
    static double evaluatePrefix(String exprsn) {
        Stack<Double> stack = new Stack<>();
        
        for (int j = exprsn.length() - 1; j >= 0; j--) {
            if (isOperand(exprsn.charAt(j))) {
                stack.push((double)(exprsn.charAt(j) - '0'));
            } else {
                double o1 = stack.pop();
                double o2 = stack.pop();
                
                switch (exprsn.charAt(j)) {
                    case '+':
                        stack.push(o1 + o2);
                        break;
                    case '-':
                        stack.push(o1 - o2);
                        break;
                    case '*':
                        stack.push(o1 * o2);
                        break;
                    case '/':
                        stack.push(o1 / o2);
                        break;
                }
            }
        }
        
        return stack.pop();
    }
    
    public static void main(String[] args) {
        String exprsn = "+9*26";
        System.out.println(evaluatePrefix(exprsn));
    }
}