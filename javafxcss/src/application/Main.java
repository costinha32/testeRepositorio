package application;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
			primaryStage.setTitle("Javfx CSS em ação");

			GridPane grid = new GridPane();

			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			Scene scene = new Scene(grid, 400, 375);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);

			Text sceneTitle = new Text("Bem-vindo");
			sceneTitle.setId("bemvindo-texto");
			sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(sceneTitle, 0, 0, 2, 1);
			
			Label userName = new Label("Login");
			grid.add(userName, 0, 1);
			
			TextField userTextField = new TextField();
			userTextField.setId("espacobranco");
			grid.add(userTextField, 1, 1);
			
			
			Label pw = new Label("Senha");
			grid.add(pw, 0, 2);
			
			PasswordField pwBox = new PasswordField();
			pwBox.setId("espacosenha");
			grid.add(pwBox, 1, 2);
			
			Button btn = new Button("Acessar");
			HBox hbtn = new HBox(10);
			hbtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbtn.getChildren().add(btn);
			
			Button btnLimpar = new Button("Limpar");
			hbtn.getChildren().add(btnLimpar);
			grid.add(hbtn, 1, 4);
			
			
			final Text actionTarget = new Text();
			grid.add(actionTarget, 1, 6);
			actionTarget.setId("acaobotao");
			
			btn.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					actionTarget.setFill(Color.FIREBRICK);
					actionTarget.setText("Botao pressionado!!!");
					
				}
			});
			btnLimpar.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					userTextField.clear();
					pwBox.clear();					
					userTextField.requestFocus();
					actionTarget.setText("");
					
				}
			});
			
			

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
