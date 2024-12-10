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
 * @author cerro
 */
public class InOutRubricaTest {
    
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
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of salvaRubrica method, of class InOutRubrica.
     */
    @Test
    public void testSalvaRubrica() {
        System.out.println("salvaRubrica");
        List<Contatto> list1 = new ArrayList<Contatto>();
        List<Contatto> list2 = new ArrayList<>();
        String[] numTel = {"tel1","tel2","tel3"};
        String[] email = {"email1","email2","email3"};
        Contatto c= new Contatto("giovanni","contursi",numTel,email);
        list1.add(c);
        
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
        System.out.println("salvaRubrica");
        List<Contatto> list1 = new ArrayList<Contatto>();
        List<Contatto> list2 = new ArrayList<>();
        String[] numTel = {"tel1","tel2","tel3"};
        String[] email = {"email1","email2","email3"};
        Contatto c= new Contatto("giovanni","contursi",numTel,email);
        list1.add(c);
        
        InOutRubrica r=new InOutRubrica();
        r.salvaRubrica(list1);
        
        list2=r.caricaRubrica(list2);
        assertEquals(list1.get(0).toString(),list2.get(0).toString());
    }
    
}
