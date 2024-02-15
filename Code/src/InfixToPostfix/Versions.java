package InfixToPostfix;

import Stack.ArrayStack;

import java.util.ArrayList;

public class Versions {

    public static String InfixToPostfix1(String str) {
        ArrayStack<Character> stack = new ArrayStack<Character>();
        StringBuilder sb = new StringBuilder();
        char chr;

        for (int i = 0; i < str.length(); i++) {
            chr = str.charAt(i);

            if (Character.isLetterOrDigit(chr))
                sb.append(chr);

            else if (chr == '(')
                stack.push(chr);

            else if (chr == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    sb.append(stack.pop());

                stack.pop();
            } else {
                while (!stack.isEmpty() && Priority(chr) <= Priority(stack.peek()))
                    sb.append(stack.pop());

                stack.push(chr);
            }
        }

        while (!stack.isEmpty())
            sb.append(stack.pop());

        return sb.toString();
    }

    public static String InfixToPostfix2(String str) {
        ArrayStack<Character> stack = new ArrayStack<Character>();
        StringBuilder sb = new StringBuilder();
        char chr;
        int i = 0;

        while (i < str.length()) {
            chr = str.charAt(i);

            if (i + 1 < str.length() && Character.isLetterOrDigit(chr) && Character.isLetterOrDigit(str.charAt(i + 1))) {
                sb.append(chr + str.charAt(i + 1) + " ");
                i++;
            }

            else if (Character.isLetterOrDigit(chr))
                sb.append(chr + " ");

            else if (chr == '(')
                stack.push(chr);

            else if (chr == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    sb.append(stack.pop() + " ");

                stack.pop();
            } else {
                while (!stack.isEmpty() && Priority(chr) <= Priority(stack.peek()))
                    sb.append(stack.pop() + " ");

                stack.push(chr);
            }

            i++;
        }

        while (!stack.isEmpty())
            sb.append(stack.pop() + " ");

        return sb.toString();
    }

    public static ArrayList<String> InfixToPostfix3(String str) {
        ArrayStack<Character> stack = new ArrayStack<Character>();
        ArrayList<String> arrayList = new ArrayList<String>();
        char chr;
        int i = 0;

        while (i < str.length()) {
            chr = str.charAt(i);

            if (i + 1 < str.length() && Character.isLetterOrDigit(chr) && Character.isLetterOrDigit(str.charAt(i + 1))) {
                arrayList.add(chr + "" + str.charAt(i + 1));
                i++;
            }

            else if (Character.isLetterOrDigit(chr))
                arrayList.add(chr + "");

            else if (chr == '(')
                stack.push(chr);

            else if (chr == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    arrayList.add(stack.pop() + "");

                stack.pop();
            } else {
                while (!stack.isEmpty() && Priority(chr) <= Priority(stack.peek()))
                    arrayList.add(stack.pop() + "");

                stack.push(chr);
            }

            i++;
        }

        while (!stack.isEmpty())
            arrayList.add(stack.pop() + "");

        return arrayList;
    }

    public static ArrayList<String> InfixToPostfix4(String str) {
        ArrayStack<Character> stack = new ArrayStack<Character>();
        ArrayList<String> arrayList = new ArrayList<String>();
        char chr;
        int i = 0;

        while (i < str.length()) {
            chr = str.charAt(i);

            if (i + 1 < str.length() && Character.isLetterOrDigit(chr) && Character.isLetterOrDigit(str.charAt(i + 1))) {
                String aux = new String("");

                while (i < str.length() && Character.isLetterOrDigit(str.charAt(i))) {
                    aux += str.charAt(i);
                    i++;
                }

                arrayList.add(aux);
                i--;
            }

            else if (Character.isLetterOrDigit(chr))
                arrayList.add(chr + "");

            else if (chr == '(')
                stack.push(chr);

            else if (chr == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    arrayList.add(stack.pop() + "");

                stack.pop();
            } else {
                while (!stack.isEmpty() && Priority(chr) <= Priority(stack.peek()))
                    arrayList.add(stack.pop() + "");

                stack.push(chr);
            }

            i++;
        }

        while (!stack.isEmpty())
            arrayList.add(stack.pop() + "");

        return arrayList;
    }

    public static ArrayList<String> InfixToPostfix5(String str) {
        ArrayStack<Character> stack = new ArrayStack<Character>();
        ArrayList<String> arrayList = new ArrayList<String>();
        char chr;
        int i = 0;

        while (i < str.length()) {
            chr = str.charAt(i);

            if (i + 1 < str.length() && Character.isLetterOrDigit(chr) && Character.isLetterOrDigit(str.charAt(i + 1))) {
                String aux = new String("");

                while (i < str.length() && Character.isLetterOrDigit(str.charAt(i))) {
                    aux += str.charAt(i);
                    i++;
                }

                arrayList.add(aux);
                i--;
            }

            else if (Character.isLetterOrDigit(chr))
                arrayList.add(chr + "");

            else if (chr == '(')
                stack.push(chr);

            else if (chr == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    arrayList.add(stack.pop() + "");

                stack.pop();
            } else {
                while (!stack.isEmpty() && Priority(chr) <= Priority(stack.peek()))
                    arrayList.add(stack.pop() + "");

                stack.push(chr);
            }

            i++;
        }

        while (!stack.isEmpty())
            arrayList.add(stack.pop() + "");

        return arrayList;
    }

    private static int Priority(char chr) {
        return switch (chr) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    public static ArrayList<String> InfixToPostfix6(String str) {

        ArrayStack<Character> stack = new ArrayStack<Character>();
        ArrayList<String> arrayList = new ArrayList<String>();
        char chr;
        int i = 0;

        while (i < str.length()) {
            chr = str.charAt(i);

            if (!(chr == ' ')) {

                if (chr == '-' && arrayList.isEmpty()) {
                    String aux = new String("");

                    aux += str.charAt(i);
                    i++;

                    while (i < str.length() && (Character.isLetterOrDigit(str.charAt(i)) || str.charAt(i) == '.')) {
                        aux += str.charAt(i);
                        i++;
                    }

                    arrayList.add(aux);
                    i--;
                }

                else if (i + 1 < str.length() && Character.isLetterOrDigit(chr) && (Character.isLetterOrDigit(str.charAt(i + 1)) || str.charAt(i + 1) == '.')) {
                    String aux = new String("");

                    while (i < str.length() && (Character.isLetterOrDigit(str.charAt(i)) || str.charAt(i) == '.')) {
                        aux += str.charAt(i);
                        i++;
                    }

                    arrayList.add(aux);
                    i--;
                }

                else if (Character.isLetterOrDigit(chr))
                    arrayList.add(chr + "");

                else if (chr == '(')
                    stack.push(chr);

                else if (chr == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(')
                        arrayList.add(stack.pop() + "");

                    stack.pop();
                } else {
                    while (!stack.isEmpty() && Priority(chr) <= Priority(stack.peek()))
                        arrayList.add(stack.pop() + "");

                    stack.push(chr);
                }
            }

            i++;
        }

        while (!stack.isEmpty())
            arrayList.add(stack.pop() + "");

        return arrayList;
    }

    public static ArrayList<String> InfixToPostfix7(String str) {

        ArrayStack<Character> stack = new ArrayStack<Character>();
        ArrayList<String> arrayList = new ArrayList<String>();
        char chr;
        int i = 0;

        while (i < str.length()) {
            chr = str.charAt(i);

            if (!(chr == ' ')) {

                if (i -1 > 0 && Character.isLetterOrDigit(str.charAt(i - 1)) && chr == '(') {
                    stack.push('*');
                    stack.push('(');
                }

                else if (chr == '-' && arrayList.isEmpty()) {
                    String aux = new String("");

                    aux += str.charAt(i);
                    i++;

                    while (i < str.length() && (Character.isLetterOrDigit(str.charAt(i)) || str.charAt(i) == '.')) {
                        aux += str.charAt(i);
                        i++;
                    }

                    arrayList.add(aux);
                    i--;
                }

                else if (i + 1 < str.length() && Character.isLetterOrDigit(chr) && (Character.isLetterOrDigit(str.charAt(i + 1)) || str.charAt(i + 1) == '.')) {
                    String aux = new String("");

                    while (i < str.length() && (Character.isLetterOrDigit(str.charAt(i)) || str.charAt(i) == '.')) {
                        aux += str.charAt(i);
                        i++;
                    }

                    arrayList.add(aux);
                    i--;
                }

                else if (Character.isLetterOrDigit(chr))
                    arrayList.add(chr + "");

                else if (chr == '(')
                    stack.push(chr);

                else if (chr == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(')
                        arrayList.add(stack.pop() + "");

                    stack.pop();
                } else {
                    while (!stack.isEmpty() && Priority(chr) <= Priority(stack.peek()))
                        arrayList.add(stack.pop() + "");

                    stack.push(chr);
                }
            }

            i++;
        }

        while (!stack.isEmpty())
            arrayList.add(stack.pop() + "");

        return arrayList;
    }

    public static ArrayList<String> InfixToPostfix8(String str) {
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayStack<Character> stack = new ArrayStack<Character>();
        char chr;
        int i = 0;

        while (i < str.length()) {
            if (!(str.charAt(i) == ' ')) {

                // If the first character is a minus so it is considered as part of the number and not an operator
                if (str.charAt(i) == '-' && arrayList.isEmpty()) {
                    String aux = new String("");

                    aux += str.charAt(i);
                    i++;

                    while (i < str.length() && (Character.isLetterOrDigit(str.charAt(i)) || str.charAt(i) == '.')) {
                        aux += str.charAt(i);
                        i++;
                    }

                    arrayList.add(aux);
                    i--;
                }

                // To keep numbers with decimals together
                else if (i + 1 < str.length() && Character.isLetterOrDigit(str.charAt(i)) && (Character.isLetterOrDigit(str.charAt(i + 1)) || str.charAt(i + 1) == '.')) {
                    String aux = new String("");

                    while (i < str.length() && (Character.isLetterOrDigit(str.charAt(i)) || str.charAt(i) == '.')) {
                        aux += str.charAt(i);
                        i++;
                    }

                    arrayList.add(aux);
                    i--;
                }

                // To consider parentheses also as a multiplication operator
                else if (i - 1 >= 0 && Character.isLetterOrDigit(str.charAt(i - 1)) && str.charAt(i) == '(') {
                    stack.push('*');
                    stack.push('(');
                }

                // To add simple numbers: 3, 4, 5
                else if (Character.isLetterOrDigit(str.charAt(i)))
                    arrayList.add(str.charAt(i) + "");

                // To add a parentheses
                else if (str.charAt(i) == '(')
                    stack.push(str.charAt(i));

                // To acomodate all inside a parentheses
                else if (str.charAt(i) == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(')
                        arrayList.add(stack.pop() + "");

                    stack.pop();
                }

                // To add all operators
                else {
                    while (!stack.isEmpty() && Priority(str.charAt(i)) <= Priority(stack.peek()))
                        arrayList.add(stack.pop() + "");

                    stack.push(str.charAt(i));
                }
            }

            i++;
        }

        while (!stack.isEmpty())
            arrayList.add(stack.pop() + "");

        return arrayList;
    }

    public static ArrayList<String> InfixToPostfix9(String str) {
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayStack<Character> stack = new ArrayStack<Character>();
        char chr;
        int i = 0;

        while (i < str.length()) {
            if (!(str.charAt(i) == ' ')) {

                // If the first character is a minus so it is considered as part of the number and not an operator
                if (str.charAt(i) == '-' && arrayList.isEmpty()) {
                    String aux = new String("");

                    aux += str.charAt(i);
                    i++;

                    while (i < str.length() && (Character.isLetterOrDigit(str.charAt(i)) || str.charAt(i) == '.')) {
                        aux += str.charAt(i);
                        i++;
                    }

                    arrayList.add(aux);
                    i--;
                }

                // To keep numbers with decimals together
                else if (i + 1 < str.length() && Character.isLetterOrDigit(str.charAt(i)) && (Character.isLetterOrDigit(str.charAt(i + 1)) || str.charAt(i + 1) == '.')) {
                    String aux = new String("");

                    while (i < str.length() && (Character.isLetterOrDigit(str.charAt(i)) || str.charAt(i) == '.')) {
                        aux += str.charAt(i);
                        i++;
                    }

                    if (i < str.length() && str.charAt(i) == '%') {
                        aux = Double.toString(Double.parseDouble(aux) / 100);
                        i++;
                    }

                    arrayList.add(aux);
                    i--;
                }

                // To consider parentheses also as a multiplication operator
                else if (i - 1 >= 0 && Character.isLetterOrDigit(str.charAt(i - 1)) && str.charAt(i) == '(') {
                    stack.push('*');
                    stack.push('(');
                }

                // To add simple numbers: 3, 4, 5
                else if (Character.isLetterOrDigit(str.charAt(i)))
                    arrayList.add(str.charAt(i) + "");

                    // To add a parentheses
                else if (str.charAt(i) == '(')
                    stack.push(str.charAt(i));

                    // To acomodate all inside a parentheses
                else if (str.charAt(i) == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(')
                        arrayList.add(stack.pop() + "");

                    stack.pop();
                }

                // To add all operators
                else {
                    while (!stack.isEmpty() && Priority(str.charAt(i)) <= Priority(stack.peek()))
                        arrayList.add(stack.pop() + "");

                    stack.push(str.charAt(i));
                }
            }

            i++;
        }

        while (!stack.isEmpty())
            arrayList.add(stack.pop() + "");

        return arrayList;
    }

    public static void main(String[] args) {

        /*
        System.out.println(InfixToPostfix1("a+b*(c^d-e)^(f+g*h)-i"));
        System.out.println(InfixToPostfix3("a+b*(c^d-e)^(f+g*h)-i"));
        System.out.println(InfixToPostfix1("3*((34+87)-3(45)+(46/52)+(59+5))"));
        System.out.println(InfixToPostfix3("3*((34+87)-3(45)+(46/52)+(59+5))"));
        System.out.println(InfixToPostfix1("3*((34+87)-3*(45)+(46/52)+(59+5))"));
        System.out.println(InfixToPostfix3("3*((34+87)-3*(45)+(46/52)+(59+5))"));
        System.out.println(InfixToPostfix1("3*((34+87)-3*(45+2)+(46/52)+(59+5))"));
        System.out.println(InfixToPostfix3("3*((34+87)-3*(45+2)+(46/52)+(59+5))"));
        System.out.println(InfixToPostfix4("2^3"));

         */

        System.out.println(InfixToPostfix9("34.5% * 89"));

    }
}
