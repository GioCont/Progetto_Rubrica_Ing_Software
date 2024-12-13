/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi_Funzionali;

import Entità.Contatto;
import java.util.Comparator;

/**
 * @file ContattoComparator.java
 * @brief Questo file implementa il metodo compare per i contatti.
 * 
 * All'interno di questa classe viene implementato il metodo compare, utilizzato per l'ordinamento
 * in ordine alfabetico dei contatti contenuti nella rubrica.
 * 
 * @version 1.0
 * @author Gruppo 23
 * @date 12/12/2024
 */
public class ContattoComparator implements Comparator<Contatto> {

    /**
     * @brief Ovveride del metodo compare.
     * 
     * Questo metodo confronta i cognomi di due contatti tramite il metodo compare(). Nel caso in 
     * cui uno dei due oggetti non ha il cognome viene eseguito un ulteriore confronto tra il nome 
     * del contatto senza cognome e il cognome dell'altro contatto, sempre tramite il metodo compare().
     * Se i due cognomi sono uguali si esegue un confronto tra i due nomi dei contatti sempre tramite compare().
     * 
     * 
     * @param[in] o1: primo contatto
     * @param[in] o2: secondo contatto
     * @return Restituisce il valore della compareTo tra due stringhe.
     */
    
    @Override
    public int compare(Contatto o1, Contatto o2) {
        String rif1=o1.getCognome();
        String rif2=o2.getCognome();
        if(o1.getCognome().isEmpty())
            rif1=o1.getNome();
        if(o2.getCognome().isEmpty())
            rif2=o2.getNome();
        if(o1.getCognome().equalsIgnoreCase(o2.getCognome())){
            rif1=o1.getNome();
            rif2=o2.getNome();
        }
        return rif1.compareTo(rif2);
    }
    
    
}
