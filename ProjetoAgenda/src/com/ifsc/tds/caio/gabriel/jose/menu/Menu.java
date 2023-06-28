package com.ifsc.tds.caio.gabriel.jose.menu;

import com.ifsc.tds.caio.gabriel.jose.controller.ContatoListaController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Menu extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// carregando o loader
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ifsc/tds/caio/gabriel/jose/view/ContatoLista.fxml"));
			Parent menuXML = loader.load();

			// carregando o controller e a scene
			ContatoListaController contatoListaController = loader.getController();
			Scene menuLayout = new Scene(menuXML);

			Stage menuJanela = new Stage();
			Image icon = new Image("file:resources/img/agenda.png");
			menuJanela.getIcons().add(icon);
			menuJanela.initModality(Modality.APPLICATION_MODAL);
			menuJanela.resizableProperty().setValue(Boolean.FALSE);
			menuJanela.setScene(menuLayout);
			menuJanela.setTitle("Agenda minha");

			// atribuindo evento para fechar janela
			menuJanela.setOnCloseRequest(e -> {
				
				if (contatoListaController.onCloseQuery()) {
					System.exit(0);
				} else {
					e.consume();
				}
			});

			menuJanela.show();

			// posicionando a janela no centro da tela do computador
			Rectangle2D posicaoJanela = Screen.getPrimary().getVisualBounds();
			menuJanela.setX((posicaoJanela.getWidth() - menuJanela.getWidth()) / 2);
			menuJanela.setY((posicaoJanela.getHeight() - menuJanela.getHeight()) / 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
