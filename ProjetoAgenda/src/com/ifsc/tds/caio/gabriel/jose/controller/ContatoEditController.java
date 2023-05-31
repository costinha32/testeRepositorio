package com.ifsc.tds.caio.gabriel.jose.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ContatoEditController {

	@FXML
	private AnchorPane pnlPrincipal;

	@FXML
	private GridPane pnlDados;

	@FXML
	private Label lblNome;

	@FXML
	private Label lblTelefone;

	@FXML
	private Label lblEmail;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtTelefone;

	@FXML
	private TextField txtEmail;

<<<<<<< HEAD
	@FXML
	private GridPane pnlButton;
=======
	    @FXML
	    private GridPane pnlButton;

	    @FXML
	    private Button btnOk;

	    @FXML
	    private Button btnCnacela;

		public AnchorPane getPnlPrincipal() {
			return pnlPrincipal;
		}

		public void setPnlPrincipal(AnchorPane pnlPrincipal) {
			this.pnlPrincipal = pnlPrincipal;
		}

		public GridPane getPnlDados() {
			return pnlDados;
		}

		public void setPnlDados(GridPane pnlDados) {
			this.pnlDados = pnlDados;
		}

		public Label getLblNome() {
			return lblNome;
		}

		public void setLblNome(Label lblNome) {
			this.lblNome = lblNome;
		}

		public Label getLblTelefone() {
			return lblTelefone;
		}

		public void setLblTelefone(Label lblTelefone) {
			this.lblTelefone = lblTelefone;
		}

		public Label getLblEmail() {
			return lblEmail;
		}

		public void setLblEmail(Label lblEmail) {
			this.lblEmail = lblEmail;
		}

		public TextField getTxtNome() {
			return txtNome;
		}

		public void setTxtNome(TextField txtNome) {
			this.txtNome = txtNome;
		}

		public TextField getTxtTelefone() {
			return txtTelefone;
		}

		public void setTxtTelefone(TextField txtTelefone) {
			this.txtTelefone = txtTelefone;
		}

		public TextField getTxtEmail() {
			return txtEmail;
		}

		public void setTxtEmail(TextField txtEmail) {
			this.txtEmail = txtEmail;
		}

		public GridPane getPnlButton() {
			return pnlButton;
		}

		public void setPnlButton(GridPane pnlButton) {
			this.pnlButton = pnlButton;
		}

		public Button getBtnOk() {
			return btnOk;
		}

		public void setBtnOk(Button btnOk) {
			this.btnOk = btnOk;
		}

		public Button getBtnCnacela() {
			return btnCnacela;
		}

		public void setBtnCnacela(Button btnCnacela) {
			this.btnCnacela = btnCnacela;
		}
	    
	    

	}
>>>>>>> d1f68fee524facfa1a8b4182f860eed919b047b7

	@FXML
	private Button btnOk;

	@FXML
	private Button btnCnacela;

}
