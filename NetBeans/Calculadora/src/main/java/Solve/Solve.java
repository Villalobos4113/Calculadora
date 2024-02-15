/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solve;

import InfixToPostfix.InfixToPostfix;
import Stack.ArrayStack;
import Syntax.Syntax;
import java.util.ArrayList;
/**
 * Clase que representa la resolución de la operación planteada en la calculadora.
 * @author Aldo Soria
 * @author Fernando Villalobos
 * @author Fernando Espinoza
 * @author Óscar Manuel Martínez
 * @author Luis Eduardo Suárez
 */
public class Solve {
    /**
     * Resuelve las operaciones planteadas en la calculadora.
     * @param str Operaciones a resolver como String.
     * @return El resultado de las operaciones.
     */
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
    /**
     * Verifica el tipo de operación a resolver y la realiza.
     * @param num1 Número 1
     * @param num2 Número 2
     * @param operator Operador
     * @return La respuesta de una operación.
     */
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
    /**
     * Verifica si una expresión es un número.
     * @param strNum Expresión numérica
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