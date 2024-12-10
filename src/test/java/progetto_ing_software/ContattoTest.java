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
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getNome method, of class Contatto.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNomeTest");
        String[] numTel = {"tel1","tel2","tel3"};
        String[] email = {"email1","email2","email3"};
        Contatto c= new Contatto("giovanni","contursi",numTel,email);
        assertEquals("giovanni",c.getNome());
    }

    /**
     * Test of getCognome method, of class Contatto.
     */
    @Test
    public void testGetCognome() {
        System.out.println("getCognomeTest");
        String[] numTel = {"tel1","tel2","tel3"};
        String[] email = {"email1","email2","email3"};
        Contatto c= new Contatto("giovanni","contursi",numTel,email);
        assertEquals("contursi",c.getCognome());
    }

    /**
     * Test of getNumeroTelefono method, of class Contatto.
     */
    @Test
    public void testGetNumeroTelefono() {
        System.out.println("getNumeroTelefonoTest");
        String[] numTel = {"tel1","tel2","tel3"};
        String[] email = {"email1","email2","email3"};
        Contatto c= new Contatto("giovanni","contursi",numTel,email);
        String[] array={"tel1","tel2","tel3"};
        assertArrayEquals(array,c.getNumeroTelefono());
    }

    /**
     * Test of getEmail method, of class Contatto.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmailTest");
        String[] numTel = {"tel1","tel2","tel3"};
        String[] email = {"email1","email2","email3"};
        Contatto c= new Contatto("giovanni","contursi",numTel,email);
        String[] array={"email1","email2","email3"};
        assertArrayEquals(array,c.getEmail());
    }

    /**
     * Test of setNome method, of class Contatto.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNomeTest");
        String[] numTel = {"tel1","tel2","tel3"};
        String[] email = {"email1","email2","email3"};
        Contatto c= new Contatto("giovanni","contursi",numTel,email);
        c.setNome("nicolas");
        assertEquals("nicolas",c.getNome());
        
    }

    /**
     * Test of setCongome method, of class Contatto.
     */
    @Test
    public void testSetCongome() {
        System.out.println("setCognomeTest");
        String[] numTel = {"tel1","tel2","tel3"};
        String[] email = {"email1","email2","email3"};
        Contatto c= new Contatto("giovanni","contursi",numTel,email);
        c.setCongome("de stefano");
        assertEquals("de stefano",c.getCognome());
    }

    /**
     * Test of setNumeroTelefono method, of class Contatto.
     */
    @Test
    public void testSetNumeroTelefono() {
        System.out.println("setNumeroTelefonoTest");
        String[] numTel = {"tel1","tel2","tel3"};
        String[] email = {"email1","email2","email3"};
        Contatto c= new Contatto("giovanni","contursi",numTel,email);
        c.setNumeroTelefono("nuovo tel1", 0);
        c.setNumeroTelefono("nuovo tel2", 1);
        c.setNumeroTelefono("nuovo tel3", 2);
        String[] array={"nuovo tel1","nuovo tel2","nuovo tel3"};
        assertArrayEquals(array,c.getNumeroTelefono());
    }

    /**
     * Test of setEmail method, of class Contatto.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setNumeroTelefonoTest");
        String[] numTel = {"tel1","tel2","tel3"};
        String[] email = {"email1","email2","email3"};
        Contatto c= new Contatto("giovanni","contursi",numTel,email);
        c.setEmail("nuova email1", 0);
        c.setEmail("nuova email2", 1);
        c.setEmail("nuova email3", 2);
        String[] array={"nuova email1","nuova email2","nuova email3"};
        assertArrayEquals(array,c.getEmail());
    }

    /**
     * Test of toString method, of class Contatto.
     */
    @Test
    public void testToString() {
        System.out.println("toStringTest");
        String[] numTel = {"tel1","tel2","tel3"};
        String[] email = {"email1","email2","email3"};
        Contatto c= new Contatto("giovanni","contursi",numTel,email);
        assertEquals("giovanni contursi",c.toString());
    }
    
}
