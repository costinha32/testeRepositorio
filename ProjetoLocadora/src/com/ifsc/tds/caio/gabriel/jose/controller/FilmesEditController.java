package com.ifsc.tds.caio.gabriel.jose.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.ifsc.tds.caio.gabriel.jose.enity.Filmes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FilmesEditController implements Initializable{

	@FXML
	private AnchorPane pnlPrincipal;

	@FXML
	private GridPane pnlDados;

	@FXML
	private Label lblNome;

	@FXML
	private TextField txtNome;

	@FXML
	private GridPane pnlButton;

	@FXML
	private Button btnOk;

	@FXML
	private Button btnCnacela;

	private Stage janelaFilmesEdit;

	private Filmes filmes;

	private boolean okClick = false;

	@FXML
	void onClickBtnCancela(ActionEvent event) {

	}

	@FXML
	void onClickBtnOK(ActionEvent event) {

	}

	public Stage getJanelaFilmesEdit() {
		return janelaFilmesEdit;
	}

	public void setJanelaFilmesEdit(Stage janelaFilmesEdit) {
		this.janelaFilmesEdit = janelaFilmesEdit;
	}

	public boolean isOkClick() {
		return okClick;
	}
	public void populaTela(Filmes filmes) {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
