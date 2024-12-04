/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto_ing_software;

import java.util.Comparator;

/**
 * @file ContattoComparator
 * @brief questo file implementa la compare per il contatto
 * @version 1.0
 * @author cerro
 */
public class ContattoComparator implements Comparator<Contatto> {

    /**
     * @brief ovveride del metodo compare
     * @param[in] o1: primo contatto
     * @param[in] o2: secondo contatto
     * @return restituisce il valore della compareto tra due scringhe
     * 
     * questo metodo esegue la compare tra i congomi di due contatti. nel caso in 
     * cui uno dei due oggetti non ha il cognome viene eseguita la compare sul nome.
     * se i due cognomi sono uguali si esegue la compare tra i due nomi
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
