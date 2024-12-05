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
import java.util.ArrayList;
import java.util.List;

/**
 * @file Rubrica.java
 * @brief questo file implemetta tutti i metodi di rubrica
 * @version 1.0
 * @author cerro
 */
public class Rubrica {
    private List<Contatto> contatti;
    private static final String FILE_NAME = "rubrica.dat";
    
    
    
    public Rubrica(){
        contatti=new ArrayList<Contatto>();
    }
    
    public List<Contatto> getContatti(){
        contatti.sort(new ContattoComparator());
        return contatti;
    }
    
    public void addContatto(Contatto c){
        contatti.add(c);
    }
    
    public void remuveContatto(Contatto c){
        contatti.remove(c);
    }
    
    public void salvaRubrica(){
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(contatti);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void caricaRubrica(){
     File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                contatti = (List<Contatto>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    
    }
    
    
    
}
