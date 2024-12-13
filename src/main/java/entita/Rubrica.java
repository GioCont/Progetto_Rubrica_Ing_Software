/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entita;

import entita.Contatto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import utilita.ContattoComparator;
import utilita.InOutRubrica;

/**
 * @file Rubrica.java
 * @brief Questo file implemetta tutti i metodi di rubrica.
 * 
 * All'interno di questa classe viene definita la struttura e i metodi di una rubrica,
 * la quale è una lista di contatti con vari metodi per essere modificata.
 * 
 * @version 1.0
 * @author Gruppo 23
 * @date 12/12/2024
 */
public class Rubrica extends InOutRubrica {
    private List<Contatto> contatti;
    
    
    
    public Rubrica(){
        contatti=new ArrayList<Contatto>();
    }
    /**
     * @brief Metodo che restituisce la lista di tutti i contatti in ordine alfabetico.
     * 
     * Funzione che tramite il metodo sort() restituisce la rubrica in odirne alfabetico.
     * 
     * @return contatti : Restituisce la lista con tutti i contatti 
     */
    
    public List<Contatto> getContatti(){
        Sort();
        return contatti;
    }
    
    /**
     * @brief Metodo che consente l'aggiunta di un contatto alla rubrica.
     * 
     * Metodo void senza ritorno che permette l'iserimento di un contatto all'interno della rubrica.
     * 
     * @param[in] c : Contatto da inserire nella lista.
     */
    public void addContatto(Contatto c){
        contatti.add(c);
    }
    
    /**
     * @brief Metodo per rimuovere un contatto.
     * 
     * Questa funzione permette di rimuovere il contatto desiderato dalla rubrica.
     * 
     * @param[in] c : Contatto da rimuovere.
     */
    public void removeContatto(Contatto c){
        contatti.remove(c);
    }
    
    /**
     * @brief Metodo che consente la modifica di un contatto in un determinato indice.
     * 
     * Questo metodo permette di modificare un contatto già esistente all'interno della rubrica
     * selezionato tramite l'indice index ricevuto in ingresso, con un nuovo contatto anch'esso ricevuto in ingresso.
     * 
     * @param[in] index : Indice del contatto da modificare.
     * @param[in] contatto : Nuovo contatto con cui sostituire il vecchio.
     */
      public void modificaContatto(int index, Contatto contatto) {
        contatti.set(index, contatto);
    }
    
    /**
     * @brief Metodo per salvare la rubrica su un file.
     * @post verrà creato un file "rubrica.dat"
     */
    public void salvaRubrica(File namefile){
        super.salvaRubrica(this.getContatti(), namefile);
    }
    
    /**
     * @param filename
     * @brief metodo che consente di caricare la rubrica da file
     * @post il programma visualizzera la rubrica caricata
     */
    public void caricaRubrica(File filename){
      contatti=super.caricaRubrica(contatti,filename);
    }
    /**
     * @brief Metodo che consente la ricerca di un contatto all'interno della rubrica.
     * 
     * Questa funzione permette di cercare all'interno della rubrica un contatto, prendendo in ingresso una stringa
     * contenente il nome o il cognome del contatto desiderato. Il parametro in uscita è una lista dei contatto che
     * hanno avuto un riscontro con i criteri di ricerca inseriti. La rubrica non viene mai modificata.
     * 
     * @param[in] text : Stringa da ricercare tra i nomi e i cognomi dei contatti nella rubrica.
     * @return rif  : Lista di contatti contenente solo i contatti che hanno dato riscontro positivo nella ricerca.
     * @invariant La rubrica non viene modificata.
     */
    
    public List<Contatto> ricercaContatti(String text){
        List<Contatto> rif = new ArrayList();
        for (Contatto c : getContatti()){
            if(c.getCognome().contains(text) || c.getNome().contains(text))
                rif.add(c);
        }
        return rif;
    }
    
    public void setContatti(List<Contatto> contatti)
    {
        this.contatti=contatti;
    }
    
    /**
     * @brief metodo che ordina la lista secondo il comparatore implementato nella classe Contatto Comparator
     * 
     * See also: ContattoComparator
     * 
     * Questa funzione, tramite il metodo compare implementato nela classe ContattoComparator, ordina 
     * alfabeticamente la rubrica per nome e cognome.
     * 
     * @invariant le informazioni dei contatti non vengono modificate
     * @see compare()
     */
    private void Sort(){
        contatti.sort(new ContattoComparator());
    }
    
    
}
