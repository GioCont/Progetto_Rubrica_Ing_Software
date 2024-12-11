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
 * @author Giovanni
 */
public class RubricaTest {
    private List<Contatto> lista;
    
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
        String[] numTel1 = {"tel12","tel22","tel32"};
        String[] email1 = {"email12","email22","email32"};
        Contatto a= new Contatto("Federico","Cerrone",numTel1,email1);
        String[] numTel2 = {"tel13","tel23","tel33"};
        String[] email2 = {"email13","email23","email33"};
        Contatto b= new Contatto("Federico","Cerrone",numTel2,email2);
        String[] numTel3 = {"tel14","tel24","tel34"};
        String[] email3 = {"email14","email24","email34"};
        Contatto c= new Contatto("Federico","Cerrone",numTel3,email3);
        rubricaTest.addContatto(a);
        rubricaTest.addContatto(b);
        rubricaTest.addContatto(c);
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
        String[] numTel1 = {"tel12","tel22","tel32"};
        String[] email1 = {"email12","email22","email32"};
        Contatto a= new Contatto("Federico","Cerrone",numTel1,email1);
        rubricaTest.addContatto(a);
        assertNotNull(rubricaTest);
        lista.add(a);
        assertEquals(lista,rubricaTest.getContatti());
    }

    /**
     * Test of removeContatto method, of class Rubrica.
     */
    @Test
    public void testRemoveContatto() {
        System.out.println("removeContatto Test");
        Rubrica rubricaTest = new Rubrica();
        String[] numTel1 = {"121212","222222","33333"};
        String[] email1 = {"email12","email22","email222"};
        Contatto a= new Contatto("Nicolas","De Stefano",numTel1,email1);
        String[] numTel2 = {"2233223","4444","999999"};
        String[] email2 = {"emai7777","emai3333","email6566"};
        Contatto b= new Contatto("Nicolas","De Stefano",numTel2,email2);
        String[] numTel3 = {"66666","767677","3232323"};
        String[] email3 = {"email65566","email43434","emai333333"};
        Contatto c= new Contatto("Pierluigi","Cinque",numTel3,email3);
        rubricaTest.addContatto(a);
        rubricaTest.addContatto(b);
        rubricaTest.addContatto(c);
        lista.add(a);
        lista.add(b);
        rubricaTest.removeContatto(c);
        assertEquals(lista,rubricaTest.getContatti());
    }

    /**
     * Test of modificaContatto method, of class Rubrica.
     */
    @Test
    public void testModificaContatto() {
        System.out.println("modificaContatto Test");
        Rubrica rubricaTest = new Rubrica();
        String[] numTel1 = {"1111111","222222","333333"};
        String[] email1 = {"prova@1","prova@2","prova@3"};
        Contatto a= new Contatto("Nicolas","De Stefano",numTel1,email1);
        String[] numTel2 = {"444444","55555","66666"};
        String[] email2 = {"prova@4","prova@5","prova@6"};
        Contatto b= new Contatto("Giovanni","Contursi",numTel2,email2);
        String[] numTel3 = {"777777","888888","99999"};
        String[] email3 = {"prova@7","prova@8","prova@9"};
        Contatto c= new Contatto("Pierluigi","Cinque",numTel3,email3);
        rubricaTest.addContatto(a);
        rubricaTest.addContatto(b);
        rubricaTest.addContatto(c);
        String[] numTel4 = {"1212121","2323232","3434343"};
        String[] email4 = {"prova@10","prova@11","prova@12"};
        Contatto d= new Contatto("Federico","Cerrone",numTel1,email1);
        lista.add(d);
        lista.add(c);
        lista.add(b);
        rubricaTest.modificaContatto(0, d);
        assertEquals(lista, rubricaTest.getContatti());
        
    }

    /**
     * Test of salvaRubrica method, of class Rubrica.
     */
    @Test
    public void testSalvaRubrica() {
        System.out.println("salvaRubrica");
        Rubrica rubricaTest = new Rubrica();
        String[] numTel1 = {"1111111","222222","333333"};
        String[] email1 = {"prova@1","prova@2","prova@3"};
        Contatto a= new Contatto("Giovanni","Contursi",numTel1,email1);
        rubricaTest.addContatto(a);
        lista.add(a);
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
        String[] numTel1 = {"1111111","222222","333333"};
        String[] email1 = {"prova@1","prova@2","prova@3"};
        Contatto a= new Contatto("Nicolas","De Stefano",numTel1,email1);
        String[] numTel2 = {"444444","55555","66666"};
        String[] email2 = {"prova@4","prova@5","prova@6"};
        Contatto b= new Contatto("Giovanni","Contursi",numTel2,email2);
        String[] numTel3 = {"777777","888888","99999"};
        String[] email3 = {"prova@7","prova@8","prova@9"};
        Contatto c= new Contatto("Pierluigi","Cinque",numTel3,email3);
        rubricaTest.addContatto(a);
        rubricaTest.addContatto(b);
        rubricaTest.addContatto(c);
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
        String[] numTel1 = {"1111111","222222","333333"};
        String[] email1 = {"prova@1","prova@2","prova@3"};
        Contatto a= new Contatto("Nicolas","De Stefano",numTel1,email1);
        String[] numTel2 = {"444444","55555","66666"};
        String[] email2 = {"prova@4","prova@5","prova@6"};
        Contatto b= new Contatto("Giovanni","Contursi",numTel2,email2);
        String[] numTel3 = {"777777","888888","99999"};
        String[] email3 = {"prova@7","prova@8","prova@9"};
        Contatto c= new Contatto("Pierluigi","Cinque",numTel3,email3);
        rubricaTest.addContatto(a);
        rubricaTest.addContatto(b);
        rubricaTest.addContatto(c);
        lista.add(b);
        rif = rubricaTest.ricercaContatti("Giovanni");
        assertEquals(rif.get(0),lista.get(0));
    }
    
}
