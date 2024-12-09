/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto_ing_software;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @file Contatto.java
 * @brief questo file implemetta tutti i metodi di contatto
 * @version 1.0
 * @author gruppo
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
    
    public Contatto(String nome,String cognome,String[] numeroTelefono,String[] email){
        this.nome=nome;
        this.cognome=cognome;
        this.numeroTelefono=new String [3];
        this.numeroTelefono=numeroTelefono;
        this.email=new String[3];
        this.email=email;
        
    }
    
    /**
     * @brief restituisce il nome del contatto
     * @return nome :il nome del contatto
     */
    
    public String getNome(){
        return this.nome;
    }
    
    /**
     * @brief restituisce il cognome del contatto
     * @return cognome :il cognome del contatto
     */
    
    public String getCognome(){
        return this.cognome;
    }
    
    /**
     * @brief restituisce una stringa contenente tutti i numero di telefono
     * @return numeroTelefono : stringa contente tutti i numero di telefono
     */
    
    public String[] getNumeroTelefono(){
        return this.numeroTelefono;
    }
    
    /**
     * @brief restituisce una stringa contenente tutte le email
     * @return email : stringa di email
     */
    
    public String[] getEmail(){
        return this.email;
    }
    
    /**
     * @brief consente di settare il nome del contatto
     * @param[in] nome: nuovo nome da dare al contatto
     */
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    /**
     * @brief consente di settare il cognome del contatto
     * @param[in] cognome: nuovo cognome da dare al contatto
     */
    
    public void setCognome(String cognome){
        this.cognome=cognome;
    }
    
    /**
     * @brief connsente di settare un numero di telefono di indice passato per parametro
     * @param[in] numeroTelefono :nuovo numero di telefono
     * @param[in] index :indice del numero di telefono da settare
     */
    
    public void setNumeroTelefono(String numeroTelefono,int index){
        this.numeroTelefono[index]=numeroTelefono;
    }
    /**
     * @brief connsente di settare una email di indice passato per parametro
     * @param[in] email :nuova email
     * @param[in] index :indice del email da settare
     */
    
    public void setEmail(String email,int index){
        this.email[index]=email;
    }
    
    /**
     * @brief restituisce una stringa che rapresenta il contatto
     * @return restituisce una stinga con cognome e nome del contatto
     * questo metodo restituisce una stringa formata dal cognome e dal nome, se il contatto ha cognome vuoto restituira solo il nome
     */
    @Override
    public String toString(){
        if (cognome.isEmpty())
            return nome;
        return cognome +" "+ nome;
    }
}
