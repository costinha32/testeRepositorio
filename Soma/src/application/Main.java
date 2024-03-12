
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
			primaryStage.setTitle("Somando 2 números - Feito por mim pra mim!");
			
			
			
			GridPane grid =  new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));
			
			Scene scene = new Scene(grid, 600, 600);
			primaryStage.setScene(scene);
			
			Text scenetitle = new Text("Calculadora");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);
			
			Label lblNum1 =  new Label("Número 1: ");
			grid.add(lblNum1, 0, 1);
			TextField txtNum1 = new TextField();
			grid.add(txtNum1, 1, 1);

			Label lblNum2 =  new Label("Número 2: ");
			grid.add(lblNum2, 0, 2);
			TextField txtNum2 = new TextField();
			grid.add(txtNum2, 1, 2);
			
			Button btnSomar = new Button("Somar");
			HBox caixaBtn = new HBox();
			caixaBtn.setAlignment(Pos.BOTTOM_LEFT);
			caixaBtn.getChildren().add(btnSomar);
			
			
			
			Button limpar = new Button("Limpar");
			caixaBtn.getChildren().add(limpar);
			grid.add(caixaBtn, 1, 4);
			
			Button subtrair = new Button("Diminuir");
			caixaBtn.getChildren().add(subtrair);
			
			Button multiplica = new Button("Multiplicar");
			HBox caixa = new HBox();
			caixa.setAlignment(Pos.BOTTOM_LEFT);
			caixa.getChildren().add(multiplica);
			
			Button divide = new Button("Dividir");
			caixa.getChildren().add(divide);
			grid.add(caixa, 1, 5);
			
			final Text resultado = new Text();
			grid.add(resultado, 1, 6);
			
			btnSomar.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Double num1 = Double.parseDouble(txtNum1.getText());
					Double num2 = Double.parseDouble(txtNum2.getText());
					
					num1 = num1 + num2;
					
					resultado.setFill(Color.FIREBRICK);
					resultado.setText("Total: " + num1);	
					
				}
			});
			limpar.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					txtNum1.clear();
					txtNum2.setText("");
					resultado.setText("");
					txtNum1.requestFocus();
					
				}
			});
			subtrair.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					Double num1 = Double.parseDouble(txtNum1.getText());
					Double num2 = Double.parseDouble(txtNum2.getText());
					
					num1 = num1 - num2;
					
					resultado.setFill(Color.BLACK);
					resultado.setText("Total: " + num1);
					
				}
			});
			multiplica.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Double num1 = Double.parseDouble(txtNum1.getText());
					Double num2 = Double.parseDouble(txtNum2.getText());
					
					num1 = num1 * num2;
					
					resultado.setFill(Color.BLACK);
					resultado.setText("Total: " + num1);
				}
			});
			divide.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Double num1 = Double.parseDouble(txtNum1.getText());
					Double num2 = Double.parseDouble(txtNum2.getText());
					
					num1 = num1 / num2;
					
					resultado.setFill(Color.BLACK);
					resultado.setText("Total: " + num1);
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
