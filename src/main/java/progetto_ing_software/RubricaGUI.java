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

    //Costruttore
    public RubricaGUI()
    {
        rubrica = new Rubrica();
        initGUI();
    }

    //Funzione dell'interfaccia Grafica
    private void initGUI()
    {
        //Creazione del Frame Principale
        JFrame frame = new JFrame("Rubrica Telefonica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        //Aggiunta della lista dei contatti
        DefaultListModel<Contatto> contattiModel = new DefaultListModel<>();
        JList<Contatto> listaContatti = new JList<>(contattiModel);

        //TextField di Ricerca
        JTextField ricercaField = new JTextField();

        //Pulsanti Agiunggi Contatto e Carica File
        JButton aggiungiButton = new JButton("Aggiungi Contatto");
        JButton caricaButton = new JButton("Carica");
        JButton eliminaButton = new JButton("elimina Contatto");
        JButton salvaButton = new JButton("salva");

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(ricercaField, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(aggiungiButton);
        buttonPanel.add(caricaButton);
        buttonPanel.add(eliminaButton);
        buttonPanel.add(salvaButton);
        topPanel.add(buttonPanel, BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(listaContatti), BorderLayout.CENTER);
        
        salvaButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser(); 
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                nomefile = fileChooser.getSelectedFile();
                rubrica.salvaRubrica(nomefile);
                
            }
        
        });
        
        eliminaButton.addActionListener(e-> {
            Contatto contattoSelezionato = listaContatti.getSelectedValue();
            rubrica.removeContatto(contattoSelezionato);
            contattiModel.clear();
                for (Contatto contatto : rubrica.getContatti()){
                    contattiModel.addElement(contatto);
                }
            
        });

        aggiungiButton.addActionListener(e -> {
            Contatto nuovoContatto = creaNuovoContatto();
            if (nuovoContatto != null) {
                rubrica.addContatto(nuovoContatto);
                contattiModel.clear();
                for(Contatto c:rubrica.getContatti()){
                contattiModel.addElement(c);
                }
                
            }
        });

        caricaButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                nomefile = fileChooser.getSelectedFile();
                rubrica.caricaRubrica(nomefile);
                contattiModel.clear();
                for(Contatto c:rubrica.getContatti()){
                contattiModel.addElement(c);
                }
                
            }
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

    private Contatto creaNuovoContatto()
    {
        JTextField nomeField = new JTextField();
        JTextField cognomeField = new JTextField();
        JTextField numeroField1 = new JTextField();
        JTextField numeroField2 = new JTextField();
        JTextField numeroField3 = new JTextField();
        JTextField emailsField1 = new JTextField();
        JTextField emailsField2 = new JTextField();
        JTextField emailsField3 = new JTextField();

        JPanel panel = new JPanel(new GridLayout(8, 2));

        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);

        panel.add(new JLabel("Cognome:"));
        panel.add(cognomeField);

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


        int result = JOptionPane.showConfirmDialog(null, panel, "Nuovo Contatto", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String nome = nomeField.getText().trim();
            String cognome = cognomeField.getText().trim();
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

            return new Contatto(nome, cognome, numeri, emails);
        }
        return null;
    }

    private void mostraDettagliContatto(Contatto contatto, DefaultListModel<Contatto> model) throws IOException {
        JTextField nomeField = new JTextField(contatto.getNome());
        JTextField cognomeField = new JTextField(contatto.getCognome());
        JTextField numeroField1 = new JTextField(contatto.getNumeroTelefono()[0]);
        JTextField numeroField2 = new JTextField(contatto.getNumeroTelefono()[1]);
        JTextField numeroField3 = new JTextField(contatto.getNumeroTelefono()[2]);
        JTextField emailsField1 = new JTextField(contatto.getEmail()[0]);
        JTextField emailsField2 = new JTextField(contatto.getEmail()[1]);
        JTextField emailsField3 = new JTextField(contatto.getEmail()[2]);

        JPanel panel = new JPanel(new GridLayout(8, 2));
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);

        panel.add(new JLabel("Cognome:"));
        panel.add(cognomeField);

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
            model.removeElement(contatto);
            model.addElement(contatto);
        }
    }
    
    
}