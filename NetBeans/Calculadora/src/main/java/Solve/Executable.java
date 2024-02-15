/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solve;

/**
 *
 * @author fvbit
 */
public class Executable {
    public static void main(String[] args) {
        System.out.println(Solve.Solve("-2.3.5-4"));
        System.out.println(Solve.Solve("3((34+87) - 3(45) + (46 / 52) + (59 + 5))"));
        System.out.println(Solve.Solve("3((34+87)-3(45+2)+(46/52)+(59+5))"));
        System.out.println(Solve.Solve("3(((())))"));
        System.out.println(Solve.Solve("1/(2-2)"));
        System.out.println(Solve.Solve("10(7+9)"));
        System.out.println(Solve.Solve("35%*100"));
    }
}
