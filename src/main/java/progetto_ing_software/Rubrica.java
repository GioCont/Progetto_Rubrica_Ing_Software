/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progetto_ing_software;

/**
 *
 * @author Giovanni
 */
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
        return contatti;
    }
    
    public void addContatto(Contatto c){
        contatti.add(c);
    }
    
    public void removeContatto(Contatto c){
        contatti.remove(c);
    }
    
      public void modificaContatto(int index, Contatto contatto) {
        contatti.set(index, contatto);
    }
    
    //prototipo
    public void salvaRubrica(){
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(contatti);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //prototipo
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
    
    public List<Contatto> ricercaContatti(String text){
        List<Contatto> rif = new ArrayList();
        for (Contatto c : contatti){
            if(c.getCognome().contains(text) || c.getNome().contains(text))
                rif.add(c);
        }
        return rif;
    }
    
    public Contatto getContatto(int index){
        return contatti.get(index);
    }
    
    public void Sort(){
        contatti.sort(new ContattoComparator());
    }
    
    
}
