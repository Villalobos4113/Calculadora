package Solve;

import InfixToPostfix.InfixToPostfix;
import Stack.ArrayStack;
import Syntax.Syntax;
import java.util.ArrayList;

public class Solve {
    public static String Solve(String str) {
        ArrayStack<String> stack = new ArrayStack<String>();
        String resp = "";

        if (Syntax.Syntax(str)) {
            if (!isNumeric(str)) {
                ArrayList<String> arrayList = InfixToPostfix.InfixToPostfix(str);
                String operator;
                int i = 0;

                while (i < arrayList.size()) {
                    operator = arrayList.get(i);

                    if (isNumeric(operator))
                        stack.push(operator);
                    else {
                        i -= 2;
                        String num1 = arrayList.get(i), num2 = arrayList.get(i + 1);

                        arrayList.remove(i);
                        arrayList.remove(i);

                        if (operator.equals("/") && Double.parseDouble(num2) == 0) {
                            resp = "ERROR: CANNOT DIVIDE BY ZERO";
                            i = arrayList.size();
                        } else
                            arrayList.set(i, Operation(num1, num2, operator));
                    }

                    i++;
                }

                if (!(i > arrayList.size()))
                    resp = arrayList.get(0);
            } else
                resp = str;
        } else
            resp = "SYNTAX ERROR";

        return resp;
    }

    private static String Operation(String num1, String num2, String operator) {
        double resp = 0;

        switch (operator) {
            case "+":
                resp = Double.parseDouble(num1) + Double.parseDouble(num2);
                break;
            case "-":
                resp = Double.parseDouble(num1) - Double.parseDouble(num2);
                break;
            case "*":
                resp = Double.parseDouble(num1) * Double.parseDouble(num2);
                break;
            case "/":
                resp = Double.parseDouble(num1) / Double.parseDouble(num2);
                break;
            case "^":
                resp = Math.pow(Double.parseDouble(num1), Double.parseDouble(num2));
                break;
        }
        return Double.toString(resp);
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
}
