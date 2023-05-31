package com.ifsc.tds.caio.gabriel.jose.controller;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ifsc.tds.caio.gabriel.jose.dao.ContatoDAO;
import com.ifsc.tds.caio.gabriel.jose.enity.Contato;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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


public class ContatoListaController  implements Initializable{

    @FXML
    private AnchorPane pnlPrincipal;

    @FXML
    private SplitPane pnlDivisao;

    @FXML
    private AnchorPane pnlEsquerda;

    @FXML
    private TableView<Contato> tbvCodigoNome;

    @FXML
    private TableColumn<Contato, Integer > tbcCodigo;

    @FXML
    private TableColumn<Contato, String > tbcNome;

    @FXML
    private AnchorPane pnlDireita;

    @FXML
    private Label lblDetalhes;

    @FXML
    private GridPane pnlDetalhes;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblTelefone;

    @FXML
    private Label lblEtiquetaValor;

    @FXML
    private ButtonBar barBotoes;

    @FXML
    private Button btnInclur;

    @FXML
    private Tooltip tlpIncluir;

    @FXML
    private Button btnEditar;

    @FXML
    private Tooltip tlpEditar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Tooltip tlpExcluir;
    

    private List<Contato> listaContato;
	private ObservableList<Contato> observableListaContato = FXCollections.observableArrayList();
	private ContatoDAO contatoDAO;

	public static final String CONTATO_EDITAR = " - Editar";
	public static final String CONTATO_INCLUIR = " - Incluir";



	@FXML
    void onClickBtnEditar(ActionEvent event) {
    	
    	Contato contato = this.tbvCodigoNome.getSelectionModel().getSelectedItem();

		if (contato != null) {
			boolean btnConfirmarClic = this.onShowTelaContatoEditar(contato, ContatoListaController.CONTATO_EDITAR);

			if (btnConfirmarClic) {
				this.getContatoDAO().update(contato, null);
				this.carregarTableViewContato();
			}
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setContentText("Por favor, escolha um amigo na tabela!");
			alerta.show();
		}


    }
	
	@FXML
    void onClickBtnExcluir(ActionEvent event) {
		
		Contato contato = this.tbvCodigoNome.getSelectionModel().getSelectedItem();

		if (contato != null) {

			Alert alerta = new Alert(AlertType.CONFIRMATION);
			alerta.setTitle("Pergunta");
			alerta.setHeaderText("Confirma a exclusão do contato?\n" + contato.getNome());

			ButtonType botaoNao = ButtonType.NO;
			ButtonType botaoSim = ButtonType.YES;
			alerta.getButtonTypes().setAll(botaoSim, botaoNao);
			Optional<ButtonType> resultado = alerta.showAndWait();

			if (resultado.get() == botaoSim) {
				this.getContatoDAO().delete(contato);
				this.carregarTableViewContato();
			}
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setContentText("Por favor, escolha um amigo na tabela!");
			alerta.show();
		}

    }
	
	  @FXML
	    void onClickBtnIncluir(ActionEvent event) {

		  Contato contato = new Contato();

			boolean btnConfirmarClic = this.onShowTelaContatoEditar(contato, ContatoListaController.CONTATO_INCLUIR);

			if (btnConfirmarClic) {
				this.getContatoDAO().save(contato);
				this.carregarTableViewContato();
			}
		  
	    }


    public Object getContatoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	public void carregarTableViewContato() {
		// TODO Auto-generated method stub
		
	}
    
	public boolean onShowTelaContatoEditar(Contato contato, String contatoEditar) {
		// TODO Auto-generated method stub
		return false;
	}

	
  

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	public List<Contato> getListaContato() {
		return listaContato;
	}

	public void setListaContato(List<Contato> listaContato) {
		this.listaContato = listaContato;
	}

	public ObservableList<Contato> getObservableListaContato() {
		return observableListaContato;
	}

	public void setObservableListaContato(ObservableList<Contato> observableListaContato) {
		this.observableListaContato = observableListaContato;
	}

	public void setContatoDAO(ContatoDAO contatoDAO) {
		this.contatoDAO = contatoDAO;
	}

}
