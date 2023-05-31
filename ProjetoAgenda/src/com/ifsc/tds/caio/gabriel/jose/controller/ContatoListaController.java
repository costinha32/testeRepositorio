package com.ifsc.tds.caio.gabriel.jose.controller;

import java.net.URL;
import java.util.ResourceBundle;

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


public class ContatoListaController  implements Initializable{

    @FXML
    private AnchorPane pnlPrincipal;

    @FXML
    private SplitPane pnlDivisao;

    @FXML
    private AnchorPane pnlEsquerda;

    @FXML
    private TableView<?> tbvCodigoNome;

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
    

    public AnchorPane getPnlPrincipal() {
		return pnlPrincipal;
	}

	public void setPnlPrincipal(AnchorPane pnlPrincipal) {
		this.pnlPrincipal = pnlPrincipal;
	}

	public SplitPane getPnlDivisao() {
		return pnlDivisao;
	}

	public void setPnlDivisao(SplitPane pnlDivisao) {
		this.pnlDivisao = pnlDivisao;
	}

	public AnchorPane getPnlEsquerda() {
		return pnlEsquerda;
	}

	public void setPnlEsquerda(AnchorPane pnlEsquerda) {
		this.pnlEsquerda = pnlEsquerda;
	}

	public TableView<?> getTbvCodigoNome() {
		return tbvCodigoNome;
	}

	public void setTbvCodigoNome(TableView<?> tbvCodigoNome) {
		this.tbvCodigoNome = tbvCodigoNome;
	}

	public TableColumn<?, ?> getTbcCodigo() {
		return tbcCodigo;
	}

	public void setTbcCodigo(TableColumn<?, ?> tbcCodigo) {
		this.tbcCodigo = tbcCodigo;
	}

	public TableColumn<?, ?> getTbcNome() {
		return tbcNome;
	}

	public void setTbcNome(TableColumn<?, ?> tbcNome) {
		this.tbcNome = tbcNome;
	}

	public AnchorPane getPnlDireita() {
		return pnlDireita;
	}

	public void setPnlDireita(AnchorPane pnlDireita) {
		this.pnlDireita = pnlDireita;
	}

	public Label getLblDetalhes() {
		return lblDetalhes;
	}

	public void setLblDetalhes(Label lblDetalhes) {
		this.lblDetalhes = lblDetalhes;
	}

	public GridPane getPnlDetalhes() {
		return pnlDetalhes;
	}

	public void setPnlDetalhes(GridPane pnlDetalhes) {
		this.pnlDetalhes = pnlDetalhes;
	}

	public Label getLblNome() {
		return lblNome;
	}

	public void setLblNome(Label lblNome) {
		this.lblNome = lblNome;
	}

	public Label getLblTelefone() {
		return lblTelefone;
	}

	public void setLblTelefone(Label lblTelefone) {
		this.lblTelefone = lblTelefone;
	}

	public Label getLblEtiquetaValor() {
		return lblEtiquetaValor;
	}

	public void setLblEtiquetaValor(Label lblEtiquetaValor) {
		this.lblEtiquetaValor = lblEtiquetaValor;
	}

	public ButtonBar getBarBotoes() {
		return barBotoes;
	}

	public void setBarBotoes(ButtonBar barBotoes) {
		this.barBotoes = barBotoes;
	}

	public Button getBtnInclur() {
		return btnInclur;
	}

	public void setBtnInclur(Button btnInclur) {
		this.btnInclur = btnInclur;
	}

	public Tooltip getTlpIncluir() {
		return tlpIncluir;
	}

	public void setTlpIncluir(Tooltip tlpIncluir) {
		this.tlpIncluir = tlpIncluir;
	}

	public Button getBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(Button btnEditar) {
		this.btnEditar = btnEditar;
	}

	public Tooltip getTlpEditar() {
		return tlpEditar;
	}

	public void setTlpEditar(Tooltip tlpEditar) {
		this.tlpEditar = tlpEditar;
	}

	public Button getBtnExcluir() {
		return btnExcluir;
	}

	public void setBtnExcluir(Button btnExcluir) {
		this.btnExcluir = btnExcluir;
	}

	public Tooltip getTlpExcluir() {
		return tlpExcluir;
	}

	public void setTlpExcluir(Tooltip tlpExcluir) {
		this.tlpExcluir = tlpExcluir;
	}

	@FXML
    void onClickBtnEditar(ActionEvent event) {

    }

    @FXML
    void onClickBtnExcluir(ActionEvent event) {

    }

    @FXML
    void onClickBtnIncluir(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
