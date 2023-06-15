package com.ifsc.tds.caio.gabriel.jose.controller;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ifsc.tds.caio.gabriel.jose.dao.FilmesDAO;
import com.ifsc.tds.caio.gabriel.jose.enity.Filmes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class FilmesListaController implements Initializable {

	@FXML
	private AnchorPane pnlPrincipal;

	@FXML
	private SplitPane pnlDivisao;

	@FXML
	private AnchorPane pnlEsquerda;

	@FXML
	private TableView<?> tbvFilmeLista;

	@FXML
	private TableColumn<?, ?> tbcCodigo;

	@FXML
	private TableColumn<?, ?> tbcNome;

	@FXML
	private AnchorPane pnlDireita;

	@FXML
	private Label lblDetalhes;

	@FXML
	private GridPane pnlDetalhes;

	@FXML
	private Label lblNomeValor;

	@FXML
	private ButtonBar barBotoes;

	@FXML
	private Button btnIncluir;

	@FXML
	private Tooltip tlpIncluir;

	@FXML
	private Button btnEditar;

	@FXML
	private Tooltip tlpEditar;

	@FXML
	private Button btnExcluir;

	@FXML
	private Tooltip tplExcluir;

	private List<Filmes> listaFilmes;
	private ObservableList<Filmes> observableListaFilmes = FXCollections.observableArrayList();
	private FilmesDAO filmesDAO;

	@FXML
	void onClickBtnEditar(ActionEvent event) {

	}

	@FXML
	void onClickBtnExcluir(ActionEvent event) {

	}

	@FXML
	void onClickBtnIncluir(ActionEvent event) {

	}

	public List<Filmes> getListaFilmes() {
		return listaFilmes;
	}

	public void setListaFilmes(List<Filmes> listaFilmes) {
		this.listaFilmes = listaFilmes;
	}

	public ObservableList<Filmes> getObservableListaFilmes() {
		return observableListaFilmes;
	}

	public void setObservableListaFilmes(ObservableList<Filmes> observableListaFilmes) {
		this.observableListaFilmes = observableListaFilmes;
	}

	public FilmesDAO getFilmesDAO() {
		return filmesDAO;
	}

	public void setFilmesDAO(FilmesDAO filmesDAO) {
		this.filmesDAO = filmesDAO;
	}

	public List<Filmes> retornaListagemFilmes() {
		if (this.getFilmesDAO() == null) {
			this.setFilmesDAO(new FilmesDAO());
		}
		return this.getFilmesDAO().getAll();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public boolean onCloseQuery() {
		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		alerta.setTitle("Pergunta");
		alerta.setHeaderText("Deseja sair do cadastro de filmes?");
		ButtonType buttonTypeNO = ButtonType.NO;
		ButtonType buttonTypeYES = ButtonType.YES;
		alerta.getButtonTypes().setAll(buttonTypeYES, buttonTypeNO);
		Optional<ButtonType> result = alerta.showAndWait();
		return result.get() == buttonTypeYES ? true : false;
	}
}
