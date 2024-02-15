/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Syntax;

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
public class SyntaxTest {
    
    public SyntaxTest() {
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
     * Test of Syntax method, of class Syntax.
     */
    @Test
    public void testSyntax() {
        System.out.println("Syntax");
        
        String str = "";
        boolean expResult = false;
        boolean result = Syntax.Syntax(str);
        assertEquals(expResult, result);
        
        str = "3*((34+87)-3*(45)+(46/52)+(59+5))";
        expResult = true;
        result = Syntax.Syntax(str);
        assertEquals(expResult, result);
        
        str = "(95-8)*(89/4))";
        expResult = false;
        result = Syntax.Syntax(str);
        assertEquals(expResult, result);
        
        str = "3*(((648*5)-(978-65))+(1489/98))";
        expResult = false;
        result = Syntax.Syntax(str);
        assertEquals(expResult, result);
        
        str = "Hola";
        expResult = false;
        result = Syntax.Syntax(str);
        assertEquals(expResult, result);
        
        str = "3 * ((34 + 87) - 3(45) + (46 / 52) + (59 + 5))";
        expResult = true;
        result = Syntax.Syntax(str);
        assertEquals(expResult, result);
        
        str = "3";
        expResult = true;
        result = Syntax.Syntax(str);
        assertEquals(expResult, result);
        
        str = "3*";
        expResult = false;
        result = Syntax.Syntax(str);
        assertEquals(expResult, result);
        
        str = "9-5*(3+-8)";
        expResult = false;
        result = Syntax.Syntax(str);
        assertEquals(expResult, result);
        
        str = "3.8+8.5";
        expResult = true;
        result = Syntax.Syntax(str);
        assertEquals(expResult, result);
        
        str = "33.8.5+8";
        expResult = false;
        result = Syntax.Syntax(str);
        assertEquals(expResult, result);
        
        str = "3%*100";
        expResult = true;
        result = Syntax.Syntax(str);
        assertEquals(expResult, result);
        
        str = "3(7)";
        expResult = true;
        result = Syntax.Syntax(str);
        assertEquals(expResult, result);
    }
    
}
