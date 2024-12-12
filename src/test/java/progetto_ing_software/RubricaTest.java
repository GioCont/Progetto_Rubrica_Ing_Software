/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
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
public class RubricaTest {
    private List<Contatto> lista;
    Contatto contatto1;
    Contatto contatto2;
    Contatto contatto3;
    
    public RubricaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        System.out.println("Set up contatti standard");
        lista = new ArrayList<Contatto>();
        String[] numTel1 = {"3315783174","3357230290","3929261904"};
        String[] email1 = {"g.contursi@gmail.com","gio.contursi2003@gmail.com","giovanni.contursi03@gmail.com"};
        contatto1 = new Contatto("Giovanni","Contursi",numTel1,email1);
        String[] numTel2 = {"3920393265","3277115278","3319671661"};
        String[] email2 = {"f.cerrone@gmail.com","fede.cerrone@gmail.com","federico.cerrone04@gmail.com"};
        contatto2 = new Contatto("Federico","Cerrone",numTel2,email2);
        String[] numTel3 = {"3319671661","3930842608","3384783469"};
        String[] email3 = {"g.marolda@gmail.com","gius.marolda@gmail.com","giuseppe.marolda@gmail.com"};
        contatto3 = new Contatto("Giuseppe","Marolda",numTel3,email3);
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("Cleaning lista");
        lista.clear();
    }

    /**
     * Test of getContatti method, of class Rubrica.
     */
    @Test
    public void testGetContatti() {
        System.out.println("getContatti Test");
        Rubrica rubricaTest = new Rubrica();
        rubricaTest.addContatto(contatto1);
        rubricaTest.addContatto(contatto2);
        rubricaTest.addContatto(contatto3);
        lista = rubricaTest.getContatti();
        assertEquals(lista,rubricaTest.getContatti());
        assertNotNull(lista);
    }

    /**
     * Test of addContatto method, of class Rubrica.
     */
    @Test
    public void testAddContatto() {
        System.out.println("addContatto Test");
        Rubrica rubricaTest = new Rubrica();
        rubricaTest.addContatto(contatto2);
        assertNotNull(rubricaTest);
        lista.add(contatto2);
        assertEquals(lista,rubricaTest.getContatti());
    }

    /**
     * Test of removeContatto method, of class Rubrica.
     */
    @Test
    public void testRemoveContatto() {
        System.out.println("removeContatto Test");
        Rubrica rubricaTest = new Rubrica();
        rubricaTest.addContatto(contatto1);
        rubricaTest.addContatto(contatto2);
        rubricaTest.addContatto(contatto3);
        lista.add(contatto2);
        lista.add(contatto1);
        rubricaTest.removeContatto(contatto3);
        assertEquals(lista,rubricaTest.getContatti());
    }

    /**
     * Test of modificaContatto method, of class Rubrica.
     */
    @Test
    public void testModificaContatto() {
        System.out.println("modificaContatto Test");
        Rubrica rubricaTest = new Rubrica();
        rubricaTest.addContatto(contatto1);
        rubricaTest.addContatto(contatto2);
        rubricaTest.addContatto(contatto3);
        String[] numTel4 = {"1212121","2323232","3434343"};
        String[] email4 = {"prova@10","prova@11","prova@12"};
        Contatto d= new Contatto("Nicolas","De Stefano",numTel4,email4);
        lista.add(contatto2);
        lista.add(d);
        lista.add(contatto3);
        rubricaTest.modificaContatto(0, d);
        assertEquals(lista, rubricaTest.getContatti());
        
    }

    /**
     * Test of salvaRubrica method, of class Rubrica.
     */
    @Test
    public void testSalvaRubrica() {
        System.out.println("salvaRubricaTest");
        Rubrica rubricaTest = new Rubrica();
        rubricaTest.addContatto(contatto1);
        lista.add(contatto1);
        rubricaTest.salvaRubrica();
        assertEquals(lista,rubricaTest.getContatti());
    }

    /**
     * Test of caricaRubrica method, of class Rubrica.
     */
    @Test
    public void testCaricaRubrica() {
        System.out.println("caricaRubrica Test");
        Rubrica rubricaTest = new Rubrica();
        Rubrica secondaRubrica = new Rubrica();
        rubricaTest.addContatto(contatto1);
        rubricaTest.addContatto(contatto2);
        rubricaTest.addContatto(contatto3);
        rubricaTest.salvaRubrica();
        secondaRubrica.caricaRubrica();
        assertNotNull(secondaRubrica);

    }

    /**
     * Test of ricercaContatti method, of class Rubrica.
     */
    @Test
    public void testRicercaContatti() {
        System.out.println("ricercaContatti Test");
        Rubrica rubricaTest = new Rubrica();
        List<Contatto> rif = new ArrayList<Contatto>();
        rubricaTest.addContatto(contatto1);
        rubricaTest.addContatto(contatto2);
        rubricaTest.addContatto(contatto3);
        lista.add(contatto1);
        rif = rubricaTest.ricercaContatti("Giovanni");
        assertEquals(rif.get(0),lista.get(0));
    }
    
}