package stack;

import java.util.*;

public class EvaluateArithmeticExpression {
    private static boolean whiteSpace(Character ch){
        return ch == ' ' || ch == '\t';
    }
    static int priority(Character ch){
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/' || ch == '%') return 2;
        if (ch == '^') return 3;
        return 0;
    }
    private static List<String> infixToPostfix(char[] infix){

        if (infix.length == 0) return null;

        Stack<Character> st = new Stack<>();
        List<String> postfix = new ArrayList<>();
        List<Character> operators = Arrays.asList('^', '/', '*', '+', '-');
        char next;
        int num=0;
        boolean numFlag=false;
        for (Character element : infix) {
            if (!whiteSpace(element)) {
                if(element<='9' && element>='0' ){
                    numFlag=true;
                    num=num*10+(element - '0');
                    continue;
                }else {
                    if(numFlag) {
                        postfix.add(num + "");
                        num = 0;
                    }
                }
                numFlag=false;
                if (element == '(') st.push(element);
                else if (element == ')')
                    while (!st.isEmpty() && ((next = st.pop()) != '('))
                        postfix.add(next+"");
                else if (operators.contains(element)) {
                    while (!st.isEmpty() && (priority(st.peek()) >= priority(element)))
                        postfix.add(st.pop()+"");
                    st.push(element);
                }
            }
        }
        if(numFlag)
            postfix.add(num+"");

        while (!st.isEmpty()) postfix.add(st.pop()+"");

        return postfix;
    }

    public static void main(String[] args) {
//        String expression = "8*(5^4+2)-6^2/(9*3)"; // output=> 854^2+*62^93*/- , result=5015
//        String expression = "7+5*3^2/(9-2^2)+6*4"; // output=> 7532^*922^-/+64*+ , result=40
        String expression = "8+2-(1+4)-10+12";
        char[] infix = expression.toCharArray();
//        System.out.println(infix);
        List<String> postfix = infixToPostfix(infix);
        System.out.println(postfix);
        int result = evaluatePostfix(postfix);
        System.out.println(result);


    }

    private static int evaluatePostfix(List<String> postfix) {
        if(postfix==null) return Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for (String el : postfix){
            if(isNumeric(el)){
                st.push(Integer.parseInt(el));
            }else{
                if(!st.isEmpty()) {
                    Integer num1 = st.pop();
                    Integer num2 = st.pop();
                    int temp = operation(num2, num1, el);
                    st.push(temp);
                }
            }
            System.out.println("stack => "+st);
        }
        return st.pop();
    }

    private static int operation(Integer num1, Integer num2, String el) {
        switch (el) {
            case "^":
                return (int) Math.pow(num1, num2);
            case "/":
                return num1 / num2;
            case "*":
                return num1 * num2;
            case "%":
                return num1 % num2;
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
        }
        return Integer.MIN_VALUE;
    }

    private static boolean isNumeric(String el) {
        if(el==null) return false;
        try{
            Integer num = Integer.parseInt(el);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
}
