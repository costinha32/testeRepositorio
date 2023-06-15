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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FilmesListaController implements Initializable {

	@FXML
	private AnchorPane pnlPrincipal;

	@FXML
	private SplitPane pnlDivisao;

	@FXML
	private AnchorPane pnlEsquerda;

	@FXML
	private TableView<Filmes> tbvFilmeLista;

	@FXML
	private TableColumn<Filmes, Long> tbcCodigo;

	@FXML
	private TableColumn<Filmes, String> tbcNome;

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

	public static final String FILMESLISTA_EDITAR = " - Editar";
	public static final String FILMESLISTA_INCLUIR = " - Incluir";

	@FXML
	void onClickBtnEditar(ActionEvent event) {
		Filmes filmes = this.tbvFilmeLista.getSelectionModel().getSelectedItem();

		if (filmes != null) {
			boolean btnConfirmarClic = this.onShowTelaFilmesListaEditar(filmes,
					FilmesListaController.FILMESLISTA_EDITAR);

			if (btnConfirmarClic) {
				this.getFilmesDAO().update(filmes, null);
				this.carregarTableViewFilmesLsta();
			}
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setContentText("Por favor, um filme!");
			alerta.show();
		}

	}

	@FXML
	void onClickBtnExcluir(ActionEvent event) {
		Filmes filmes = this.tbvFilmeLista.getSelectionModel().getSelectedItem();

		if (filmes != null) {

			Alert alerta = new Alert(AlertType.CONFIRMATION);
			alerta.setTitle("Pergunta");
			alerta.setHeaderText("Confirma a exclusão do filme?\n" + filmes.getNomeFilme());

			ButtonType botaoNao = ButtonType.NO;
			ButtonType botaoSim = ButtonType.YES;
			alerta.getButtonTypes().setAll(botaoSim, botaoNao);
			Optional<ButtonType> resultado = alerta.showAndWait();

			if (resultado.get() == botaoSim) {
				this.getFilmesDAO().delete(filmes);
				this.carregarTableViewFilmesLsta();
			}
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setContentText("Por favor, escolha um filme na tabela!");
			alerta.show();
		}
	}

	@FXML
	void onClickBtnIncluir(ActionEvent event) {
		Filmes filmes = new Filmes();

		boolean btnConfirmarClic = this.onShowTelaFilmesListaEditar(filmes, FilmesListaController.FILMESLISTA_INCLUIR);

		if (btnConfirmarClic) {
			this.getFilmesDAO().save(filmes);
			this.carregarTableViewFilmesLsta();
		}

	}

	private void carregarTableViewFilmesLsta() {
		this.tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
		this.tbcNome.setCellValueFactory(new PropertyValueFactory<>("nomeFilme"));

		this.setListaFilmes(this.getFilmesDAO().getAll());
		this.setObservableListaFilmes(FXCollections.observableArrayList(this.getListaFilmes()));
		this.tbvFilmeLista.setItems(this.getObservableListaFilmes());
	}

	public void selecionarItemTableViewFilmes(Filmes filmes) {
		if (filmes != null) {
			this.lblNomeValor.setText(filmes.getNomeFilme());
		} else {
			this.lblNomeValor.setText("");
		}
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

	private boolean onShowTelaFilmesListaEditar(Filmes filmes, String operacao) {
		try {
			// carregando o loader
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/com/ifsc/tds/caio/gabriel/jose/view/FilmesEdit.fxml"));
			Parent filmesEditXML = loader.load();

			// criando uma janela nova
			Stage janelaFilmesEditar = new Stage();
			janelaFilmesEditar.setTitle("Cadastro de filme" + operacao);
			janelaFilmesEditar.initModality(Modality.APPLICATION_MODAL);
			janelaFilmesEditar.resizableProperty().setValue(Boolean.FALSE);

			Scene filmesEditLayout = new Scene(filmesEditXML);
			janelaFilmesEditar.setScene(filmesEditLayout);

			// carregando o controller e a scene
			FilmesEditController filmesEditController = loader.getController();
			filmesEditController.setJanelaFilmesEdit(janelaFilmesEditar);
			filmesEditController.populaTela(filmes);

			// mostrando a tela
			janelaFilmesEditar.showAndWait();

			return filmesEditController.isOkClick();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
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
}
