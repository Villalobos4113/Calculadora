package InfixToPostfix;

public class Executable {
    public static void main(String[] args) {

        System.out.println(InfixToPostfix.InfixToPostfix("3*((34+87)-3(45)+(46/52)+(59+5))"));
        System.out.println(InfixToPostfix.InfixToPostfix("98+64(8489/45)"));
        System.out.println(InfixToPostfix.InfixToPostfix("25%*100"));
        System.out.println(InfixToPostfix.InfixToPostfix("354+891*18/878"));
        System.out.println(InfixToPostfix.InfixToPostfix("3541^5426"));

    }
}
