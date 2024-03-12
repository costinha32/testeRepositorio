package application;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Calculando a área de um quadrado");
			GridPane area = new GridPane();
			area.setAlignment(Pos.CENTER);
			area.setHgap(10);
			area.setVgap(10);
			area.setPadding(new Insets(25, 25, 25, 25));
			
			Scene scene = new Scene(area, 400, 400);
			primaryStage.setScene(scene);
			
			Text scenetitle = new Text("Calculando area do quadrado");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			area.add(scenetitle, 0, 0, 2, 1);
			
			Label lado1 = new Label("Lado 1: ");
			area.add(lado1, 0, 1);
			
			TextField txtlado1 = new TextField();
			area.add(txtlado1, 1, 1);
			
			Label lado2 = new Label("Lado 2: ");
			area.add(lado2, 0, 2);
			
			TextField txtlado2 = new TextField();
			area.add(txtlado2, 1, 2);
			
			Button calcular = new Button("Igual");
			HBox caixaqdra = new HBox(10);
			caixaqdra.setAlignment(Pos.BOTTOM_CENTER);
			caixaqdra.getChildren().add(calcular);
			area.add(caixaqdra, 1, 4);
			
			final Text resultado = new Text();
			area.add(resultado, 1, 6);
			
			calcular.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					Double l1 = Double.parseDouble(txtlado1.getText());
					Double l2 = Double.parseDouble(txtlado2.getText());
					
					l1 = l1 * l2;
					
					resultado.setFill(Color.FIREBRICK);
					resultado.setText("Total: " + l1);
					
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
