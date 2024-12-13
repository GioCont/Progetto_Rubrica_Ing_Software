/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto_ing_software;

import utilita.InOutRubrica;
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
 * *@file InOutRubricaTest.java
 * @brief Classe di test di tutti i metodi della classe InOutRubrica.
 * 
 * All'interno di questa classe vengono definiti tanti metodi quanti la classe InOutRubrica contiene.
 * Per ogni metodo è stato implementato un test che ne verifichi il corretto funzionamento.
 * 
 * @version 1.0
 * @author Gruppo 23
 * @date 13/12/2024
 * 
 */
public class InOutRubricaTest {
    List<Contatto> list1;
    List<Contatto> list2;
    static File file;
    
    public InOutRubricaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        file= new File("InOutRubricaTest");
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
     /**
     * @brief Utilizzo del metodo BeforeEach per instanziare delle liste di base.
     * 
     * All'interno di questa funzione si definisce che, prima di ogni test, vengano instanziati all'interno delle
     * liste standard, dei valori che saranno poi utilizzati nei test.
     * 
     */
    @BeforeEach
    public void setUp() {
        System.out.println("Set Up liste");
        list1 = new ArrayList<Contatto>();
        list2 = new ArrayList<>();
        String[] numTel = {"tel1","tel2","tel3"};
        String[] email = {"email1","email2","email3"};
        Contatto c= new Contatto("Contursi","Giovanni",numTel,email);
        list1.add(c);
    }
    /**
     * @brief Utilizzo del metodo AfterEach per svuotare le liste.
     * 
     * All'interno di questa funzione si definisce che, dopo di ogni test, venga printato lo stato del processo e 
     * che le liste vengano svuotate.
     * 
     */
    @AfterEach
    public void tearDown() {
        System.out.println("Cleaning lists");
        list1.clear();
        list2.clear();
    }

    /**
     * @brief Questa funzione testa il metodo salvaRubrica definito nella classe InOutrubrica.
     * 
     * All'interno di questa funzione viene prima salvata una delle due liste standard all'interno
     * di una rubrica, passando anche un file come parametro, se succesivamente si controlla che il 
     * salvataggio sia avvenuto correttamente caricando sulla seconda lista ciò che è stato
     * salvato, per poi utilizzare il metodo assertEqual tra le due e controllare che siano uguali.
     * 
     * @see salvaRubrica(), caricaRubrica().
     * 
     */
    @Test
    public void testSalvaRubrica() {
        System.out.println("salvaRubricaTest");
        
        
        InOutRubrica r=new InOutRubrica();
        r.salvaRubrica(list1,file);
        
        list2=r.caricaRubrica(list1,file);
        assertEquals(list1.get(0).toString(),list2.get(0).toString());
    }

      /**
     * @brief Questa funzione testa il metodo caricaRubrica definito nella classe InOutRubrica.
     * 
     * All'interno di questa funzione viene prima salvata una delle due liste standard all'interno
     * di una rubrica, passando anche un file come parametro, succesivamente carica sulla seconda lista ciò che è stato
     * salvato, per poi utilizzare il metodo assertEqual tra le due e controllare che il caricamento della rubrica sia
     * avvenuto correttamente.
     * 
     * @see salvaRubrica(), caricaRubrica().
     * 
     */
    @Test
    public void testCaricaRubrica() {
        System.out.println("caricaRubricaTest");
        
        InOutRubrica r=new InOutRubrica();
        r.salvaRubrica(list1,file);
        
        list2=r.caricaRubrica(list2,file);
        assertEquals(list1.get(0).toString(),list2.get(0).toString());
    }
    
}
