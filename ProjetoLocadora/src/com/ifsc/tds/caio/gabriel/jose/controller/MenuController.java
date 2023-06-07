package com.ifsc.tds.caio.gabriel.jose.controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

import com.peregrinoti.controller.TipoColecaoListaController;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MenuController implements Initializable{

    @FXML
    private VBox pnlPrincipal;

    @FXML
    private MenuBar barMenu;

    @FXML
    private Menu mnuCadastro;

    @FXML
    private MenuItem mnoCliente;

    @FXML
    private MenuItem mnoFilmes;

    @FXML
    private MenuItem mnoEmprestimo;

    @FXML
    private SeparatorMenuItem sepCadastro;

    @FXML
    private MenuItem mnoSair;

    @FXML
    private Menu mnuAjuda;

    @FXML
    private MenuItem mnoSobre;
    
    private Stage stage;
    
    public Stage getStage() {
		return stage;
	}

    public void setStage(Stage stage) {
		this.stage = stage;
	}

	@FXML
    void onClickMnoCliente(ActionEvent event) {
    	
    	try {
			// carregando o loader
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ifsc/tds/caio/gabriel/jose/view/ClientesLista.fxml"));
			Parent clienteListaXML = loader.load();

			// carregando o controller e a scene
			ClienteListaController clienteListaController = loader.getController();
			Scene clienteListaLayout = new Scene(clienteListaXML);

			this.getStage().setScene(clienteListaLayout);
			this.getStage().setTitle("Cadastro de cliente");

			// atribuindo evento para fechar janela
			this.getStage().setOnCloseRequest(e -> {
				if (clienteListaController.onCloseQuery()) {
					this.getStage().close();
				} else {
					e.consume();
				}
			});

			this.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

    }

	

	@FXML
    void onClickMnoEmprestimo(ActionEvent event) {

		try {
			// carregando o loader
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ifsc/tds/caio/gabriel/jose/view/EmprestimosLista.fxml"));
			Parent emprestimosListaXML = loader.load();

			// carregando o controller e a scene
			EmprestimosListaController emprestimosListaController = loader.getController();
			Scene emprestimosListaLayout = new Scene(emprestimosListaXML);

			this.getStage().setScene(emprestimosListaLayout);
			this.getStage().setTitle("Cadastro de empréstimos");

			// atribuindo evento para fechar janela
			this.getStage().setOnCloseRequest(e -> {
				if (EmprestimosListaController.onCloseQuery()) {
					this.getStage().close();
				} else {
					e.consume();
				}
			});

			this.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }

    @FXML
    void onClickMnoFilmes(ActionEvent event) {
    		
    	try {
			// carregando o loader
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ifsc/tds/caio/gabriel/jose/view/FilmesLista.fxml"));
			Parent filmesListaXML = loader.load();

			// carregando o controller e a scene
			FilmesListaController filmesListaController = loader.getController();
			Scene filmesListaLayout = new Scene(filmesListaXML);

			this.getStage().setScene(filmesListaLayout);
			this.getStage().setTitle("Cadastro de filme");

			// atribuindo evento para fechar janela
			this.getStage().setOnCloseRequest(e -> {
				if (filmesListaController.onCloseQuery()) {
					this.getStage().close();
				} else {
					e.consume();
				}
			});

			this.stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void onClickMnoSair(ActionEvent event) {
    		
    	if (this.onCloseQuery()) {
			System.exit(0);
		} else {
			event.consume();
		}
    	
    }

    private boolean onCloseQuery() {
    	Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		alerta.setTitle("Pergunta");
		alerta.setHeaderText("Deseja sair do sistema?");
		ButtonType botaoNao = ButtonType.NO;
		ButtonType botaoSim = ButtonType.YES;
		alerta.getButtonTypes().setAll(botaoSim, botaoNao);
		Optional<ButtonType> resultado = alerta.showAndWait();
		return resultado.get() == botaoSim ? true : false;
	}

	@FXML
    void onClickMnoSobre(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.configuraStage();
		
	}
	

	public void configuraStage() {
		this.setStage(new Stage());
		this.getStage().initModality(Modality.APPLICATION_MODAL);
		this.getStage().resizableProperty().setValue(Boolean.FALSE);
	}

}
