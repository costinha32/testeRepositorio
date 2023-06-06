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
		System.out.println("getJanelaContatoEdit foi, não é aqui");
		return janelaContatoEdit;
	}

	public void setJanelaContatoEdit(Stage janelaContatoEdit) {
		System.out.println("SetJanelaContatoEdit foi, não é aqui");
		this.janelaContatoEdit = janelaContatoEdit;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public boolean isOkClick() {
		System.out.println("Botao ok foi, não é aqui");
		return okClick;
	}

	public void setOkClick(boolean okClick) {
		this.okClick = okClick;
	}

	@FXML
		void onClickBtnCancela(ActionEvent event) {
		System.out.println("Não pode ser aqui");
		this.getJanelaContatoEdit().close();
	}
	@FXML
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
			
			System.out.println("Aqui deu certo!");
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
		this.contato = contato;

		this.txtNome.setText(contato.getNome());
		this.txtTelefone.setText(contato.getTelefone());
		this.txtEmail.setText(contato.getEmail());
		
	}	
}
