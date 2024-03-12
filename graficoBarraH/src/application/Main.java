package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	final static String AUSTRIA = "Áustria";
	final static String BRASIL = "Brasil";
	final static String BOLIVIA = "Bolivia";
	final static String CHINA = "China";
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Relação de comércio exterior");
			final CategoryAxis yAxis =  new CategoryAxis();
			final NumberAxis xAxis =  new NumberAxis();
			final BarChart<Number, String> grafico = 
					new BarChart<>(xAxis,yAxis);
			grafico.setTitle("Resumo por país");
			xAxis.setLabel("Valor em vendas");
			xAxis.setTickLabelRotation(90);
			yAxis.setLabel("País");
			
			XYChart.Series series1 = new XYChart.Series();
			series1.setName("2003");
			series1.getData().add(new XYChart.Data(25601.34, Main.AUSTRIA ));
			series1.getData().add(new XYChart.Data(20148.34, Main.BRASIL ));
			series1.getData().add(new XYChart.Data(48512.34, Main.CHINA));
			series1.getData().add(new XYChart.Data(10456.34, Main.BOLIVIA ));
			
			XYChart.Series series2 = new XYChart.Series();
			series2.setName("2004");
			series2.getData().add(new XYChart.Data(78956.56, Main.AUSTRIA));
			series2.getData().add(new XYChart.Data(45621.56, Main.BRASIL));
			series2.getData().add(new XYChart.Data(25987.56, Main.CHINA));
			series2.getData().add(new XYChart.Data(12023.56, Main.BOLIVIA));
			
			
			XYChart.Series series3 = new XYChart.Series();
			series3.setName("2005");
			series3.getData().add(new XYChart.Data(45612.78, Main.AUSTRIA));
			series3.getData().add(new XYChart.Data(123654.78, Main.BRASIL));
			series3.getData().add(new XYChart.Data(23654.78, Main.CHINA));
			series3.getData().add(new XYChart.Data(12564.78, Main.BOLIVIA));
			
			XYChart.Series series4 = new XYChart.Series();
			series4.setName("2006");
			series4.getData().add(new XYChart.Data(98745.45, Main.AUSTRIA));
			series4.getData().add(new XYChart.Data(58963.45, Main.BRASIL));
			series4.getData().add(new XYChart.Data(36549.45, Main.CHINA));
			series4.getData().add(new XYChart.Data(12365.45, Main.BOLIVIA));
			
				
			Scene scene = new Scene(grafico,800,800);
			grafico.getData().addAll(series1, series2, series3, series4);
			
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
