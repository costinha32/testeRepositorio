package com.ifsc.tds.caio.gabriel.jose.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class EmprestimosEditController {

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
    private Label lblDescricao;

    @FXML
    private DatePicker dateDevolucao;

    @FXML
    private ComboBox<?> cboFilme;

    @FXML
    private ComboBox<?> cboUsuario;

    @FXML
    private TextField txtDescricao;

    @FXML
    private DatePicker dateEmprestimo;

    @FXML
    private GridPane pnlButton;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCnacela;

    @FXML
    void onClickBtnCancela(ActionEvent event) {

    }

    @FXML
    void onClickBtnOK(ActionEvent event) {

    }

    @FXML
    void onClickDevolucao(ActionEvent event) {

    }

    @FXML
    void onClickEmprestimo(ActionEvent event) {

    }

    @FXML
    void onClickFilme(ActionEvent event) {

    }

    @FXML
    void onClickUsuario(ActionEvent event) {

    }

}
