/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto_ing_software;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author cerro
 */
public class ContattoComparatorTest {
    
    public ContattoComparatorTest() {
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
     * Test of compare method, of class ContattoComparator.
     */
    @Test
    public void testCompare() {
        System.out.println("compareTest");        
        String[] numTel = {"tel1","tel2","tel3"};
        String[] email = {"email1","email2","email3"};
        Contatto c1= new Contatto("giovanni","contursi",numTel,email);
        Contatto c2= new Contatto("federico","cerrone",numTel,email);
        ContattoComparator comp= new ContattoComparator();
        assertTrue(0<comp.compare(c1, c2));
        assertFalse(0>comp.compare(c1, c2));
        assertEquals(0,comp.compare(c1, c1));
        assertEquals(0,comp.compare(c2, c2));
    }
    
    @Test
    public void testCompare1() {
        System.out.println("compareTest1");        
        String[] numTel = {"tel1","tel2","tel3"};
        String[] email = {"email1","email2","email3"};
        Contatto c1= new Contatto("giovanni","",numTel,email);
        Contatto c2= new Contatto("federico","cerrone",numTel,email);
        ContattoComparator comp= new ContattoComparator();
        assertTrue(0<comp.compare(c1, c2));
        
    }
    
    @Test
    public void testCompare2() {
        System.out.println("compareTest2");        
        String[] numTel = {"tel1","tel2","tel3"};
        String[] email = {"email1","email2","email3"};
        Contatto c1= new Contatto("aldo","",numTel,email);
        Contatto c2= new Contatto("federico","cerrone",numTel,email);
        ContattoComparator comp= new ContattoComparator();
        assertTrue(0>comp.compare(c1, c2));
    }
    
    @Test
    public void testCompare3() {
        System.out.println("compareTest3");        
        String[] numTel = {"tel1","tel2","tel3"};
        String[] email = {"email1","email2","email3"};
        Contatto c1= new Contatto("aldo","cerrone",numTel,email);
        Contatto c2= new Contatto("federico","cerrone",numTel,email);
        ContattoComparator comp= new ContattoComparator();
        assertTrue(0>comp.compare(c1, c2));
        assertFalse(0<comp.compare(c1,c2));
    }
    
}
