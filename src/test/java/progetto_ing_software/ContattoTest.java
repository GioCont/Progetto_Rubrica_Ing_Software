/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto_ing_software;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * *@file ContattoTest.java
 * @brief Classe di test di tutti i metodi della classe Contatto.
 * 
 * All'interno di questa classe vengono definiti tanti metodi quanti la classe Contatto contiene.
 * Per ogni metodo è stato implementato un test che ne verifichi il corretto funzionamento.
 * 
 * @version 1.0
 * @author Gruppo 23
 * @date 13/12/2024
 * 
 */
public class ContattoTest {
    Contatto contatto;
    
    public ContattoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    /**
     * @brief Utilizzo del metodo BeforeEach per instanziare un contatto di base.
     * 
     * All'interno di questa funzione si definisce che, prima di ogni test, vengano instanziati all'interno del
     * contatto standard, dei valori che saranno poi utilizzati nei test.
     * 
     */
    @BeforeEach
    public void setUp() {
        System.out.println("Set up contatti standard");
        String[] numTel = {"3315783174","3357230290","3929261904"};
        String[] email = {"g.contursi@gmail.com","gio.contursi2003@gmail.com","giovanni.contursi03@gmail.com"};
        contatto = new Contatto("Contursi","Giovanni",numTel,email);
    }
    
    /**
     * @brief Utilizzo del metodo AfterEach per un print.
     * 
     * All'interno di questa funzione si definisce che, dopo di ogni test, venga printato lo stato del processo.
     * 
     */
    @AfterEach
    public void tearDown() {
        System.out.println("Clean standard var");
        
    }

    /**
     * @brief Questa funzione testa il metodo getNome() della classe contatto.
     * 
     * Questa funzione controlla se il nome inserito nel contatto instanziato nel BeforeEach è uguale
     * ad una stringa tramite il metodo assertEquals().
     * 
     * @see getNome(), Contatto.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNomeTest");
        assertEquals("Giovanni",contatto.getNome());
    }

    /**
     * @brief Questa funzione testa il metodo getCognome() della classe contatto.
     * 
     * Questa funzione controlla se il cognome inserito nel contatto instanziato nel BeforeEach è uguale
     * ad una stringa tramite il metodo assertEquals().
     * 
     * @see getCognome.
     */
    @Test
    public void testGetCognome() {
        System.out.println("getCognomeTest");
        assertEquals("Contursi",contatto.getCognome());
    }

    /**
     * @brief Questa funzione testa il metodo getNumeroTelefono() della classe contatto.
     * 
     * Questa funzione controlla se il numero di telefono instanziato nel contatto standard è uguale ad un array
     * contenente anch'esso dei numeri di telefono tramite il metodo assertArrayEquals().
     * 
     * @see getNumeroTelefono().
     */
    @Test
    public void testGetNumeroTelefono() {
        System.out.println("getNumeroTelefonoTest");
        String[] array={"3315783174","3357230290","3929261904"};
        assertArrayEquals(array,contatto.getNumeroTelefono());
    }

    /**
     * @brief Questa funzione testa il metodo getEmail() della classe contatto.
     * 
     * Questa funzione controlla se la e-mail instanziata nel contatto standard è uguale ad un array
     * contenente anch'esso delle e-mail tramite il metodo assertArrayEquals().
     * 
     * @see getEmail().
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmailTest");
        String[] array = {"g.contursi@gmail.com","gio.contursi2003@gmail.com","giovanni.contursi03@gmail.com"};
        assertArrayEquals(array,contatto.getEmail());
    }

    /**
     * @brief Questa funzione testa il metodo setNome() della classe contatto.
     * 
     * All'interno di questa funzione viene preso il contatto standard e tramite il metodo
     * setNome() ne viene cambiato il nome.Succesivamente controlla tramite la funzione assertEquals() se
     * il cambiamento è avvenuto con successo confrontandolo con una stringa contenente anch'essa
     * lo stesso nome.
     * 
     * @see setNome().
     */
    @Test
    public void testSetNome() {
        System.out.println("setNomeTest");
        contatto.setNome("nicolas");
        assertEquals("nicolas",contatto.getNome());
        
    }

    /**
     * @brief Questa funzione testa il metodo setCognome() della classe contatto.
     * 
     * All'interno di questa funzione viene preso il contatto standard e tramite il metodo
     * setCognome() ne viene cambiato il cognome. Succesivamente controlla tramite la funzione assertEquals() se
     * il cambiamento è avvenuto con successo confrontandolo con una stringa contenente anch'essa
     * lo stesso cognome.
     * 
     * @see setCognome().
     */
    @Test
    public void testSetCongome() {
        System.out.println("setCognomeTest");
        contatto.setCognome("de stefano");
        assertEquals("de stefano",contatto.getCognome());
    }

    /**
     * @brief Questa funzione testa il metodo setNumeroTelefono() della classe contatto.
     * 
     * All'interno di questa funzione viene preso il contatto standard e tramite il metodo
     * setNumeroTelefono() vengono cambiati tutti e 3 i numeri di telefono. Succesivamente controlla tramite 
     * la funzione assertArrayEquals() se il cambiamento è avvenuto con successo confrontandolo con un array 
     * contenente anch'esso gli stessi numeri di telefono.
     * 
     * @see setNumeroTelefono().
     */
    @Test
    public void testSetNumeroTelefono() {
        System.out.println("setNumeroTelefonoTest");
        contatto.setNumeroTelefono("nuovo tel1", 0);
        contatto.setNumeroTelefono("nuovo tel2", 1);
        contatto.setNumeroTelefono("nuovo tel3", 2);
        String[] array={"nuovo tel1","nuovo tel2","nuovo tel3"};
        assertArrayEquals(array,contatto.getNumeroTelefono());
    }

    /**
     * @brief Questa funzione testa il metodo setEmail() della classe contatto.
     * 
     * All'interno di questa funzione viene preso il contatto standard e tramite il metodo
     * setEmail() vengono cambiate tutte e 3 le numeri e-mail. Succesivamente controlla tramite 
     * la funzione assertArrayEquals() se il cambiamento è avvenuto con successo confrontandolo con un array 
     * contenente anch'esso le stesse e-mail.
     * 
     * @see setEmail().
     */
    @Test
    public void testSetEmail() {
        System.out.println("setNumeroTelefonoTest");
        contatto.setEmail("nuova email1", 0);
        contatto.setEmail("nuova email2", 1);
        contatto.setEmail("nuova email3", 2);
        String[] array={"nuova email1","nuova email2","nuova email3"};
        assertArrayEquals(array,contatto.getEmail());
    }

    /**
     * @brief Questa funzione testa il metodo toString() della classe contatto.
     * 
     * Questa funzione controlla se l'output della funzione toString() sul contatto standard
     * è uguale ad una stringa contenente il nome e il cognome del contatto standard.
     * 
     * @see toString().
     */
    @Test
    public void testToString() {
        System.out.println("toStringTest");
        assertEquals("Contursi Giovanni",contatto.toString());
    }
    
}