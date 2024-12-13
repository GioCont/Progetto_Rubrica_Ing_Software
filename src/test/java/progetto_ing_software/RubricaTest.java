/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package progetto_ing_software;

import entita.Rubrica;
import entita.Contatto;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * *@file RubricaTest.java
 * @brief Classe di test di tutti i metodi della classe Rubrica.
 * 
 * All'interno di questa classe vengono definiti tanti metodi quanti la classe Rubrica contiene.
 * Per ogni metodo è stato implementato un test che ne verifichi il corretto funzionamento.
 * 
 * @version 1.0
 * @author Gruppo 23
 * @date 13/12/2024
 * 
 */
public class RubricaTest {
    private List<Contatto> lista;
    Contatto contatto1;
    Contatto contatto2;
    Contatto contatto3;
    static File file;
    
    public RubricaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        file = new File("RubricaTest");
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
     /**
     * @brief Utilizzo del metodo BeforeEach per instanziare delle liste e dei contatti di base.
     * 
     * All'interno di questa funzione si definisce che, prima di ogni test, venga instanziata una lista e definiti 3 contatti
     * standard che saranno utilizzati in seguito.
     * 
     */
    @BeforeEach
    public void setUp() {
        System.out.println("Set up contatti standard");
        lista = new ArrayList<Contatto>();
        String[] numTel1 = {"3315783174","3357230290","3929261904"};
        String[] email1 = {"g.contursi@gmail.com","gio.contursi2003@gmail.com","giovanni.contursi03@gmail.com"};
        contatto1 = new Contatto("Contursi","Giovanni",numTel1,email1);
        String[] numTel2 = {"3920393265","3277115278","3319671661"};
        String[] email2 = {"f.cerrone@gmail.com","fede.cerrone@gmail.com","federico.cerrone04@gmail.com"};
        contatto2 = new Contatto("Cerrone","Federico",numTel2,email2);
        String[] numTel3 = {"3319671661","3930842608","3384783469"};
        String[] email3 = {"g.marolda@gmail.com","gius.marolda@gmail.com","giuseppe.marolda@gmail.com"};
        contatto3 = new Contatto("Marolda","Giuseppe",numTel3,email3);
    }
    /**
     * @brief Utilizzo del metodo AfterEach per svuotare le liste.
     * 
     * All'interno di questa funzione si definisce che, dopo di ogni test, venga printato lo stato del processo e 
     * che la lista venga svuotata.
     * 
     */
    @AfterEach
    public void tearDown() {
        System.out.println("Cleaning lista");
        lista.clear();
    }

    /**
     * @brief All'interno di questa funzione viene testato il metodo getContatti().
     * 
     * All'interno di questa funzione vengono aggiunti i contatti definiti prima ad una rubrica,
     * per poi inserirli tramite il metodo getContatti in una lista e infine controlla tramite il metodo
     * assertEquals che la get sia avvenuta con successo confrontando la lista e la rubrica.
     * 
     * @see addContatto(), getContatto().
     * 
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
     * @brief Questa funzione testa il metodo addContatto().
     * 
     * All'interno di questa funzione viene aggiunto lo stesso contatto ad una rubrica tramite
     * il metodo addContatto() e ad una lista, per poi controllare con asserTEquals che la add alla rubrica
     * sia stata eseguita con successo.
     * 
     * @see addContatto().
     * 
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
     * @brief Questa funzione testa il metodo removeContatto().
     * 
     * All'interno di questa funzione vengono aggiunti dei contatti ad una rubrica tramite
     * il metodo addContatto() e ad una lista, per poi rimuoverne uno e controllare con asserTEquals che il
     * contatto sia stato rimosso con successo dalla rubrica.
     * 
     * @see addContatto(),removeContatto().
     * 
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
     * @brief Questa funzione testa il metodo modificaContatto().
     * 
     * All'interno di questa funzione vengono aggiunti dei contatti ad una rubrica tramite
     * il metodo addContatto() e ad una lista, per poi modificarne uno e controllare con asserTEquals che il
     * contatto sia stato modificato con successo nella rubrica.
     * 
     * @see addContatto(),modificaContatto().
     * 
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
        lista.add(contatto3);
        lista.add(d);
        rubricaTest.modificaContatto(0, d);
        assertEquals(lista, rubricaTest.getContatti());
        
    }

     /**
     * @brief Questa funzione testa il metodo salvaRubrica().
     * 
     * All'interno di questa funzione vengono aggiunti dei contatti ad una rubrica tramite
     * il metodo addContatto() e ad una lista, per poi salvarla e controllare con asserTEquals che il
     * contatto sia stato salvato con successo nella rubrica.
     * 
     * @see addContatto(),salvaRubrica().
     * 
     */
    @Test
    public void testSalvaRubrica() {
        System.out.println("salvaRubricaTest");
        Rubrica rubricaTest = new Rubrica();
        rubricaTest.addContatto(contatto1);
        lista.add(contatto1);
        rubricaTest.salvaRubrica(file);
        assertEquals(lista,rubricaTest.getContatti());
    }

     /**
     * @brief Questa funzione testa il metodo caricaRubrica().
     * 
     * All'interno di questa funzione vengono aggiunti dei contatti ad una rubrica tramite
     * il metodo addContatto(), per poi caricarla su un'altra rubrica e controllare con asserTEquals che i
     * contatti siano stati caricati con successo nella rubrica.
     * 
     * @see addContatto(),caricaRubrica().
     * 
     */
    @Test
    public void testCaricaRubrica() {
        System.out.println("caricaRubrica Test");
        Rubrica rubricaTest = new Rubrica();
        Rubrica secondaRubrica = new Rubrica();
        rubricaTest.addContatto(contatto1);
        rubricaTest.addContatto(contatto2);
        rubricaTest.addContatto(contatto3);
        rubricaTest.salvaRubrica(file);
        secondaRubrica.caricaRubrica(file);
        assertNotNull(secondaRubrica);

    }

     /**
     * @brief Questa funzione testa il metodo ricercaContatto().
     * 
     * All'interno di questa funzione vengono aggiunti dei contatti ad una rubrica tramite
     * il metodo addContatto() e ad una lista, per poi cercarne uno e controllare con asserTEquals che il
     * contatto sia stato cercato e aggiunto con successo nella lista di riferimento.
     * 
     * @see addContatto(),modificaContatto().
     * 
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