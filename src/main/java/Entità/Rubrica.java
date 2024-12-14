/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entità;

import Entità.Contatto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import Classi_Funzionali.ContattoComparator;
import Classi_Funzionali.InOutRubrica;

/**
 * @file Rubrica.java
 * @brief Questo file implementa la classe Rubrica.
 *
 * Questa classe definisce una Rubrica, che è una lista di contatti, fornendo vari metodi
 * per gestirla, come aggiungere, rimuovere, modificare, cercare, salvare e ordinare in ordine crescente i contatti.
 *
 * 
 * @version 1.0
 * @author Gruppo 23
 * @date 12/12/2024
 */
public class Rubrica extends InOutRubrica {
    private List<Contatto> contatti;


    /**
     * @brief Costruttore della classe Rubrica.
     *
     * Inizializza una nuova rubrica vuota.
     */
    
    public Rubrica(){
        contatti=new ArrayList<Contatto>();
    }

    /**
     * @brief Restituisce la lista di tutti i contatti in ordine alfabetico.
     *
     * Ordina la rubrica in ordine alfabetico utilizzando un comparatore e restituisce
     * la lista dei contatti.
     *
     * @return contatti : Restituisce una lista di contatti ordinati alfabeticamente.
     */

    public List<Contatto> getContatti(){
        Sort();
        return contatti;
    }

    /**
     * @brief Aggiunge un contatto alla rubrica.
     *
     * Inserisce un nuovo contatto nella lista dei contatti.
     *
     * @param[in] c : Contatto da inserire nella lista.
     */
    public void addContatto(Contatto c){
        contatti.add(c);
    }

    /**
     * @brief Rimuove un contatto dalla rubrica.
     *
     * Elimina il contatto specificato dalla lista dei contatti.
     *
     * @param[in] c : Contatto da rimuovere.
     */
    public void removeContatto(Contatto c){
        contatti.remove(c);
    }
    
    /**
     * @brief Metodo che consente la modifica di un contatto in un determinato indice.
     * 
     * Questo metodo permette di modificare un contatto già esistente all'interno della rubrica,
     * selezionato tramite l'indice index ricevuto in ingresso,
     * con un nuovo contatto anch'esso ricevuto in ingresso.
     * 
     * @param[in] index : Indice del contatto da modificare.
     * @param[in] contatto : Nuovo contatto con cui sostituire il vecchio.
     */
      public void modificaContatto(int index, Contatto contatto) {
        contatti.set(index, contatto);
    }
    
    /**
     * @brief Metodo per salvare la rubrica su un file.
     *
     * Salva l'attuale lista di contatti su un file dopo che l'utente ha selezionato la directory di salvataggio.
     * @param[in] filename : file che è già stato definito tramite codice, "rubrica.dat".
     * @post verrà creato/sovrascritto un file "rubrica.dat" che contiene tutti i contatti della rubrica.
     */
    public void salvaRubrica(File namefile){
        super.salvaRubrica(this.getContatti(), namefile);
    }
    
    /**
     * @brief Metodo che consente di caricare la rubrica da file
     * @param filename : il file che viene scelto dall'utente tramite JFileChooser della GUI
     * @post La lista dei contatti viene aggiornata con la lista presente nel file
     */

    public void caricaRubrica(File filename){
      contatti=super.caricaRubrica(contatti,filename);
    }

    /**
     * @brief Metodo che consente la ricerca di un contatto all'interno della rubrica.
     * 
     * Questo metodo permette di cercare all'interno della rubrica un contatto, prendendo in ingresso una stringa
     * contenente il nome o il cognome del contatto desiderato. Il parametro in uscita è una lista di contatti che
     * hanno avuto un riscontro con i criteri di ricerca inseriti. La rubrica non viene alterata.
     * 
     * @param[in] text : Stringa da ricercare tra i nomi e i cognomi dei contatti nella rubrica.
     * @return rif : Lista di contatti contenente solo i contatti che hanno dato riscontro positivo nella ricerca.
     * @invariant La rubrica non viene modificata da questo metodo.
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
     * @brief Imposta una nuova lista di contatti
     *
     * Sostituisce l'attuale lista di contatti con una nuova
     *
     * @param[in] contatti : Nuova lista di contatti.
     */
    public void setContatti(List<Contatto> contatti)
    {
        this.contatti=contatti;
    }
    
    /**
     * @brief Metodo che ordina la lista secondo il comparatore implementato nella classe Contatto Comparator
     * 
     * See also: ContattoComparator
     * 
     * Questa funzione, tramite il metodo compare implementato nela classe ContattoComparator,
     * ordina alfabeticamente la rubrica per nome e cognome.
     * 
     * @invariant le informazioni dei contatti rimangono inalterate.
     * @see ContattoComparator#compare()
     */
    private void Sort(){
        contatti.sort(new ContattoComparator());
    }
    
    
}
