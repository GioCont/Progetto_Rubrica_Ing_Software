/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi_Funzionali;

import Entità.Rubrica;
import Entità.Contatto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @file InOutRubrica.java
 * @brief Questo file implementa la classe InOutRubrica che contiene i metodi che di salvataggio e di caricamento della rubrica
 *
 * @version 1.0
 * @date 12/12/2024
 * @author Gruppo 23
 */
public class InOutRubrica {
    
     /**
     * @brief Metodo per salvare la Rubrica su un file
     * @post Verrà creato/sovrascritto un file "rubrica.dat"
     */
    public void salvaRubrica(List<Contatto> list, File namefile){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(namefile))) {
            
            for(Contatto c : list) {

                writer.write(   c.getCognome() + '|' + 
                                c.getNome()+ '|'+
                                c.getNumeroTelefono()[0] + '|'+
                                c.getNumeroTelefono()[1]+ '|' + 
                                c.getNumeroTelefono()[2]+ '|' +
                                c.getEmail()[0]+ '|'+
                                c.getEmail()[1]+ '|'+
                                c.getEmail()[2]+'\n'
                                );
            }
        
        } catch (IOException ex) {
            Logger.getLogger(Rubrica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @brief Metodo che consente di caricare i dati della Rubrica da un file scelto dall'utente
     * @post Il programma visualizza la Rubrica caricata
     */
    public List<Contatto> caricaRubrica(List<Contatto> list,File filename){
        list.clear();
        try(Scanner i = new Scanner(new BufferedReader(new FileReader(filename)))) {
 
            Contatto c;

            i.useLocale(Locale.US);
            i.useDelimiter("\\||\\n"); // espressione regolare con OR logico dei caratteri pipe e fine linea
               
                
            while(i.hasNext()){
             
                String cognome=i.next();
                String nome=i.next();
                String [] telefono={i.next(),i.next(),i.next()};
                String [] email={i.next(),i.next(),i.next()};
             
                c = new Contatto(cognome,nome,telefono,email);

                list.add(c);

            }
            
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(Rubrica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
