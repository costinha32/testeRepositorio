package application.view;

import application.model.Person;
import application.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonEditDialogController {

	@FXML
	private TextField txtFirstName;

	@FXML
	private TextField txtLastName;

	@FXML
	private TextField txtStreet;

	@FXML
	private TextField txtCity;

	@FXML
	private TextField txtCep;

	@FXML
	private TextField txtAniversario;

	private Stage dialogStage;
	private Person person;
	private boolean okClicked = false;

	@FXML
	private void initialize() {

	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setPerson(Person person) {
		this.person = person;

		txtFirstName.setText(person.getFirstName());
		txtLastName.setText(person.getLastName());
		txtStreet.setText(person.getStreet());
		txtCep.setText(Integer.toString(person.getPostalCode()));
		txtCity.setText(person.getCity());
		txtAniversario.setText(DateUtil.format(person.getBirthday()));
		txtAniversario.setPromptText("dd.mm.yyyy");
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	private void handleOk() {
		if (isInputValid()) {

			person.setFirstName(txtFirstName.getText());
			person.setLastName(txtLastName.getText());
			person.setStreet(txtStreet.getText());
			person.setPostalCode(Integer.parseInt(txtCep.getText()));
			person.setCity(txtCity.getText());
			person.setBirthday(DateUtil.parse(txtAniversario.getText()));

			okClicked = true;
			dialogStage.close();
		}
	}
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	private boolean isInputValid() {
		String errorMessage = "";
		
		if (txtFirstName.getText() == null || txtFirstName.getText().length() == 0) {
			errorMessage += "Nome inválido!\n";
		}
		if (txtLastName.getText() == null || txtLastName.getText().length() == 0) {
			errorMessage += "Sobrenome inválido!\n";
		}
		if (txtStreet.getText() == null || txtStreet.getText().length() == 0) {
			errorMessage += "Rua inválida!\n";
		}

		if (txtCep.getText() == null || txtCep.getText().length() == 0) {
			errorMessage += "Código Postal inválido!\n";

		} else {
			try {
				Integer.parseInt(txtCep.getText());
			} catch (NumberFormatException e) {
				errorMessage += "Código Postal inválido (deve ser um inteiro)!\n";
			}
		}

		if (txtCity.getText() == null || txtCity.getText().length() == 0) {
			errorMessage += "Cidade inválida!\n";
		}

		if (txtAniversario.getText() == null || txtAniversario.getText().length() == 0) {
			errorMessage += "Aniversário inválido!\n";
		} else {
			if (!DateUtil.validDate(txtAniversario.getText())) {
				errorMessage += "Aniversário inválido. Use o formato dd.mm.yyyy!\n";
			}
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Campos Inválidos");
			alert.setHeaderText("Por favor, corrija os campos inválidos");
			alert.setContentText(errorMessage);
			alert.showAndWait();

			return false;

		}
	}

}
