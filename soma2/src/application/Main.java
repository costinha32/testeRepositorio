package application;
	
import com.javafx.controller.SomarController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//configurando alguns dados da tela
			primaryStage.setTitle("Calculadora");
			primaryStage.resizableProperty().setValue(Boolean.FALSE );
			
			//carregando arquivo da tela
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/javafx/view/Somar.fxml"));
			Parent arquivoxml =  loader.load();
			
			//atribuindo o arquivo XMLpara uma scene e atribuindo a janela (stage)
			Scene somarCena = new Scene(arquivoxml);
			primaryStage.setScene(somarCena);
			
			//carregando o controller da cena
			
			SomarController somarcontroller = loader.getController();
			
			//atribuindo um evento a  janela fechar tela
			
			primaryStage.setOnCloseRequest(e->{
				if (somarcontroller.onCloseQuery()) {
					System.exit(0);
				}else {
					e.consume();
				}
				
			});
			 
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
