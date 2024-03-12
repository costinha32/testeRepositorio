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
			final CategoryAxis xAxis =  new CategoryAxis();
			final NumberAxis yAxis =  new NumberAxis();
			final BarChart<String, Number> grafico =  new BarChart<String, Number>(xAxis, yAxis);
			grafico.setTitle("Resumo por país");
			xAxis.setLabel("País");
			yAxis.setLabel("valor em vendas");
			
			XYChart.Series series1 = new XYChart.Series();
			series1.setName("2003");
			series1.getData().add(new XYChart.Data(Main.AUSTRIA, 25601.34));
			series1.getData().add(new XYChart.Data(Main.BRASIL, 20148.34));
			series1.getData().add(new XYChart.Data(Main.CHINA, 48512.34));
			series1.getData().add(new XYChart.Data(Main.BOLIVIA, 10456.34));
			
			XYChart.Series series2 = new XYChart.Series();
			series2.setName("2004");
			series2.getData().add(new XYChart.Data(Main.AUSTRIA, 78956.56));
			series2.getData().add(new XYChart.Data(Main.BRASIL, 45621.56));
			series2.getData().add(new XYChart.Data(Main.CHINA, 25987.56));
			series2.getData().add(new XYChart.Data(Main.BOLIVIA, 12023.56));
			
			
			XYChart.Series series3 = new XYChart.Series();
			series3.setName("2005");
			series3.getData().add(new XYChart.Data(Main.AUSTRIA, 45612.78));
			series3.getData().add(new XYChart.Data(Main.BRASIL, 123654.78));
			series3.getData().add(new XYChart.Data(Main.CHINA, 23654.78));
			series3.getData().add(new XYChart.Data(Main.BOLIVIA, 12564.78));
			
			XYChart.Series series4 = new XYChart.Series();
			series4.setName("2006");
			series4.getData().add(new XYChart.Data(Main.AUSTRIA, 98745.45));
			series4.getData().add(new XYChart.Data(Main.BRASIL, 58963.45));
			series4.getData().add(new XYChart.Data(Main.CHINA, 36549.45));
			series4.getData().add(new XYChart.Data(Main.BOLIVIA, 12365.45));
			
				
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
