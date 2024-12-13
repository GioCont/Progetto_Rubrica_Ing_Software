/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto_ing_software;

import Classi_Funzionali.ContattoComparator;
import Entità.Contatto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *@file ContattoComparatorTest.java
 * @brief Classe di test di tutti i metodi della classe ContattoComparator.
 * 
 * All'interno di questa classe vengono definiti tanti metodi quanti la classe ContattoComparator contiene.
 * Per ogni metodo è stato implementato un test che ne verifichi il corretto funzionamento.
 * 
 * @version 1.0
 * @author Gruppo 23
 * @date 12/12/2024
 */
public class ContattoComparatorTest {
    Contatto contatto1;
    Contatto contatto2;
    
    public ContattoComparatorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    
    /**
     * @brief Utilizzo del metodo BeforeEach per instanziare dei conatti di base.
     * 
     * All'interno di questa funzione si definisce che, prima di ogni test, vengano instanziati all'interno dei
     * contatti standard, dei valori che saranno poi utilizzati nei test.
     * 
     */
    
    @BeforeEach
    public void setUp() {
        System.out.println("Set up contatti standard");
        String[] numTel1 = {"3315783174","3357230290","3929261904"};
        String[] email1 = {"g.contursi@gmail.com","gio.contursi2003@gmail.com","giovanni.contursi03@gmail.com"};
        contatto1 = new Contatto("Contursi","Giovanni",numTel1,email1);
        String[] numTel2 = {"3920393265","3277115278","3319671661"};
        String[] email2 = {"f.cerrone@gmail.com","fede.cerrone@gmail.com","federico.cerrone04@gmail.com"};
        contatto2 = new Contatto("Cerrone","Federico",numTel2,email2);
        
    }
    
    /**
     * @brief Utilizzo del metodo AfterEach per un print.
     * 
     * All'interno di questa funzione si definisce che, dopo di ogni test, venga printato lo stato del processo.
     * 
     */
    @AfterEach
    public void tearDown() {
        System.out.println("Clear standard var");
    }

    /**
     * @brief Test del metodo compare della classe ContattoComparator.
     * 
     * Questi test utilizzano i contatti creati nel BeforeEach per testare il funzionamento del metodo 
     * compare, controllando in base all'ordine di inserimento dei contatti i valori restituiti.
     * @see compare()
     * 
     */
    @Test
    public void testCompare() {
        System.out.println("compareTest");        
        ContattoComparator comp= new ContattoComparator();
        assertTrue(0<comp.compare(contatto1, contatto2));
        assertFalse(0>comp.compare(contatto1, contatto2));
        assertEquals(0,comp.compare(contatto1, contatto1));
        assertEquals(0,comp.compare(contatto2, contatto2));
    }
    
    @Test
    public void testCompare1() {
        System.out.println("compareTest1");        
        contatto1.setCognome("");
        ContattoComparator comp= new ContattoComparator();
        assertTrue(0<comp.compare(contatto1, contatto2));
        
    }
    
    @Test
    public void testCompare2() {
        System.out.println("compareTest2");        
        contatto1.setNome("Aldo");
        contatto1.setCognome("");
        ContattoComparator comp= new ContattoComparator();
        assertTrue(0>comp.compare(contatto1, contatto2));
    }
    
    @Test
    public void testCompare3() {
        System.out.println("compareTest3");        
        contatto1.setNome("Aldo");
        contatto1.setCognome("Cerrone");
        ContattoComparator comp= new ContattoComparator();
        assertTrue(0>comp.compare(contatto1, contatto2));
        assertFalse(0<comp.compare(contatto1,contatto2));
    }
    
}
