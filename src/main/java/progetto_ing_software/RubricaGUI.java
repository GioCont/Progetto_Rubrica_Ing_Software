/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto_ing_software;

/**
 *
 * @author cerro
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

class RubricaGUI
{
    private Rubrica rubrica;
    private File nomefile;
    private JFrame frame;
    private DefaultListModel<Contatto> contattiModel;
    private JList<Contatto> listaContatti;
    private JPanel panel;
    private JTextField cognomeField;
    private JTextField nomeField;
    private JTextField numeroField1;
    private JTextField numeroField2;
    private JTextField numeroField3;
    private JTextField emailsField1;
    private JTextField emailsField2;
    private JTextField emailsField3;

    //Costruttore
    public RubricaGUI()
    {
        rubrica = new Rubrica();
        panel = new JPanel(new GridLayout(8, 2));
        initrubricaGUI();
        initcontattoGUI();
    }

    //Funzione dell'interfaccia Grafica
    private void initrubricaGUI()
    {
        //Creazione del Frame Principale
        frame = new JFrame("Rubrica Telefonica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        //Aggiunta della lista dei contatti
        contattiModel = new DefaultListModel<>();
        listaContatti = new JList<>(contattiModel);

        //TextField di Ricerca
        JTextField ricercaField = new JTextField();

        //Pulsanti Agiunggi Contatto e Carica File
        JButton aggiungiButton = new JButton("Aggiungi Contatto");
        JButton eliminaButton = new JButton("Elimina Contatto");
        JButton caricaButton = new JButton("Carica");
        JButton salvaButton = new JButton("salva");

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(ricercaField, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(aggiungiButton);
        buttonPanel.add(eliminaButton);
        buttonPanel.add(caricaButton); 
        buttonPanel.add(salvaButton);
        topPanel.add(buttonPanel, BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(listaContatti), BorderLayout.CENTER);
        
        aggiungiButton.addActionListener(e -> {
            this.addContatto();
        });
        
        eliminaButton.addActionListener(e-> {
            this.removeContatto();
            
        });
        
        caricaButton.addActionListener(e -> {
            this.caricaRubrica();
        });
        
        salvaButton.addActionListener(e -> {
            this.salvaRubrica();
        });

        ricercaField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String query = ricercaField.getText();
                contattiModel.clear();
                for (Contatto contatto : rubrica.ricercaContatti(query)) {
                    contattiModel.addElement(contatto);
                }
            }
        });

        listaContatti.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Contatto contattoSelezionato = listaContatti.getSelectedValue();
                    if (contattoSelezionato != null) {
                        try {
                            mostraDettagliContatto(contattoSelezionato, contattiModel);
                        }
                        catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });

        frame.setVisible(true);
    }
    
    private void initcontattoGUI(){
        cognomeField = new JTextField();
        nomeField = new JTextField();
        numeroField1 = new JTextField();
        numeroField2 = new JTextField();
        numeroField3 = new JTextField();
        emailsField1 = new JTextField();
        emailsField2 = new JTextField();
        emailsField3 = new JTextField();
        
        panel.add(new JLabel("Cognome:"));
        panel.add(cognomeField);

        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);

        panel.add(new JLabel("Numero1:"));
        panel.add(numeroField1);

        panel.add(new JLabel("Email1:"));
        panel.add(emailsField1);

        panel.add(new JLabel("Numero2:"));
        panel.add(numeroField2);

        panel.add(new JLabel("Email2:"));
        panel.add(emailsField2);

        panel.add(new JLabel("Numero3:"));
        panel.add(numeroField3);

        panel.add(new JLabel("Email1:"));
        panel.add(emailsField3);
        
    }

    private Contatto creaNuovoContatto(){
        this.clearTextField();
        int result = JOptionPane.showConfirmDialog(null, panel, "Nuovo Contatto", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String cognome = cognomeField.getText().trim();
            String nome = nomeField.getText().trim();
            String[] numeri = {numeroField1.getText().trim(), numeroField2.getText().trim(), numeroField3.getText().trim()};
            String[] emails = {emailsField1.getText().trim(), emailsField2.getText().trim(), emailsField3.getText().trim()};

            if (nome.isEmpty() && cognome.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nome e cognome sono obbligatori.", "Errore", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            for (String numero : numeri) {
                if (!numero.isEmpty() && !numero.matches("\\+?\\d+")) {
                    JOptionPane.showMessageDialog(null, "Numero di telefono non valido: " + numero, "Errore", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            }

            for (String email : emails) {
                if (!email.isEmpty() && !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                    JOptionPane.showMessageDialog(null, "Email non valida: " + email, "Errore", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            }

            return new Contatto(cognome, nome, numeri, emails);
        }
        return null;
    }

    private void mostraDettagliContatto(Contatto contatto, DefaultListModel<Contatto> model) throws IOException {
        this.setTextField(contatto);
        int result = JOptionPane.showConfirmDialog(null, panel, "Modifica Contatto", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            contatto.setNome(nomeField.getText());
            contatto.setCognome(cognomeField.getText());
            contatto.setNumeroTelefono(numeroField1.getText(),0);
            contatto.setNumeroTelefono(numeroField2.getText(),1);
            contatto.setNumeroTelefono(numeroField3.getText(),2);
            contatto.setEmail(emailsField1.getText(),0);
            contatto.setEmail(emailsField2.getText(),1);
            contatto.setEmail(emailsField3.getText(),2);
            this.aggiornaRubrica();
        }
    }
    
    private void aggiornaRubrica(){
        contattiModel.clear();
        for(Contatto c:rubrica.getContatti()){
            contattiModel.addElement(c);
        }
    }
    
    private void setTextField(Contatto c){
        cognomeField.setText(c.getCognome());
        nomeField.setText(c.getNome());
        numeroField1.setText(c.getNumeroTelefono()[0]);
        numeroField2.setText(c.getNumeroTelefono()[1]);
        numeroField3.setText(c.getNumeroTelefono()[2]);
        emailsField1.setText(c.getEmail()[0]);
        emailsField2.setText(c.getEmail()[1]);
        emailsField3.setText(c.getEmail()[2]);
    }
    
    private void clearTextField(){
        cognomeField.setText("");
        nomeField.setText("");
        numeroField1.setText("");
        numeroField2.setText("");
        numeroField3.setText("");
        emailsField1.setText("");
        emailsField2.setText("");
        emailsField3.setText("");
    }
    
    private void addContatto(){
        Contatto Contatto = creaNuovoContatto();
            if (Contatto != null) {
                rubrica.addContatto(Contatto);
                this.aggiornaRubrica();
            }
    }
    
    private void removeContatto(){
        Contatto contattoSelezionato = listaContatti.getSelectedValue();
        rubrica.removeContatto(contattoSelezionato);
        this.aggiornaRubrica();
    }
    
    private void caricaRubrica(){
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            nomefile = fileChooser.getSelectedFile();
            rubrica.caricaRubrica(nomefile);
            this.aggiornaRubrica();
        }
    }
    
    private void salvaRubrica(){
        JFileChooser fileChooser = new JFileChooser(); 
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
           nomefile = fileChooser.getSelectedFile();
           rubrica.salvaRubrica(nomefile);        
        }
    }
    
    
}