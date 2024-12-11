/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author gruppo
 */
public class Rubrica extends InOutRubrica {
    private List<Contatto> contatti;
    
    
    
    public Rubrica(){
        contatti=new ArrayList<Contatto>();
    }
    /**
     * @brief metodo che restiteusce la lista sempre in ordine
     * @return contatti :ritorna la lista con tutti i contatti 
     */
    
    public List<Contatto> getContatti(){
        Sort();
        return contatti;
    }
    
    /**
     * @brief metodo che consente l'aggiunta di un contatto alla rubrica
     * @param[in] c :contatto da inserire nella lista
     */
    public void addContatto(Contatto c){
        contatti.add(c);
    }
    
    /**
     * @brief metodo per rimuovere un contatto
     * @param[in] c :contatto da rimuovere
     */
    public void removeContatto(Contatto c){
        contatti.remove(c);
    }
    
    /**
     * @brief metodo che consente la modifica di un contatto in un determinato indice
     * @param[in] index :indice del contatto da modificare
     * @param[in] contatto :nuovo contatto con cui sostituire il vechio
     */
      public void modificaContatto(int index, Contatto contatto) {
        contatti.set(index, contatto);
    }
    
    /**
     * @brief metodo per salvare la rubrica su un file 
     * @post verrà creato un file "rubrica.dat
     */
    public void salvaRubrica(){
       super.salvaRubrica(contatti);
    }
    
    /**
     * @brief metodo che consente di caricare la rubrica da file
     * @post il programma visualizzera la rubrica caricata
     */
    public void caricaRubrica(){
      contatti=super.caricaRubrica(contatti);
    }
    /**
     * @brief metodo che consente la ricerca di una stringa all'interno del nome o cognome dei contatti 
     * @param[in] text :stringa da ricercare nei nomi e cognomi dei contatti
     * @return rif  :lista di contatti contenente solo i contatti che hanno dato riscontro positivo sulla ricerca
     * @invariant la rubrica non viene modificata
     */
    
    public List<Contatto> ricercaContatti(String text){
        List<Contatto> rif = new ArrayList();
        for (Contatto c : getContatti()){
            if(c.getCognome().contains(text) || c.getNome().contains(text))
                rif.add(c);
        }
        return rif;
    }
    
    /**
     * @brief metodo che ordina la lista secondo il comparatore implementato nella classe Contatto Comparator
     * @invariant le informazioni dei contatti non vengono modificate
     */
    private void Sort(){
        contatti.sort(new ContattoComparator());
    }
    
    
}
