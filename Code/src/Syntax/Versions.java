package Syntax;

import Stack.ArrayStack;

public class Versions {

    // V1
    public static boolean Syntax1(String str) {
        boolean resp = ParenthesesReviewer(str);

        if (resp && str.length() > 0) {
            int i = 0;

            while (resp && i < str.length()) {
                resp = CharAllowed(str.charAt(i));
                i++;
            }

            if (resp)
                resp = validOperation(str);
        } else
            resp = false;

        return resp;
    }

    private static boolean ParenthesesReviewer(String str) {
        ArrayStack<Character> stack = new ArrayStack<Character>();
        boolean resp = true;
        int i = 0;

        while (resp && i < str.length()) {
            if (Character.compare(str.charAt(i), '(') == 0)
                stack.push(str.charAt(i));
            if (Character.compare(str.charAt(i), ')') == 0){
                if (!(stack.isEmpty()))
                    stack.pop();
                else resp = false;
            }

            i++;
        }

        return resp && stack.isEmpty();
    }

    private static boolean CharAllowed(char chr) {

        return switch (chr) {
            case '(', ')', '.', '+', '-', '*', '/', '^', '%', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> true;
            default -> false;
        };
    }

    private static boolean validOperation(String str) {
        boolean num1 = false, operator = false, num2 = false;
        int i = 0;

        if (str.length() > 1)
            while (!num2 && i < str.length()) {
                char chr = str.charAt(i);

                if (Character.isDigit(chr)) {
                    if (num1 && operator)
                        num2 = true;
                    else
                        num1 = true;
                } else {
                    if (chr == '+' || chr == '-' || chr == '*' || chr == '/' || chr == '^')
                        operator = true;
                }

                i++;
            }
        else
            return Character.isDigit(str.charAt(0));

        return num1 && operator && num2;
    }

    // V2
    public static boolean Syntax2(String str) {
        ArrayStack<Character> stack = new ArrayStack<Character>();
        boolean resp = true;

        if (str.length() > 0) {
            int i = 0;
            boolean operator = false;

            while (resp && i < str.length()) {
                // Char Allowed
                resp = CharAllowed(str.charAt(i));

                // Parentheses Reviewer
                if (Character.compare(str.charAt(i), '(') == 0)
                    stack.push(str.charAt(i));
                if (Character.compare(str.charAt(i), ')') == 0){
                    if (!(stack.isEmpty()))
                        stack.pop();
                    else resp = false;
                }

                // Not double operator
                if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/' || str.charAt(i) == '^') {
                    if (operator)
                        resp = false;
                    else
                        operator = true;
                } else
                    operator = false;

                i++;
            }

            if (resp)
                resp = validOperation(str);
        } else
            resp = false;

        return resp;
    }

    // V3
    public static boolean Syntax3(String str) {
        ArrayStack<Character> stack = new ArrayStack<Character>();
        boolean resp = true;

        if (str.length() > 0) {
            if (!isNumeric(str)) {
                int i = 0;
                boolean operator = false;

                while (resp && i < str.length()) {
                    if (!(str.charAt(i) == ' ')) {

                        // Char Allowed
                        resp = CharAllowed(str.charAt(i));

                        // Parentheses Reviewer
                        if (Character.compare(str.charAt(i), '(') == 0)
                            stack.push(str.charAt(i));
                        if (Character.compare(str.charAt(i), ')') == 0) {
                            if (!(stack.isEmpty()))
                                stack.pop();
                            else resp = false;
                        }

                        // Not double operator
                        if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/' || str.charAt(i) == '^') {
                            if (operator)
                                resp = false;
                            else
                                operator = true;
                        } else
                            operator = false;
                    }

                    i++;
                }

                if (resp)
                    resp = validOperation(str);
            }
        } else
            resp = false;

        return resp;
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    //V4
    public static boolean Syntax4(String str) {
        ArrayStack<Character> stack = new ArrayStack<Character>();
        boolean resp = true;

        if (str.length() > 0) {
            if (!isNumeric(str)) {
                int i = 0;
                boolean operator = false;

                while (resp && i < str.length()) {
                    if (!(str.charAt(i) == ' ')) {

                        // Char Allowed
                        resp = CharAllowed(str.charAt(i));

                        // Parentheses Reviewer
                        if (Character.compare(str.charAt(i), '(') == 0)
                            stack.push(str.charAt(i));
                        if (Character.compare(str.charAt(i), ')') == 0) {
                            if (!(stack.isEmpty()))
                                stack.pop();
                            else resp = false;
                        }

                        if (str.charAt(i) == '%') {
                            if (i - 1 >= 0 && !Character.isDigit(str.charAt(i - 1)))
                                resp = false;
                            if (i + 1 < str.length() && Character.isDigit(str.charAt(i + 1)))
                                resp = false;
                        }

                        // Not double operator
                        if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/' || str.charAt(i) == '^') {
                            if (operator)
                                resp = false;
                            else
                                operator = true;
                        } else
                            operator = false;
                    }

                    i++;
                }

                if (resp)
                    resp = validOperation(str);
            }
        } else
            resp = false;

        return resp;
    }

    public static void main(String[] args) {

        /*
        System.out.println(Syntax3(""));
        System.out.println(Syntax3("3*((34+87)-3(45)+(46/52)+(59+5))"));
        System.out.println(Syntax3("(95-8)*(89/4))"));
        System.out.println(Syntax3("3*(((648*5)-(978-65))+(1489/98))"));
        System.out.println(Syntax3("Hola"));
        System.out.println(Syntax3("3 * ((34 + 87) - 3(45) + (46 / 52) + (59 + 5))"));
        System.out.println(Syntax3("3"));
        System.out.println(Syntax3("3+"));
        System.out.println(Syntax3("3++8-9"));
        System.out.println(Syntax3("3.3"));

         */

        System.out.println(Syntax4("%34*100"));
    }
}
