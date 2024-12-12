/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto_ing_software;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Gruppo 23
 */
public class InOutRubricaTest {
    List<Contatto> list1;
    List<Contatto> list2;
    
    public InOutRubricaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        System.out.println("Set Up liste");
        list1 = new ArrayList<Contatto>();
        list2 = new ArrayList<>();
        String[] numTel = {"tel1","tel2","tel3"};
        String[] email = {"email1","email2","email3"};
        Contatto c= new Contatto("Giovanni","Contursi",numTel,email);
        list1.add(c);
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("Cleaning lists");
        list1.clear();
        list2.clear();
    }

    /**
     * Test of salvaRubrica method, of class InOutRubrica.
     */
    @Test
    public void testSalvaRubrica() {
        System.out.println("salvaRubricaTest");
        
        
        InOutRubrica r=new InOutRubrica();
        r.salvaRubrica(list1);
        
        list2=r.caricaRubrica(list2);
        assertEquals(list1.get(0).toString(),list2.get(0).toString());
    }

    /**
     * Test of caricaRubrica method, of class InOutRubrica.
     */
    @Test
    public void testCaricaRubrica() {
        System.out.println("caricaRubricaTest");
        
        InOutRubrica r=new InOutRubrica();
        r.salvaRubrica(list1);
        
        list2=r.caricaRubrica(list2);
        assertEquals(list1.get(0).toString(),list2.get(0).toString());
    }
    
}
