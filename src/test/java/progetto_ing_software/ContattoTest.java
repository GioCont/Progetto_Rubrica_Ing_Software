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
 *
 * @author cerro
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
    
    @BeforeEach
    public void setUp() {
        System.out.println("Set up contatti standard");
        String[] numTel = {"3315783174","3357230290","3929261904"};
        String[] email = {"g.contursi@gmail.com","gio.contursi2003@gmail.com","giovanni.contursi03@gmail.com"};
        contatto = new Contatto("Giovanni","Contursi",numTel,email);
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("Clean standard var");
        
    }

    /**
     * Test of getNome method, of class Contatto.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNomeTest");
        assertEquals("Giovanni",contatto.getNome());
    }

    /**
     * Test of getCognome method, of class Contatto.
     */
    @Test
    public void testGetCognome() {
        System.out.println("getCognomeTest");
        assertEquals("Contursi",contatto.getCognome());
    }

    /**
     * Test of getNumeroTelefono method, of class Contatto.
     */
    @Test
    public void testGetNumeroTelefono() {
        System.out.println("getNumeroTelefonoTest");
        String[] array={"3315783174","3357230290","3929261904"};
        assertArrayEquals(array,contatto.getNumeroTelefono());
    }

    /**
     * Test of getEmail method, of class Contatto.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmailTest");
        String[] array = {"g.contursi@gmail.com","gio.contursi2003@gmail.com","giovanni.contursi03@gmail.com"};
        assertArrayEquals(array,contatto.getEmail());
    }

    /**
     * Test of setNome method, of class Contatto.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNomeTest");
        contatto.setNome("nicolas");
        assertEquals("nicolas",contatto.getNome());
        
    }

    /**
     * Test of setCongome method, of class Contatto.
     */
    @Test
    public void testSetCongome() {
        System.out.println("setCognomeTest");
        contatto.setCognome("de stefano");
        assertEquals("de stefano",contatto.getCognome());
    }

    /**
     * Test of setNumeroTelefono method, of class Contatto.
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
     * Test of setEmail method, of class Contatto.
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
     * Test of toString method, of class Contatto.
     */
    @Test
    public void testToString() {
        System.out.println("toStringTest");
        assertEquals("Giovanni Contursi",contatto.toString());
    }
    
}
