package com.javafx.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class SomarController implements Initializable{
	 @FXML
	    private AnchorPane pnlPrincipal;

	    @FXML
	    private GridPane pnlGrid;

	    @FXML
	    private Label lblNum1;

	    @FXML
	    private Label lblNumero2;

	    @FXML
	    private Label lblResultado;

	    @FXML
	    private Label lblResultadoSoma;

	    @FXML
	    private TextField txtNumero1;

	    @FXML
	    private TextField txtNumero2;

	    @FXML
	    private Button btnSomar;

	    @FXML
	    private Button btnLimpar;
	    
	    @FXML
	    private Button btnMultiplicar;
	    

	    @FXML
	    private Button btndividir;
	    
	    @FXML
	    private Button btnDiminuir;
	    

	    @FXML
	    void onClickBtnDiminuir(ActionEvent event) {
	    	try {
				double numero1 = Double.parseDouble(this.txtNumero1.getText());
				double numero2 = Double.parseDouble(this.txtNumero2.getText());
				
				numero1 = numero1 - numero2;
				
				lblResultadoSoma.setText(new Double(numero1).toString());
				
			} catch (NumberFormatException e) {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				e.printStackTrace(pw);
				String textoErro = sw.toString();
				
				//mostrando os erros
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setTitle("Errom");
				alerta.setHeaderText("Aconteceu um erro de conversão mumérica.");
				
				Label label = new Label("Segue a pilha de esceção:");
				
				TextArea textarea = new TextArea(textoErro);
				textarea.setEditable(false);
				textarea.setWrapText(false);
				
				textarea.setMaxWidth(Double.MAX_VALUE);
				textarea.setMaxHeight(Double.MAX_VALUE);
				GridPane.setVgrow(textarea, Priority.ALWAYS);
				GridPane.setHgrow(textarea, Priority.ALWAYS);
				
				GridPane expConteudo = new GridPane();
				expConteudo.setMaxWidth(Double.MAX_VALUE);
				expConteudo.add(label, 0, 0);
				expConteudo.add(textarea, 0, 1);
				alerta.getDialogPane().setExpandableContent(expConteudo);
				alerta.showAndWait();
				
			}

	    }
	    
	    @FXML
	    void onClickBtnDividir(ActionEvent event) {
	    	try {
				double numero1 = Double.parseDouble(this.txtNumero1.getText());
				double numero2 = Double.parseDouble(this.txtNumero2.getText());
				
				numero1 = numero1 / numero2;
				
				lblResultadoSoma.setText(new Double(numero1).toString());
				
			} catch (NumberFormatException e) {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				e.printStackTrace(pw);
				String textoErro = sw.toString();
				
				//mostrando os erros
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setTitle("Errom");
				alerta.setHeaderText("Aconteceu um erro de conversão mumérica.");
				
				Label label = new Label("Segue a pilha de esceção:");
				
				TextArea textarea = new TextArea(textoErro);
				textarea.setEditable(false);
				textarea.setWrapText(false);
				
				textarea.setMaxWidth(Double.MAX_VALUE);
				textarea.setMaxHeight(Double.MAX_VALUE);
				GridPane.setVgrow(textarea, Priority.ALWAYS);
				GridPane.setHgrow(textarea, Priority.ALWAYS);
				
				GridPane expConteudo = new GridPane();
				expConteudo.setMaxWidth(Double.MAX_VALUE);
				expConteudo.add(label, 0, 0);
				expConteudo.add(textarea, 0, 1);
				alerta.getDialogPane().setExpandableContent(expConteudo);
				alerta.showAndWait();
				
			}
	    }
	    

	    @FXML
	    void onClickBtnMultiplicar(ActionEvent event) {
	    	try {
				double numero1 = Double.parseDouble(this.txtNumero1.getText());
				double numero2 = Double.parseDouble(this.txtNumero2.getText());
				
				numero1 = numero1 * numero2;
				
				lblResultadoSoma.setText(new Double(numero1).toString());
				
			} catch (NumberFormatException e) {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				e.printStackTrace(pw);
				String textoErro = sw.toString();
				
				//mostrando os erros
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setTitle("Errom");
				alerta.setHeaderText("Aconteceu um erro de conversão mumérica.");
				
				Label label = new Label("Segue a pilha de esceção:");
				
				TextArea textarea = new TextArea(textoErro);
				textarea.setEditable(false);
				textarea.setWrapText(false);
				
				textarea.setMaxWidth(Double.MAX_VALUE);
				textarea.setMaxHeight(Double.MAX_VALUE);
				GridPane.setVgrow(textarea, Priority.ALWAYS);
				GridPane.setHgrow(textarea, Priority.ALWAYS);
				
				GridPane expConteudo = new GridPane();
				expConteudo.setMaxWidth(Double.MAX_VALUE);
				expConteudo.add(label, 0, 0);
				expConteudo.add(textarea, 0, 1);
				alerta.getDialogPane().setExpandableContent(expConteudo);
				alerta.showAndWait();
				
			}
	    }
	    


	    @FXML
	    void onClickBtnLimpar(ActionEvent event) {
	    	this.txtNumero1.setText(new String());
	    	this.txtNumero2.setText(new String());
	    	this.lblResultadoSoma.setText(new String("0"));
	    	this.txtNumero1.requestFocus();
	    }

	    @FXML
	    void onClickBtnSomar(ActionEvent event) {
	    	try {
				double numero1 = Double.parseDouble(this.txtNumero1.getText());
				double numero2 = Double.parseDouble(this.txtNumero2.getText());
				
				numero1 = numero1 + numero2;
				
				lblResultadoSoma.setText(new Double(numero1).toString());
				
			} catch (NumberFormatException e) {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				e.printStackTrace(pw);
				String textoErro = sw.toString();
				
				//mostrando os erros
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setTitle("Erro");
				alerta.setHeaderText("Aconteceu um erro de conversão numérica.");
				
				Label label = new Label("Segue a pilha de exceção:");
				
				TextArea textarea = new TextArea(textoErro);
				textarea.setEditable(false);
				textarea.setWrapText(false);
				
				textarea.setMaxWidth(Double.MAX_VALUE);
				textarea.setMaxHeight(Double.MAX_VALUE);
				GridPane.setVgrow(textarea, Priority.ALWAYS);
				GridPane.setHgrow(textarea, Priority.ALWAYS);
				
				GridPane expConteudo = new GridPane();
				expConteudo.setMaxWidth(Double.MAX_VALUE);
				expConteudo.add(label, 0, 0);
				expConteudo.add(textarea, 0, 1);
				alerta.getDialogPane().setExpandableContent(expConteudo);
				alerta.showAndWait();
				
			}
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
		public void initialize(URL location, ResourceBundle resources) {
			this.txtNumero1.requestFocus();
			
		}

}

