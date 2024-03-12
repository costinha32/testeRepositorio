package application.view;

import application.Main;
import application.model.Person;
import application.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class PersonOverviewController {

	@FXML
	private TableView<Person> tbView;
	@FXML
	private TableColumn<Person, String> lblFirstName ;
	@FXML
	private TableColumn<Person, String> lblLastName;

	@FXML
	private AnchorPane pnlPrincipal;

	@FXML
	private SplitPane splitpnl;

	@FXML
	private Label lblPersonDetails;

	@FXML
	private GridPane pnlGrid;;


	@FXML
	private Label lblStreet;

	@FXML
	private Label lblCity;

	@FXML
	private Label lblPostalcode;

	@FXML
	private Label lblBirthday;

	@FXML
	private Label lblNome;

	@FXML
	private Label lblSobrenome;

	@FXML
	private Label lblEndereco;

	@FXML
	private Label lblCidade;

	@FXML
	private Label lblCep;

	@FXML
	private Label lblAniversario;

	@FXML
	private Button btnNew;

	@FXML
	private Button BtnEdit;

	@FXML
	private Button btnDelete;

	private Main main;

	public PersonOverviewController() {

	}

	private void showPersonDetails(Person person) {

		if (person != null) {
			lblNome.setText(person.getFirstName());
			lblSobrenome.setText(person.getLastName());
			lblEndereco.setText(person.getStreet());
			lblCep.setText(Integer.toString(person.getPostalCode()));
			lblCidade.setText(person.getCity());
			lblAniversario.setText(DateUtil.format(person.getBirthday()));

		} else {
			lblNome.setText("");
			lblSobrenome.setText("");
			lblEndereco.setText("");
			lblCep.setText("");
			lblCidade.setText("");
			lblAniversario.setText("");

		}
	}

	@FXML
	private void initialize() {
		// Inicializa a tablea de pessoa com duas colunas.
		lblFirstName.setCellValueFactory(
				cellData -> cellData.getValue().firstNameProperty());
		lblLastName.setCellValueFactory(
				cellData -> cellData.getValue().lastNameProperty());
		
		// Limpa os detalhes da pessoa.
		showPersonDetails(null);
		
		// Detecta mudanças de seleção e mostra os detalhes da pessoa quando houver mudança.
	    tbView.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showPersonDetails(newValue));
	}

	public void setMain(Main main) {
		this.main = main;

		// Adiciona os dados da observable list na tabela
		tbView.setItems(main.getPersonData());
	}
	
	@FXML
	private void handleDeletePerson() {
	    int selectedIndex = tbView.getSelectionModel().getSelectedIndex();
	    tbView.getItems().remove(selectedIndex);
	    
	    if (selectedIndex >= 0 ) {
	    	tbView.getItems().remove(selectedIndex);
	    	
	    } else {
	    	// Nada selecionado
	    	
	    	Alert alert = new Alert(AlertType.WARNING);
        	alert.setTitle("Nenhuma seleção");
        	alert.setHeaderText("Nenhuma Pessoa Selecionada");
        	alert.setContentText("Por favor, selecione uma pessoa na tabela.");

        	alert.showAndWait();
	    	
	    }
	    
	}
	@FXML
	private void handleNewPerson() {
	    Person tempPerson = new Person();
	    boolean okClicked = main.showPersonEditDialog(tempPerson);
	    if (okClicked) {
	        main.getPersonData().add(tempPerson);
	    }
	}
	@FXML
	private void handleEditPerson() {
	    Person selectedPerson = tbView.getSelectionModel().getSelectedItem();
	    if (selectedPerson != null) {
	        boolean okClicked = main.showPersonEditDialog(selectedPerson);
	        if (okClicked) {
	            showPersonDetails(selectedPerson);
	        }

	    } else {
	        // Nada seleciondo.
	        Alert alert = new Alert(AlertType.WARNING);
	        	alert.setTitle("Nenhuma seleção");
	        	alert.setHeaderText("Nenhuma Pessoa Selecionada");
	        	alert.setContentText("Por favor, selecione uma pessoa na tabela.");
	        	alert.showAndWait();
	    }
	}

}
