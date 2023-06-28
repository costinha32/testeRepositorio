package com.ifsc.tds.caio.gabriel.jose.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import com.ifsc.tds.caio.gabriel.jose.enity.Clientes;
import com.ifsc.tds.caio.gabriel.jose.enity.Emprestimos;
import com.ifsc.tds.caio.gabriel.jose.enity.Filmes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EmprestimosEditController implements Initializable {

	@FXML
	private AnchorPane pnlPrincipal;

	@FXML
	private GridPane pnlDados;

	@FXML
	private Label lblDatadeEmprestimo;

	@FXML
	private Label lblUsuario;

	@FXML
	private Label lblFilme;

	@FXML
	private Label lblDatadeDevolucao;

	@FXML
	private DatePicker dateDevolucao;

	@FXML
	private ComboBox<Filmes> cboFilme;

	@FXML
	private ComboBox<Clientes> cboUsuario;

	@FXML
	private DatePicker dateEmprestimo;

    @FXML
    private Label lblDescricao;

    @FXML
    private TextField txtDescricao;


	@FXML
	private GridPane pnlButton;

	@FXML
	private Button btnOk;

	@FXML
	private Button btnCnacela;

	private Stage janelaEmprestimosEdit;

	private Emprestimos emprestimos;

	private boolean okClick = false;

	private ClienteListaController clienteListaController;

	private FilmesListaController filmesListaController;

	@FXML
	void onClickBtnCancela(ActionEvent event) {
		this.getJanelaEmprestimosEdit().close();
	}

	@FXML
	void onClickBtnOK(ActionEvent event) {
		if (validarCampos()) {
			this.emprestimos.setDataEmpre(Date.valueOf(this.dateEmprestimo.getValue()));
			this.emprestimos.setDataDev(Date.valueOf(this.dateDevolucao.getValue()));
			this.emprestimos.setDesc(this.txtDescricao.getText());
			this.emprestimos.setClientes(this.cboUsuario.getSelectionModel().getSelectedItem());
			this.emprestimos.setFilmes(this.cboFilme.getSelectionModel().getSelectedItem());

			this.okClick = true;
			this.getJanelaEmprestimosEdit().close();
		}
	}

	private boolean validarCampos() {
		String mensagemErros = new String();

		if (this.dateEmprestimo.getValue() == null) {
			mensagemErros += "Informe a data de empréstimo!\n";
		}

		if (this.dateDevolucao.getValue() == null) {
			mensagemErros += "Informe a data de devolução!\n";
		}
		if (this.txtDescricao.getText() == null || this.txtDescricao.getText().trim().length() == 0) {
			mensagemErros += "Informe uma descrição|\n";
		}
		if (this.cboUsuario.getSelectionModel().isEmpty()) {
			mensagemErros += "Selecione um cliente\n";
		}
		if (this.cboFilme.getSelectionModel().isEmpty()) {
			mensagemErros += "Selecine um filme!\n";
		}


		if (mensagemErros.length() == 0) {
			return true;
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.initOwner(this.janelaEmprestimosEdit);
			alerta.setTitle("Dados inválidos!");
			alerta.setHeaderText("Favor corrigir as seguintes informações:");
			alerta.setContentText(mensagemErros);
			alerta.showAndWait();

			return false;
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.clienteListaController = new ClienteListaController();
		this.filmesListaController = new FilmesListaController();

		this.carregarComboBoxClientes();
		this.carregarComboBoxFilmes();
	}

	public void carregarComboBoxFilmes() {
		ObservableList<Filmes> observableListaFilmes = FXCollections
				.observableArrayList(this.filmesListaController.retornaListagemFilmes());

		this.cboFilme.setItems(observableListaFilmes);

	}

	public void carregarComboBoxClientes() {
		ObservableList<Clientes> observableListaClientes = FXCollections
				.observableArrayList(this.clienteListaController.retornaListagemClientes());

		this.cboUsuario.setItems(observableListaClientes);

	}

	public Stage getJanelaEmprestimosEdit() {
		return janelaEmprestimosEdit;
	}

	public void setJanelaEmprestimosEdit(Stage janelaEmprestimosEdit) {
		this.janelaEmprestimosEdit = janelaEmprestimosEdit;
	}
	public void populaTela(Emprestimos emprestimos) {
		this.emprestimos = emprestimos;
		
		this.txtDescricao.setText(this.emprestimos.getDescr());

		
		if (this.emprestimos.getDataEmpre() != null) {
			this.dateEmprestimo.setValue(this.emprestimos.getDataEmpre().toLocalDate());
		}
		if (this.emprestimos.getDataEmpre() != null) {
			this.dateDevolucao.setValue(this.emprestimos.getDataDev().toLocalDate());
		}

		if (this.emprestimos.getClientes() != null) {
			this.cboUsuario.setValue(this.emprestimos.getClientes());
		}

		if (this.emprestimos.getClientes() != null) {
			this.cboFilme.setValue(this.emprestimos.getFilmes());
		}
	}

	public boolean isOkClick() {
		return okClick;
	}

}
