/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entità;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @file Contatto.java
 * @brief questo file implementa tutti i metodi della classe Contatto
 *
 * @version 1.0
 * @author Gruppo 23
 * @date 12/12/2024
 */
public class Contatto implements Serializable {
    private String nome;
    private String cognome;
    private String [] numeroTelefono;
    private String []email;
    /**
     * @brief costruttore della classe Contatto
     * @param[in] nome :nome del contatto
     * @param[in] cognome :cognome del contatto
     * @param[in] numeroTelefono :primo numero di telefono del contatto
     * @param[in] email :prima email del contatto
     */
    
    public Contatto(String cognome,String nome,String[] numeroTelefono,String[] email){
        this.nome=nome;
        this.cognome=cognome;
        this.numeroTelefono=new String [3];
        this.numeroTelefono=numeroTelefono;
        this.email=new String[3];
        this.email=email;
        
    }
    
    /**
     * @brief getNome, restituisce il nome del contatto
     * @return nome : il nome del contatto
     */
    
    public String getNome(){
        return this.nome;
    }
    
    /**
     * @brief getCognome, restituisce il cognome del contatto
     * @return cognome : il cognome del contatto
     */
    
    public String getCognome(){
        return this.cognome;
    }
    
    /**
     * @brief getNumeroTelefono, restituisce una stringa contenente tutti i numero di telefono
     * @return numeroTelefono : stringa contente tutti i numero di telefono
     */
    
    public String[] getNumeroTelefono(){
        return this.numeroTelefono;
    }
    
    /**
     * @brief getEmail, restituisce una stringa contenente tutte le email
     * @return email : stringa di email
     */
    
    public String[] getEmail(){
        return this.email;
    }
    
    /**
     * @brief setNome consente di settare il nome del contatto
     * @param[in] nome: nuovo nome da dare al contatto
     */
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    /**
     * @brief setCognome, consente di impostare il cognome del contatto
     * @param[in] cognome: nuovo cognome da dare al contatto
     */
    
    public void setCognome(String cognome){
        this.cognome=cognome;
    }
    
    /**
     * @brief setNumeroTelefono, consente di impostare un numero di telefono di indice passato per parametro in una specifica posizione dell'array
     * @param[in] numeroTelefono : nuovo numero di telefono da inserire
     * @param[in] index : indice del numero di telefono da settare
     */
    
    public void setNumeroTelefono(String numeroTelefono, int index){
        this.numeroTelefono[index]=numeroTelefono;
    }
    /**
     * @brief setEmail, consente di impostare una email di indice passato per parametro in una specifica posizione dell'array
     * @param[in] email : nuova email
     * @param[in] index : indice dell'email da settare
     */
    
    public void setEmail(String email,int index){
        this.email[index]=email;
    }
    
    /**
     * @brief toString, restituisce una stringa che rappresenta il contatto
     * @return restituisce una stinga con cognome e nome del contatto
     * Questo metodo restituisce una stringa formata dal cognome e dal nome, se il contatto ha cognome vuoto viene restituito solo il nome
     */
    @Override
    public String toString(){
        if (cognome.isEmpty())
            return nome;
        return cognome +" "+ nome;
    }
}
