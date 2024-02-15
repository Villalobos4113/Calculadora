/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Syntax;

import Stack.ArrayStack;
/**
 * Clase que representa la revisión de la sintáxis de las operaciones en la calculadora.
 * @author Aldo Soria
 * @author Fernando Villalobos
 * @author Fernando Espinoza
 * @author Óscar Manuel Martínez
 * @author Luis Eduardo Suárez
 */
public class Syntax {
    /**
     * Verifica que la sintáxis de las operaciones a calcular sea correcta.
     * @param str Operaciones a resolver como String.
     * @return True si la sintáxis es correcta y False si es incorrecta.
     */
    public static boolean Syntax(String str) {
        ArrayStack<Character> stack = new ArrayStack<Character>();
        boolean resp = true;

        if (str.length() > 0) {
            if (!isNumeric(str)) {
                int i = 0;
                boolean operator = false, point = false;

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

                        // % in correct position
                        if (str.charAt(i) == '%') {
                            if (i - 1 >= 0 && !Character.isDigit(str.charAt(i - 1)))
                                resp = false;
                            if (i + 1 < str.length() && Character.isDigit(str.charAt(i + 1)))
                                resp = false;
                        }

                        // Not double point
                        if (Character.isDigit(str.charAt(i)) || str.charAt(i) == '.') {
                            if (str.charAt(i) == '.') {
                                if (point)
                                    resp = false;
                                else
                                    point = true;
                            }
                        } else
                            point = false;

                        // Not empty parentheses
                        if (i + 1 < str.length() && str.charAt(i) == '(' && str.charAt(i + 1) == ')')
                            resp = false;
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
    /**
     * Especifica que caracteres son permitidos en la calculadora.
     * @param chr
     * @return True si los caracteres son permitidos y false si no lo son.
     */
    private static boolean CharAllowed(char chr) {

        return switch (chr) {
            case '(', ')', '.', '+', '-', '*', '/', '^', '%', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> true;
            default -> false;
        };
    }
    /**
     * Verifica si la operación es válida.
     * @param str
     * @return True si la operación es válida y False si no lo es.
     */
    private static boolean validOperation(String str) {
        boolean num1 = false, operator = false, num2 = false;
        int i = 0;

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

        return num1 && operator && num2;
    }
    /**
     * Verifica si una expresión es un número.
     * @param strNum
     * @return True si la expresión es un número y false si no lo es.
     */
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

