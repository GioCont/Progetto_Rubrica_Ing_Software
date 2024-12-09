/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package progetto_ing_software;

/**
 *
 * @author Giovanni
 * 
 * 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class RubricaGUI {

    /**
     * @param args the command line arguments
     */
     //Inizializzazione GUI
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    JTextField nomeField = new JTextField();
    JTextField cognomeField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField telefonoField = new JTextField();
    JTextField ricercaField = new JTextField();

    //Inizializzazione lista contatti
    private List<Contatto> contatti;

    //Costruttore
    public RubricaGUI()
    {
        contatti = new ArrayList<>();
        initialize();
        caricaContattiDaFile();
    }

    //Creazione della GUI
    private void initialize() {
        frame = new JFrame("Rubrica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 600, 400);
        frame.getContentPane().setLayout(new BorderLayout());

        //Modello della tabella per visualizzare i contatti
        tableModel = new DefaultTableModel(new Object[]{"Nome", "Cognome", "Telefono1","Telefono2","Telefono3", "Email1","Email2","Email3"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        //Pannello per i campi di input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(nomeField);

        inputPanel.add(new JLabel("Cognome:"));
        inputPanel.add(cognomeField);

        inputPanel.add(new JLabel("Telefono:"));
        inputPanel.add(telefonoField);

        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(ricercaField);

        //Aggiungi il pannello nella parte inferiore della finestra
        frame.getContentPane().add(inputPanel, BorderLayout.SOUTH);

        //Pannello per i pulsanti
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Pulsante "Aggiungi Contatto"
        JButton btnAggiungi = new JButton("Aggiungi Contatto");
        btnAggiungi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aggiungiContatto();
            }
        });
        buttonPanel.add(btnAggiungi);

        // Pulsante "Modifica Contatto"
        JButton btnModifica = new JButton("Modifica Contatto");
        btnModifica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificaContatto();
            }
        });
        buttonPanel.add(btnModifica);
        
        // Pulsante "ricerca Contatto"
        JButton btnRicerca = new JButton("ricerca Contatto");
        btnRicerca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ricercaContatto();
            }
        });
        buttonPanel.add(btnRicerca);

        // Pulsante "Elimina Contatto"
        JButton btnElimina = new JButton("Elimina Contatto");
        btnElimina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminaContatto();
            }
        });
        buttonPanel.add(btnElimina);

        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    // Metodo per l'aggiunta di un contatto
    private void aggiungiContatto() {
        String nome = nomeField.getText();
        String cognome = cognomeField.getText();
        String telefono = telefonoField.getText();
        String email = emailField.getText();

        if (!(nome.isEmpty() && cognome.isEmpty())) {
            Contatto nuovoContatto = new Contatto(nome, cognome, telefono, email);
            contatti.add(nuovoContatto);
            contatti.sort(new ContattoComparator());
            while(tableModel.getRowCount()>0){
                tableModel.removeRow(0);
            }
            for(Contatto cont:contatti){
                nome=cont.getNome();
                cognome=cont.getCognome();
                telefono=cont.getNumeroTelefono(0);
                email=cont.getEmail(0);
            tableModel.addRow(new Object[]{nome, cognome, telefono, email});
            
            }
            salvaContattiSuFile(); // Salva i contatti dopo aver aggiunto uno nuovo
            clearFields();
        } else {
            JOptionPane.showMessageDialog(frame, "Inserisci nome e cognome.");
        }
    }
    // Metodo per modificare un contatto selezionato
    private void modificaContatto() {
        
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            Contatto contatto = contatti.get(selectedRow);
            String nome = nomeField.getText();
            String cognome = cognomeField.getText();
            String telefono = telefonoField.getText();
            String email = emailField.getText();
            if(!nome.isEmpty())
            {
                contatto.setNome(nome);
            }
            if(!cognome.isEmpty())
            {
                contatto.setCongome(cognome);
            }
            if(!telefono.isEmpty())
            {
                contatto.setNumeroTelefono(telefono,0);
            }
            if(!email.isEmpty())
            {
                contatto.setEmail(email,0);
            }

            tableModel.setValueAt(contatto.getNome(), selectedRow, 0);
            tableModel.setValueAt(contatto.getCognome(), selectedRow, 1);
            tableModel.setValueAt(contatto.getNumeroTelefono(0), selectedRow, 2);
            tableModel.setValueAt(contatto.getEmail(0), selectedRow, 3);

            salvaContattiSuFile(); // Salva i contatti dopo averli modificati
            clearFields();
        } else {
            JOptionPane.showMessageDialog(frame, "Seleziona un contatto da modificare.");
        }
    }

    // Metodo per eliminare un contatto selezionato
    private void eliminaContatto() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            contatti.remove(selectedRow);
            tableModel.removeRow(selectedRow);
            salvaContattiSuFile(); // Salva i contatti dopo aver eliminato uno
            clearFields();
        } else {
            JOptionPane.showMessageDialog(frame, "Seleziona un contatto da eliminare.");
        }
    }
    
    private void ricercaContatto(){
        
    }

    //Salvataggio del File Rubrica
    private void salvaContattiSuFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("rubrica.csv"))) {
            for (Contatto contatto : contatti) {
                writer.write(contatto.getNome() + "," +
                        contatto.getCognome() + "," +
                        contatto.getNumeroTelefono(0) + "," +
                        contatto.getEmail(0));
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Errore nel salvataggio dei dati: " + e.getMessage());
        }
    }

    //Caricamento del File Rubrica
    private void caricaContattiDaFile() {
        File file = new File("rubrica.csv");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] dati = line.split(",");
                    if (dati.length == 4)
                    {
                        Contatto contatto = new Contatto(dati[0], dati[1], dati[2], dati[3]);
                        contatti.add(contatto);
                        tableModel.addRow(new Object[]{contatto.getNome(), contatto.getCognome(), contatto.getNumeroTelefono(0), contatto.getEmail(0)});
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Errore nel caricamento dei dati: " + e.getMessage());
            }
        }
    }

    //Metodi per validare il corretto inserimento dei dati
    private boolean isTelefonoValido(String telefono) {
        // Verifica che il numero contenga solo cifre e abbia almeno 10 caratteri
        return telefono.matches("\\d{10,}");
    }

    private boolean isEmailValida(String email) {
        // Regex per validare l'email
        return email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }

    private boolean validazioneDati(String nome, String cognome, String telefono, String email) {
        if (nome.isEmpty() || cognome.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Nome e cognome sono obbligatori.");
            return false;
        }
        if (!isTelefonoValido(telefono)) {
            JOptionPane.showMessageDialog(frame, "Il numero di telefono non è valido (deve contenere solo numeri e almeno 10 caratteri).");
            return false;
        }
        if (!isEmailValida(email)) {
            JOptionPane.showMessageDialog(frame, "L'indirizzo email non è valido.");
            return false;
        }
        return true;
    }

    // Pulisce i campi di input
    private void clearFields()
    {
        nomeField.setText("");
        cognomeField.setText("");
        telefonoField.setText("");
        emailField.setText("");
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RubricaGUI();
            }
        });
    }

}

    
