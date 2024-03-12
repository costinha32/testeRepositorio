package application;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import application.model.Person;
import application.view.PersonEditDialogController;
import application.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	private ObservableList<Person> personData = FXCollections.observableArrayList();
	
	public Main() {
		personData.add(new Person("Hans", "Muster"));
		personData.add(new Person("Ruth", "Mueller"));
		personData.add(new Person("Heinz", "Kurz"));
		personData.add(new Person("Cornelia", "Meier"));
		personData.add(new Person("Werner", "Meyer"));
		personData.add(new Person("Lydia", "Kunz"));
		personData.add(new Person("Anna", "Best"));
		personData.add(new Person("Stefan", "Meier"));
		personData.add(new Person("Martin", "Mueller"));
	}
	
	public ObservableList<Person> getPersonData() {
		return personData;
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");
		
		this.primaryStage.getIcons().add(new Image("file:resource/images/background.jpeg"));
		
		initRootLayout();

		showPersonOverview();
		
	}
	public void initRootLayout() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
		
            primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void showPersonOverview() {
		try {

			 FXMLLoader loader = new FXMLLoader();
	         loader.setLocation(Main.class.getResource("view/PersonOverview.fxml"));
	         AnchorPane personOverview = (AnchorPane) loader.load();
		
	        rootLayout.setCenter(personOverview);
	        
	        PersonOverviewController controller = loader.getController();
	        controller.setMain(this);
	   
		} catch (IOException e) {
	        e.printStackTrace();
		}
		
	}
	public boolean showPersonEditDialog(Person person){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/PersonEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();
	        
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Person");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);
	        
	        PersonEditDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setPerson(person);
	        
	        dialogStage.showAndWait();

	        return controller.isOkClicked();

	        
			
		} catch (IOException e) {
			
		
			e.printStackTrace();
	        return false;
		} 
		
	}
	public File getPersonFilePath() {
	    Preferences prefs = Preferences.userNodeForPackage(Main.class);
	    String filePath = prefs.get("filePath", null);
	    if (filePath != null) {
	        return new File(filePath);
	    } else {
	        return null;
	    }
	}

	public Stage getPrimaryStage() {
		return primaryStage;



}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
