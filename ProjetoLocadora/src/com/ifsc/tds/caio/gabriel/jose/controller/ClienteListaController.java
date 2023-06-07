package com.ifsc.tds.caio.gabriel.jose.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.ifsc.tds.caio.gabriel.jose.dao.ClientesDAO;
import com.ifsc.tds.caio.gabriel.jose.enity.Clientes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
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
    private TableColumn<Clientes, Integer> tbcCodigo;

    @FXML
    private TableColumn<Clientes, String> tbcNome;

    @FXML
    private AnchorPane pnlDireita;

    @FXML
    private Label lblDetalhes;

    @FXML
    private GridPane pnlDetalhes;

    @FXML
    private Label lblLogin;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblNomeValor;

    @FXML
    private Label lblLoginValor;

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

	private List<Clientes> listaClientes;
    private ObservableList<Clientes> observableListaClientes = FXCollections.observableArrayList();
    private ClientesDAO clientesDAO;
    
    public static final String CLIENTES_EDITAR = " - Editar";
	public static final String CLIENTES_INCLUIR = " - Incluir";
	
    @FXML
    void onClickBtnEditar(ActionEvent event) {
    	Clientes clientes = this.tbvClienteLista.getSelectionModel().getSelectedItem();
    	
    	if(clientes != null) {
    		boolean  btnConfrimarClic = this.onShowTelaClienteEditar(clientes,ClienteListaController.CLIENTES_EDITAR);
    			
    		
    	}
    }

    @FXML
    void onClickBtnExcluir(ActionEvent event) {

    }

    @FXML
    void onClickBtnIncluir(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
