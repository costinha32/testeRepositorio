package com.ifsc.tds.caio.gabriel.jose.controller;

import com.ifsc.tds.caio.gabriel.jose.enity.Contato;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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

	
	@FXML
	private GridPane pnlButton;

	@FXML
	private Button btnOk;

	@FXML
	private Button btnCnacela;

	private Stage janelaContatoEdit;

	private Contato contato;

	private boolean okClick = false;
	
	private ContatoListaController contatoListaController;
	
	
	



}
