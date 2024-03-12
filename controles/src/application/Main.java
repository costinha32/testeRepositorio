package application;
	
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox raiz = new VBox(10);
			raiz.setTranslateX(10);
			raiz.setTranslateY(20);
			Label lbltitulo = new Label("Pesquisa sobre Programa��o");
			lbltitulo.setUnderline(true); //1 Quando chama esse m�todo e enviar "true" ele ser� sublinhado
			
			final TextField txtNome = new TextField();
			HBox hbNome = new HBox(10); //2
			
			hbNome.getChildren().addAll(new Label("Nome"), txtNome);
			HBox hbSo = new HBox(20);
			ToggleButton tbLinux = new ToggleButton("Linux"); //3 Estamos informando o texto que ele ir� mostrar no bot�o, � um bot�o alternado, ou seja, apenas um pode ser selcionado
			tbLinux.setSelected(true);
			ToggleButton tbWindows = new ToggleButton("Windows");
			ToggleButton tbMac = new ToggleButton("Mac");
			
			final ToggleGroup tgSo = new ToggleGroup(); //4 "Togglegroup" agrupa objetos do tipo Toggle
			tgSo.getToggles().addAll(tbLinux, tbWindows, tbMac); //5 adicionamos quais but�es iriam para o grupo toggle	
			hbSo.getChildren().addAll(new Label("Sistema operacional utilizado"), tbLinux, tbWindows, tbMac);
			final ToggleGroup tgLinguagem = new ToggleGroup();
			HBox hbLinguagens = new HBox(20);
			
			RadioButton rbJava = new RadioButton("Java");//6 Mesma ideia do bot�o toggle, mas a principal diferen�a � na apar�ncia (� uma bolinha) e que um grupo n�o permite um bot�o n�o selecionado
			rbJava.setSelected(true);;
			RadioButton rbC = new RadioButton("C");
			RadioButton rbPython = new RadioButton("Python");
			tgLinguagem.getToggles().addAll(rbC, rbJava, rbPython);
			hbLinguagens.getChildren().addAll(new Label("Linguagem de programa��o pedileta: "), rbC, rbJava, rbPython);
			
			final CheckBox chkFrequencia = new CheckBox("Programa todo dia?"); //7
			final CheckBox chkGosto = new CheckBox("Gosta da program��o?");
			chkGosto.setAllowIndeterminate(true); //8 Habilitamos o terceiro estado das caixas de checagem, o estado inderterminado
			
			Date hoje = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			
			
			Button btnsubmeter = new Button("Submeter pesquisa"); 
			btnsubmeter.setOnAction(e ->{
				System.out.println("\t\tResultado da pesquisa para \"" + txtNome.getText() + "\"\n"); 
				ToggleButton tbSo = (ToggleButton) tgSo.getSelectedToggle(); //9 retorna o toggl e selecionado, se nada estivver selecionado, retorna "null"
				System.out.println("Sistema  Operacional Predileto: ");
				System.out.println(tbSo == null ? "N�o selecionado." : tbSo.getText());
				//Deve ter uma linguagem selecionada
				
				RadioButton rbLinguagens = (RadioButton) tgLinguagem.getSelectedToggle();
				System.out.println("Linguagem de programa��o: " + rbLinguagens.getText()); //10 o isSelected retorna um valor booleano para informar se essa caixa est� selecionada				
				System.out.println((chkFrequencia.isSelected() == true ? "p" : " N�o p")+ "rograma todo dia.");
				System.out.println("Gosta de programa��o: ");
				 if(chkGosto.isSelected()) {
					 System.out.println("Sim"); // O metodo isIndeterminate para sabermos se o estado dessa caixa � indeterminado.
					 
				 }else if (chkGosto.isIndeterminate()) {
					 System.out.println("N�o respondido.");
				 } else {
					 System.out.println("N�o.");
				 }
				 System.out.println("Data/Hora atual: " + sdf.format(hoje));
				 System.out.println("\n\n");
				 		
			});
			

			raiz.getChildren().addAll(lbltitulo, hbNome, hbSo, hbLinguagens, chkFrequencia, chkGosto, btnsubmeter);
			Scene cena = new Scene(raiz, 500, 500);
			primaryStage.setTitle("Pesquisa obre Programa��o");
			primaryStage.setScene(cena);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
