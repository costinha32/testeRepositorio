package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;


public class Main extends Application {
	
	public static final int GRAFICO_LARGURA = 500;
	public static final int GRAFICO_ALTURA = 500;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene =  new Scene(new Group());
			primaryStage.setTitle("Vendas");
			primaryStage.setWidth(Main.GRAFICO_LARGURA);
			primaryStage.setHeight(Main.GRAFICO_ALTURA);
			
			
			//dados do gráfico
			ObservableList<PieChart.Data> dadosGrafico = FXCollections.observableArrayList(
					new PieChart.Data("Trimestre 1", 13), 
					new PieChart.Data("Trimestre 2", 25),
					new PieChart.Data("Trimestre 3", 10), 
					new PieChart.Data("Trimestre 4", 22));
			
			//gráfico
			final PieChart grafico =  new PieChart(dadosGrafico);
			grafico.setTitle("Lucros por trimesrte");
			
			((Group)scene.getRoot()).getChildren().add(grafico);
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
