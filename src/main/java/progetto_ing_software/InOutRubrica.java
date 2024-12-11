/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto_ing_software;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * @file InOutRubrica.java
 * @brief questo file implementa i metodi che consentono il lavataggio e il caricamento della rubrica
 * @version 1.0
 * @author gruppo
 */
public class InOutRubrica {
    private static final String FILE_NAME = "rubrica.dat";
    
     /**
     * @brief metodo per salvare la rubrica su un file 
     * @post verrà sovrascritto il file "rubrica.dat"
     */
    public void salvaRubrica(List<Contatto> cont){
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(cont);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @brief metodo che consente di caricare la rubrica da file
     * @post il programma visualizzera la rubrica caricata
     */
    public List<Contatto> caricaRubrica(List<Contatto> cont){
     File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                cont = (List<Contatto>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return cont;
        
    }
}
