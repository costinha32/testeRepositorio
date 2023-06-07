package com.ifsc.tds.caio.gabriel.jose.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ClienteEditController {

    @FXML
    private AnchorPane pnlPrincipal;

    @FXML
    private GridPane pnlDados;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblTelefone;

    @FXML
    private Label lblEmail;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TextField txtEmail;

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

}
