package com.ifsc.tds.caio.gabriel.jose.controller;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ifsc.tds.caio.gabriel.jose.dao.ClientesDAO;
import com.ifsc.tds.caio.gabriel.jose.enity.Clientes;

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

public class ClienteListaController implements Initializable {

	@FXML
	private AnchorPane pnlPrincipal;

	@FXML
	private SplitPane pnlDivisao;

	@FXML
	private AnchorPane pnlEsquerda;

	@FXML
	private TableView<Clientes> tbvClienteLista;

	@FXML
	private TableColumn<Clientes, Long> tbcCodigo;

	@FXML
	private TableColumn<Clientes, String> tbcNome;

	@FXML
	private AnchorPane pnlDireita;

	@FXML
	private Label lblDetalhes;

	@FXML
	private GridPane pnlDetalhes;

	@FXML
	private Label lblTelefone;

	@FXML
	private Label lblEmail;

	@FXML
	private Label lblNomeValor;

	@FXML
	private Label lblTelefoneValor;

	@FXML
	private Label lblEmailValor;

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

	private Stage stage;

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setObservableListaClientes(ObservableList<Clientes> observableListaClientes) {
		this.observableListaClientes = observableListaClientes;
	}

	private List<Clientes> listaClientes;

	public void setClientesDAO(ClientesDAO clientesDAO) {
		this.clientesDAO = clientesDAO;
	}

	private ObservableList<Clientes> observableListaClientes = FXCollections.observableArrayList();
	private ClientesDAO clientesDAO;

	public static final String CLIENTES_EDITAR = " - Editar";
	public static final String CLIENTES_INCLUIR = " - Incluir";

	@FXML
	void onClickBtnEditar(ActionEvent event) {
		Clientes clientes = this.tbvClienteLista.getSelectionModel().getSelectedItem();

		if (clientes != null) {
			boolean btnConfrimarClic = this.onShowTelaClienteEditar(clientes, ClienteListaController.CLIENTES_EDITAR);

			if (btnConfrimarClic) {
				this.getClientesDAO().update(clientes, null);
				this.carregarTableViewClientes();
			}

		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setContentText("Por favor, escolha cliente na tabela!");
			alerta.show();
		}
	}

	@FXML
	void onClickBtnExcluir(ActionEvent event) {
		Clientes clientes = this.tbvClienteLista.getSelectionModel().getSelectedItem();

		if (clientes != null) {
			Alert alerta = new Alert(AlertType.CONFIRMATION);
			alerta.setTitle("Pergunta");
			alerta.setHeaderText("Confirma a exclusão do contato?\n" + clientes.getNome());

			ButtonType botaoNao = ButtonType.NO;
			ButtonType botaoSim = ButtonType.YES;
			alerta.getButtonTypes().setAll(botaoSim, botaoNao);
			Optional<ButtonType> resultado = alerta.showAndWait();

			if (resultado.get() == botaoSim) {
				this.getClientesDAO().delete(clientes);
				this.carregarTableViewClientes();
			}
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setContentText("Por favor, escolha um cliente na tabela!");
			alerta.show();
		}

	}

	@FXML
	void onClickBtnIncluir(ActionEvent event) {

		Clientes clientes = new Clientes();

		boolean btnConfirmarClic = this.onShowTelaClienteEditar(clientes, ClienteListaController.CLIENTES_INCLUIR);

		if (btnConfirmarClic) {
			this.getClientesDAO().save(clientes);
			this.carregarTableViewClientes();
		}

	}

	public ClientesDAO getClientesDAO() {

		return clientesDAO;
	}

	public void setContatoDAO(ClientesDAO clientesDAO) {
		this.clientesDAO = clientesDAO;
	}

	public void setListaClientes(List<Clientes> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public ObservableList<Clientes> getObservableListaClientes() {
		return observableListaClientes;
	}

	public void setObservableListaClientes(ObservableList<Clientes> observableListaCLientes,
			ObservableList<Clientes> observableListaClientes) {
		this.observableListaClientes = observableListaClientes;
	}

	public void selecionarItemTableViewClientes(Clientes clientes) {
		if (clientes != null) {
			this.lblNomeValor.setText(clientes.getNome());
			this.lblTelefoneValor.setText(clientes.getTelefone());
			this.lblEmailValor.setText(clientes.getEmail());
		} else {
			this.lblNomeValor.setText("");
			this.lblTelefoneValor.setText("");
			this.lblEmailValor.setText("");
		}
	}

	private void carregarTableViewClientes() {
		this.tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
		this.tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

		this.setListaClientes(this.getClientesDAO().getAll());
		this.setObservableListaClientes(FXCollections.observableArrayList(this.getObservableListaClientes()));
		this.tbvClienteLista.setItems(this.getObservableListaClientes());

	}

	private boolean onShowTelaClienteEditar(Clientes clientes, String clientesEditar) {
		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/com/ifsc/tds/caio/gabriel/jose/view/ClientesEdit.fxml"));
			Parent clientesEditXML = loader.load();

			Stage janelaClientesEditar = new Stage();
			janelaClientesEditar.setTitle("Cadastro de clientes" + clientesEditar);
			janelaClientesEditar.initModality(Modality.APPLICATION_MODAL);
			janelaClientesEditar.resizableProperty().setValue(Boolean.FALSE);

			Scene clientesEditLayout = new Scene(clientesEditXML);
			janelaClientesEditar.setScene(clientesEditLayout);

			// carregando o controller e a scene
			ClienteEditController clienteEditController = loader.getController();
			clienteEditController.setJanelaClienteEdit(janelaClientesEditar);
			clienteEditController.populaTela(clientes);

			// mostrando a tela
			janelaClientesEditar.showAndWait();

			return clienteEditController.isOkClick();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		this.setClientesDAO(new ClientesDAO());
		this.carregarTableViewClientes();
		this.selecionarItemTableViewClientes(null);

		this.tbvClienteLista.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selecionarItemTableViewClientes(newValue));

	}

	public List<Clientes> retornaListagemClientes() {
		if (this.getClientesDAO() == null) {
			this.setContatoDAO(new ClientesDAO());
		}
		return this.getClientesDAO().getAll();
	}

	public List<Clientes> getListaContato() {
		return listaClientes;
	}

	public boolean onCloseQuery() {
		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		alerta.setTitle("Pergunta");
		alerta.setHeaderText("Deseja sair do cadastro de Cliente?");
		ButtonType buttonTypeNO = ButtonType.NO;
		ButtonType buttonTypeYES = ButtonType.YES;
		alerta.getButtonTypes().setAll(buttonTypeYES, buttonTypeNO);
		Optional<ButtonType> result = alerta.showAndWait();
		return result.get() == buttonTypeYES ? true : false;
	}
}
