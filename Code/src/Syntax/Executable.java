package Syntax;

public class Executable {
    public static void main(String[] args) {
        System.out.println(" 1: " + Syntax.Syntax("") + " -> false");
        System.out.println(" 2: " + Syntax.Syntax("3*((34+87)-3(45)+(46/52)+(59+5))") + "  -> true");
        System.out.println(" 3: " + Syntax.Syntax("(95-8)*(89/4))") + " -> false");
        System.out.println(" 4: " + Syntax.Syntax("3*(((648*5)-(978-65))+(1489/98))") + "  -> true");
        System.out.println(" 5: " + Syntax.Syntax("Hola") + " -> false");
        System.out.println(" 6: " + Syntax.Syntax("3 * ((34 + 87) - 3(45) + (46 / 52) + (59 + 5))") + "  -> true");
        System.out.println(" 7: " + Syntax.Syntax("3") + "  -> true");
        System.out.println(" 8: " + Syntax.Syntax("3+") + " -> false");
        System.out.println(" 9: " + Syntax.Syntax("9-5*(3+-8)") + " -> false");
        System.out.println("10: " + Syntax.Syntax("3.8+8.5") + "  -> true");
        System.out.println("11: " + Syntax.Syntax("33.8.5+8") + "  -> false");
        System.out.println("12: " + Syntax.Syntax("3%*100") + "  -> true");
    }
}
