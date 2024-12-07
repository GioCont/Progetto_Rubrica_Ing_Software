package progetto_ing_software;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 *
 * @author cerro
 */
public class InterfacciaController implements Initializable{
    
    @FXML
    private TextField cognomeField;
    @FXML
    private TextField nomeField;
    @FXML
    private TextField telefono1Field;
    @FXML
    private TextField telefono2Field;
    @FXML
    private TextField telefono3Field;
    @FXML
    private TextField email1Field;
    @FXML
    private TextField email2Field;
    @FXML
    private TextField email3Field;
    @FXML
    private Button salvaButton;
    private TableView<Contatto> contattiTable;
    private TableColumn<Contatto, String> cognomeClm;
    private TableColumn<Contatto, String> nomeClm;
    
    private ObservableList<Contatto> contatti;
    private Rubrica rubrica;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        contatti = FXCollections.observableArrayList();
        
        cognomeClm.setCellValueFactory(new PropertyValueFactory("cognome"));
        nomeClm.setCellValueFactory(new PropertyValueFactory("nome"));
        
        contattiTable.setItems(contatti);
        rubrica=new Rubrica();
           
    } 
    
    private void addContatto (ActionEvent event) {
        
        contatti.add(new Contatto(nomeField.getText(),cognomeField.getText(),telefono1Field.getText(),email1Field.getText()));
        
        
        
    }
    
    
}
