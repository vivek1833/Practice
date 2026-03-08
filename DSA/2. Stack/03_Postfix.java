import java.util.*;

class PostfixEvaluation {
    
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter postfix expression: ");
        String exp = scanner.nextLine();
        
        for (int i = 0; i < exp.length(); i++) {
            if (Character.isDigit(exp.charAt(i))) {
                s.push(exp.charAt(i) - '0');
            } else {
                int op2 = s.pop();
                int op1 = s.pop();
                
                if (exp.charAt(i) == '+')
                    s.push(op1 + op2);
                else if (exp.charAt(i) == '-')
                    s.push(op1 - op2);
                else if (exp.charAt(i) == '*')
                    s.push(op1 * op2);
                else if (exp.charAt(i) == '/')
                    s.push(op1 / op2);
            }
        }
        
        System.out.println("After evalution we get: " + s.peek());
        scanner.close();
    }
}