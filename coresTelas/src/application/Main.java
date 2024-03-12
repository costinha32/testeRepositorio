package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	
	String cores[] = {"Blue", "Black", "Red", "White", "Gree", "Yellow", "Gray", "Pink", "Salmon" };
	@Override
	public void start(Stage primaryStage) {
		try {
			StackPane raiz = new StackPane();
			HBox opcoes = new HBox(10);
			opcoes.setAlignment(Pos.CENTER);
			final Rectangle retangulo = new Rectangle(300, 100);
			final Rectangle fundo = new Rectangle(450, 250);
			
			//1
			ComboBox<String> cbCorCena = new ComboBox<>();
			ComboBox<String> cbCorRetangulo = new ComboBox<>();
			
			//2
			cbCorCena.getItems().addAll(cores);
			cbCorRetangulo.getItems().addAll(cores);
			opcoes.getChildren().addAll(cbCorCena, cbCorRetangulo);
			raiz.getChildren().addAll(fundo, retangulo, opcoes);
			
			final Scene cena = new Scene(raiz, 450, 250);
			
			primaryStage.setTitle("Uso de comboBox");
			primaryStage.setScene(cena);
			
			//3			
			cbCorCena.getSelectionModel().selectedItemProperty().addListener((valorObservado, valorAntigo, valorNovo) -> {
				fundo.setFill(Color.valueOf(valorNovo));
			});
			
			cbCorRetangulo.getSelectionModel().selectedItemProperty().addListener((valorObservado, valorAntigo, valorNovo) -> {
				retangulo.setFill(Color.valueOf(valorNovo));
			});
			
			cbCorCena.getSelectionModel().select(0);
			cbCorRetangulo.getSelectionModel().select(1);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
