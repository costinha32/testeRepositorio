package com.ifsc.tds.caio.gabriel.jose.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.ifsc.tds.caio.gabriel.jose.enity.Contato;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ContatoEditController implements Initializable {

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
	
	@FXML
	private GridPane pnlButton;

	@FXML
	private Button btnOk;

	@FXML
	private Button btnCnacela;

	private Stage janelaContatoEdit;

	private Contato contato;


	private boolean okClick = false;

	public Stage getJanelaContatoEdit() {
		return janelaContatoEdit;
	}

	public void setJanelaContatoEdit(Stage janelaContatoEdit) {
		this.janelaContatoEdit = janelaContatoEdit;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public boolean isOkClick() {
		return okClick;
	}

	public void setOkClick(boolean okClick) {
		this.okClick = okClick;
	}

	@FXML
		void onClickBtnCancela(ActionEvent event) {
		this.getJanelaContatoEdit().close();
	}

	void onClickBtnOK(ActionEvent event) {
		if (validarCampos()) {
			this.contato.setNome(this.txtNome.getText());
			this.contato.setTelefone(this.txtTelefone.getText());
			this.contato.setEmail(this.txtEmail.getText());
			
			this.okClick = true;
			this.getJanelaContatoEdit().close();
		}
	}
	


	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
	private boolean validarCampos() {
		String mensagemErros = new String();

		if (this.txtNome.getText() == null || this.txtNome.getText().trim().length() == 0) {
			mensagemErros += "Informe o Nome!\n";
		}
		
		if (this.txtTelefone.getText() == null || this.txtTelefone.getText().trim().length() == 0) {
			mensagemErros += "Informe o Telefone!\n";
		}
		
		if (this.txtEmail.getText() == null || this.txtEmail.getText().trim().length() == 0) {
			mensagemErros += "Informe o Email!\n";
		}
		

		if (mensagemErros.length() == 0) {
			return true;
		}
		else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.initOwner(this.janelaContatoEdit);
			alerta.setTitle("Dados inválidos!");
			alerta.setHeaderText("Favor corrigir as informações:");
			alerta.setContentText(mensagemErros);
			alerta.showAndWait();

			return false;
		}
	}

	public void populaTela(Contato contato) {
		// TODO Auto-generated method stub
		
	}	
}
