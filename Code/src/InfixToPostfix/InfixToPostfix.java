package InfixToPostfix;

import Stack.ArrayStack;
import java.util.ArrayList;

public class InfixToPostfix {

    public static ArrayList<String> InfixToPostfix(String str) {
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
                else if (Character.isLetterOrDigit(str.charAt(i))) {
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

    private static int Priority(char chr) {
        return switch (chr) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }
}
