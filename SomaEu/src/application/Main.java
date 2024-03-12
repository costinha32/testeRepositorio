package application;
	
import javafx.application.Application;
import javafx.eu.controller.EuController;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Calculadora");
			primaryStage.resizableProperty().setValue(Boolean.FALSE );
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafx/eu/view/somarEu.fxml"));
			Parent arquivofxml = loader.load();
			
			Scene somarCena = new Scene(arquivofxml);
			primaryStage.setScene(somarCena);
			
			EuController euController = loader.getController();
			
			primaryStage.setOnCloseRequest(e->{
				if (euController.onCloseQuery())
				{
					System.exit(0);
				} else 
				{
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
