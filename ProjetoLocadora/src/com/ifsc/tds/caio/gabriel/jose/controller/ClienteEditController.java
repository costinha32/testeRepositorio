package com.ifsc.tds.caio.gabriel.jose.controller;

import com.ifsc.tds.caio.gabriel.jose.enity.Clientes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClienteEditController {

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

    @FXML
    void onClickBtnCancela(ActionEvent event) {

    }

    @FXML
    void onClickBtnOK(ActionEvent event) {

    }

	public void setJanelaClienteEdit(Stage janelaClientesEditar) {
		// TODO Auto-generated method stub
		
	}

	
		
	

	public void populaTela(Clientes clientes) {
		// TODO Auto-generated method stub
		
	}

	public boolean isOkClick() {
		// TODO Auto-generated method stub
		return false;
	}

}
