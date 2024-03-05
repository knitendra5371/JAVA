package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class InfixToPostfixExpression {
    private static String infixToPostfixExp(char[] infix) {

        if (infix.length == 0) return null;

        String ans = "";
        Stack<Character> st = new Stack<>();
        List<Character> postfix = new ArrayList<>();
        List<Character> operators = Arrays.asList('^', '/', '*', '+', '-');
        char next;
        for (Character element : infix) {
            if (!whiteSpace(element)) {
                if (element == '(') st.push(element);
                else if (element == ')')
                    while (!st.isEmpty() && ((next = st.pop()) != '('))
                        postfix.add(next);
                else if (operators.contains(element)) {
                    while (!st.isEmpty() && (priority(st.peek()) >= priority(element)))
                        postfix.add(st.pop());
                    st.push(element);
                } else postfix.add(element);
            }
        }

        while (!st.isEmpty()) postfix.add(st.pop());

        for (Character ch : postfix) ans = ans.concat(ch + "");

        return ans;
    }

    private static int priority(Character ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/' || ch == '%') return 2;
        if (ch == '^') return 3;
        return 0;
    }

    private static boolean whiteSpace(Character element) {
        return element == ' ' || element == '\t';
    }

    public static void main(String[] args) {
//        String expression = "a-b^c+d*e/(f+g)"; // output=> abc^-de*fg+/+
        String expression = "8*(5^4+2)-6^2/(9*3)"; // output=> 854^2+*62^93*/-
        char[] infix = expression.toCharArray();
        System.out.println(infix);
        String postfix = infixToPostfixExp(infix);
        System.out.println(postfix);
    }


}
