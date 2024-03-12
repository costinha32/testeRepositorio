package application;

import java.awt.Desktop.Action;

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
			primaryStage.setTitle("Conversão");
			
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));
			
			Scene scene =  new Scene(grid, 600, 400);
			primaryStage.setScene(scene);
			
			Text scenetitle =  new Text("Convertendo graus Fahrenheit para graus Celsius");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);
			
			Label fahrenheit = new Label("Fahrenheit");
			grid.add(fahrenheit, 0, 1);
			
			TextField fahrenheit1 = new TextField();
			grid.add(fahrenheit1, 1, 1);
			
			
			Button converter = new Button("converter");
			HBox caixagraus =  new HBox(10);
			caixagraus.setAlignment(Pos.BOTTOM_RIGHT);
			caixagraus.getChildren().add(converter);
			
			Button limpar = new Button("Limpar");
			caixagraus.getChildren().add(limpar);
			grid.add(caixagraus, 1, 4);
			
			final Text resutado = new Text();
			grid.add(resutado, 1, 6);
			
			converter.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					Double temp1 = Double.parseDouble(fahrenheit1.getText());
					
					temp1 = (temp1 - 32) /1.8;
					
					resutado.setFill(Color.FIREBRICK);
					resutado.setText("Total: " + temp1);
					
					
				}
			});

			limpar.setOnAction(new EventHandler<ActionEvent>() {
				public void handle (ActionEvent e) {
					fahrenheit1.clear();
					fahrenheit1.requestFocus();
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
