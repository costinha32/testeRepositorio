package com.ifsc.tds.caio.gabriel.jose.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.ifsc.tds.caio.gabriel.jose.enity.Filmes;

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

public class FilmesEditController implements Initializable {

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
		this.getJanelaFilmesEdit().close();
	}

	@FXML
	void onClickBtnOK(ActionEvent event) {
		if (validarCampos()) {
			this.filmes.setNomeFilme(this.txtNome.getText());
			this.okClick = true;
			this.getJanelaFilmesEdit().close();
		}

	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {

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
		this.filmes = filmes;
		this.txtNome.setText(filmes.getNomeFilme());

	}

	
	public Filmes getFilmes() {
		return filmes;
	}

	public void setFilmes(Filmes filmes) {
		this.filmes = filmes;
	}

	private boolean validarCampos() {
		String mensagemErros = new String();

		if (this.txtNome.getText() == null || this.txtNome.getText().trim().length() == 0) {
			mensagemErros += "Informe o nome do filme!\n";
		}

		if (mensagemErros.length() == 0) {
			return true;
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.initOwner(this.janelaFilmesEdit);
			alerta.setTitle("Dados inválidos!");
			alerta.setHeaderText("Favor corrigir as seguintes informações:");
			alerta.setContentText(mensagemErros);
			alerta.showAndWait();
			return false;
		}
	}
}
