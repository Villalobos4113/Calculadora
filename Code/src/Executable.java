import Solve.Solve;

public class Executable {
    public static void main(String[] args) {
        System.out.println("Solve");

        int noPruebas = (int) (Math.random() * ((100000 - 1) + 1)) + 1;
        String str, expResult, result;
        boolean flag = true;
        int i = 0;

        while (i < noPruebas && flag) {
            double n1 = (Math.random() * ((1000000 - 1) + 1)) + 1, n2 = (Math.random() * ((1000000 - 1) + 1)) + 1;
            int operator = (int) (Math.random() * ((5 - 1) + 1)) + 1;
            str = operacionStr(n1, n2, operator);
            expResult = operacion(n1, n2, operator);
            result = Solve.Solve(str);
            flag = (expResult.equals(result));
            i++;
        }

        System.out.println(flag + " " + noPruebas);

        str = "3*((34+87)-3(45)+(46/52)+(59+5))";
        expResult = "152.65384615384616";
        result = Solve.Solve(str);
        System.out.println(expResult.equals(result));

        str = "98+64(8489/45)";
        expResult = "12171.244444444445";
        result = Solve.Solve(str);
        System.out.println(expResult.equals(result));

        str = "25%*100";
        expResult = "25.0";
        result = Solve.Solve(str);
        System.out.println(expResult.equals(result));
    }

    public static String operacion(double n1, double n2, int operator) {
        double resp = 0;

        switch (operator) {
            case 1 -> resp = n1 + n2;
            case 2 -> resp = n1 - n2;
            case 3 -> resp = n1 * n2;
            case 4 -> resp = n1 / n2;
            case 5 -> resp = Math.pow(n1, n2);
        }

        return Double.toString(resp);
    }

    public static String operacionStr(double n1, double n2, int operator) {

        return switch (operator) {
            case 1 -> Double.toString(n1) + "+" + Double.toString(n2);
            case 2 -> Double.toString(n1) + "-" + Double.toString(n2);
            case 3 -> Double.toString(n1) + "*" + Double.toString(n2);
            case 4 -> Double.toString(n1) + "/" + Double.toString(n2);
            case 5 -> Double.toString(n1) + "^" + Double.toString(n2);
            default -> "";
        };
    }
}
