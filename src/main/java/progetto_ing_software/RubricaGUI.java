/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package progetto_ing_software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class RubricaGUI
{
    private JFrame frame;
    private JList<Contatto> listaContatti;
    private DefaultListModel<Contatto> listModel;
    private JTextField nomeField, cognomeField, telefono1Field, telefono2Field, telefono3Field;
    private JTextField email1Field, email2Field, email3Field;
    private Rubrica rubrica;

    public RubricaGUI()
    {
        rubrica = new Rubrica();
        frame = new JFrame("Rubrica Telefonica");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inizializzazione dei Componenti
        listModel = new DefaultListModel<>();
        listaContatti = new JList<>(listModel);
        listaContatti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaContatti.addListSelectionListener(e -> mostraDettagliContatto());

        JScrollPane listScrollPane = new JScrollPane(listaContatti);
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(8, 2));

        // Campi di Input
        nomeField = new JTextField();
        cognomeField = new JTextField();
        telefono1Field = new JTextField();
        telefono2Field = new JTextField();
        telefono3Field = new JTextField();
        email1Field = new JTextField();
        email2Field = new JTextField();
        email3Field = new JTextField();

        rightPanel.add(new JLabel("Nome"));
        rightPanel.add(nomeField);
        rightPanel.add(new JLabel("Cognome"));
        rightPanel.add(cognomeField);
        rightPanel.add(new JLabel("Telefono 1"));
        rightPanel.add(telefono1Field);
        rightPanel.add(new JLabel("Telefono 2"));
        rightPanel.add(telefono2Field);
        rightPanel.add(new JLabel("Telefono 3"));
        rightPanel.add(telefono3Field);
        rightPanel.add(new JLabel("Email 1"));
        rightPanel.add(email1Field);
        rightPanel.add(new JLabel("Email 2"));
        rightPanel.add(email2Field);
        rightPanel.add(new JLabel("Email 3"));
        rightPanel.add(email3Field);

        //Inizializzazione Pulsanti
        JButton aggiungiButton = new JButton("Aggiungi");
        JButton modificaButton = new JButton("Modifica");
        JButton eliminaButton = new JButton("Elimina");
        JButton caricaButton = new JButton("Carica");
        JButton salvaButton = new JButton("Salva");

        //Funzione dei Pulsanti
        aggiungiButton.addActionListener(e -> aggiungiContatto());
        modificaButton.addActionListener(e -> modificaContatto());
        eliminaButton.addActionListener(e -> eliminaContatto());
        caricaButton.addActionListener(e-> caricaFileRubrica());
        salvaButton.addActionListener(e -> salvaRubrica());

        //Aggiunta Pulsanti al buttonPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(aggiungiButton);
        buttonPanel.add(modificaButton);
        buttonPanel.add(eliminaButton);
        buttonPanel.add(caricaButton);
        buttonPanel.add(salvaButton);

        //Aggiunta dei Frame al Pannello Principale
        frame.add(listScrollPane, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Carica contatti dal file CSV
        caricaRubrica();

        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    private void mostraDettagliContatto()
    {
        Contatto contatto = listaContatti.getSelectedValue();
        if (contatto != null) {
            nomeField.setText(contatto.getNome());
            cognomeField.setText(contatto.getCognome());
            telefono1Field.setText(contatto.getNumeroTelefono()[0]);
            telefono2Field.setText(contatto.getNumeroTelefono()[1]);
            telefono3Field.setText(contatto.getNumeroTelefono()[2]);
            email1Field.setText(contatto.getEmail()[0]);
            email2Field.setText(contatto.getEmail()[1]);
            email3Field.setText(contatto.getEmail()[2]);
        }
    }

    private void aggiornaListaContatti()
    {
        listModel.clear();
        for (Contatto contatto : rubrica.getContatti())
        {
            listModel.addElement(contatto);
        }
    }

    private void aggiungiContatto()
    {
        String[] numeri = {telefono1Field.getText(), telefono2Field.getText(), telefono3Field.getText()};
        String[] emails = {email1Field.getText(), email2Field.getText(), email3Field.getText()};
        Contatto contatto = new Contatto(nomeField.getText(), cognomeField.getText(), numeri, emails);
        rubrica.addContatto(contatto);
        aggiornaListaContatti();
        salvaRubrica();
        clearTextFields();
    }

    private void modificaContatto()
    {
        int selectedIndex = listaContatti.getSelectedIndex();
        if (selectedIndex != -1) {
            String[] numeri = {telefono1Field.getText(), telefono2Field.getText(), telefono3Field.getText()};
            String[] emails = {email1Field.getText(), email2Field.getText(), email3Field.getText()};
            Contatto contatto = new Contatto(nomeField.getText(), cognomeField.getText(), numeri, emails);
            rubrica.modificaContatto(selectedIndex, contatto);
            aggiornaListaContatti();
            salvaRubrica();
            clearTextFields();
        }
    }

    private void eliminaContatto()
    {
        int selectedIndex = listaContatti.getSelectedIndex();
        if (selectedIndex != -1)
        {
            Contatto contatto = listaContatti.getSelectedValue();
            rubrica.removeContatto(contatto);
            aggiornaListaContatti();
            salvaRubrica();
            clearTextFields();
        }
    }

    //Primo caricamento del file di Rubrica
    private void caricaRubrica()
    {
        try
        {
            rubrica.caricaRubrica();
            aggiornaListaContatti();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //Salva il file della Rubrica
    private void salvaRubrica()
    {
        //Da modificare, bisogna permettere di salvare anche il file appena aperto tramite caricamento
        rubrica.salvaRubrica();
    }

    private void caricaFileRubrica()
    {
        //Da completare
    }

    private void clearTextFields()
    {
        nomeField.setText("");
        cognomeField.setText("");
        telefono1Field.setText("");
        telefono2Field.setText("");
        telefono3Field.setText("");
        email1Field.setText("");
        email2Field.setText("");
        email3Field.setText("");
    }

    public static void main(String[] args) {
        new RubricaGUI();
    }
}
