package com.ifsc.tds.caio.gabriel.jose.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.ifsc.tds.caio.gabriel.jose.enity.Clientes;

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

public class ClienteEditController implements Initializable {

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

	private Stage janelaClienteEdit;

	private Clientes clientes;

	private boolean okClick = false;

	@FXML
	void onClickBtnCancela(ActionEvent event) {
		this.getJanelaClienteEdit().close();
	}

	@FXML
	void onClickBtnOK(ActionEvent event) {
		if (validarCampos()) {
			this.clientes.setNome(this.txtNome.getText());
			this.clientes.setTelefone(this.txtTelefone.getText());
			this.clientes.setEmail(this.txtEmail.getText());

			this.okClick = true;
			this.getJanelaClienteEdit().close();
		}
	}

	private boolean validarCampos() {
		String mensagemErros = new String();

		if (this.txtNome.getText() == null || this.txtNome.getText().trim().length() == 0) {
			mensagemErros += "Informe o nome do cliente!\n";
		}
		if (this.txtTelefone.getText() == null || this.txtTelefone.getText().trim().length() == 0) {
			mensagemErros += "Informe o telefone!\n";
		}

		if (this.txtEmail.getText() == null || this.txtEmail.getText().trim().length() == 0) {
			mensagemErros += "Informe o email!\n";
		}

		if (mensagemErros.length() == 0) {
			return true;
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.initOwner(this.janelaClienteEdit);
			alerta.setTitle("Dados inválidos!");
			alerta.setHeaderText("Favor corrigir as seguintes informações:");
			alerta.setContentText(mensagemErros);
			alerta.showAndWait();
			return false;
		}
	}

	public Stage getJanelaClienteEdit() {
		return janelaClienteEdit;
	}

	public void setJanelaClienteEdit(Stage janelaClientesEditar) {
		this.janelaClienteEdit = janelaClientesEditar;

	}

	public void populaTela(Clientes clientes) {
		this.clientes = clientes;

		this.txtNome.setText(clientes.getNome());
		this.txtTelefone.setText(clientes.getTelefone());
		this.txtEmail.setText(clientes.getEmail());

	}

	public boolean isOkClick() {
		return okClick;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
