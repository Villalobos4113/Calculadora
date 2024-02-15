/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package InfixToPostfix;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author fvbit
 */
public class InfixToPostfixTest {
    
    public InfixToPostfixTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of InfixToPostfix method, of class InfixToPostfix.
     */
    @Test
    public void testInfixToPostfix() {
        System.out.println("InfixToPostfix");
        String str = "";
        String expResult = "[]";
        String result = InfixToPostfix.InfixToPostfix(str).toString();
        assertEquals(expResult, result);
        
        str = "3*((34+87)-3(45)+(46/52)+(59+5))";
        expResult = "[3, 34, 87, +, 3, 45, *, -, 46, 52, /, +, 59, 5, +, +, *]";
        result = InfixToPostfix.InfixToPostfix(str).toString();
        assertEquals(expResult, result);
        
        str = "98+64(8489/45)";
        expResult = "[98, 64, 8489, 45, /, *, +]";
        result = InfixToPostfix.InfixToPostfix(str).toString();
        assertEquals(expResult, result);
        
        str = "25%*100";
        expResult = "[0.25, 100, *]";
        result = InfixToPostfix.InfixToPostfix(str).toString();
        assertEquals(expResult, result);
        
        str = "354+891*18/878";
        expResult = "[354, 891, 18, *, 878, /, +]";
        result = InfixToPostfix.InfixToPostfix(str).toString();
        assertEquals(expResult, result);
        
        str = "3541^5426";
        expResult = "[3541, 5426, ^]";
        result = InfixToPostfix.InfixToPostfix(str).toString();
        assertEquals(expResult, result);
    }
    
}
