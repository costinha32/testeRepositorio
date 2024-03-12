package javafx.eu.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class EuController implements Initializable{
	
	@FXML
    private AnchorPane pnlPrincipal;

    @FXML
    private GridPane pnlGrid;

    @FXML
    private Label lblnum1;

    @FXML
    private Label lblnum2;

    @FXML
    private Label lbloperacao;

    @FXML
    private Label lblresultado;

    @FXML
    private TextField txtNum1;

    @FXML
    private TextField txtNum2;

    @FXML
    private Button btnCalcular;

    @FXML
    private Label lblResultado;

    @FXML
    private ComboBox cmbOperacao;

    @FXML
    void onClickCalcular(ActionEvent event) {	
   
    }
    
    @FXML
    void onClickSelect(ActionEvent event) {
    	String s = cmbOperacao.getSelectionModel().getSelectedItem().toString();
    	
    }
    public boolean onCloseQuery() {
    	Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		alerta.setTitle("Pergunta");
		alerta.setHeaderText("Deseja sair do sistema?");
		ButtonType botaoNao = ButtonType.NO;
		ButtonType botaoSim = ButtonType.YES;
		alerta.getButtonTypes().setAll(botaoSim, botaoNao);
		Optional<ButtonType> opcaoClicado = alerta.showAndWait();
		
		return opcaoClicado.get() == botaoSim? true : false;
				
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> list = FXCollections.observableArrayList("+", "-", "*", "%", "^");
		cmbOperacao.setItems(list);
	}


} 


