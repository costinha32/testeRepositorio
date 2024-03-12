package application.view;

import java.io.File;

import org.controlsfx.dialog.Dialogs;

import application.Main;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

public class RootLayoutController {
	 // Refer�ncia � aplica��o principal
    private Main main;

    /**
     * � chamado pela aplica��o principal para referenciar a si mesma.
     * 
     * @param mainApp
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * Cria uma agenda vazia.
     */
    @FXML
    private void handleNew() {
        main.getPersonData().clear();
        main.setPersonFilePath(null);
    }

    /**
     * Abre o FileChooser para permitir o usu�rio selecionar uma agenda
     * para carregar.
     */
    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        // Define um filtro de extens�o
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Mostra a janela de salvar arquivo
        File file = fileChooser.showOpenDialog(main.getPrimaryStage());

        if (file != null) {
            main.loadPersonDataFromFile(file);
        }
    }

    /**
     * Salva o arquivo para o arquivo de pessoa aberto atualmente. Se n�o houver
     * arquivo aberto, a janela "salvar como" � mostrada.
     */
    @FXML
    private void handleSave() {
        File personFile = main.getPersonFilePath();
        if (personFile != null) {
            main.savePersonDataToFile(personFile);
        } else {
            handleSaveAs();
        }
    }

    /**
     * Abre um FileChooser para permitir o usu�rio selecionar um arquivo
     * para salvar.
     */
    @FXML
    private void handleSaveAs() {
		FileChooser fileChooser = new FileChooser();

		// Define o filtro de extens�o
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Mostra a janela para salvar arquivo
		File file = fileChooser.showSaveDialog(main.getPrimaryStage());

		if (file != null) {
			// Certifica de que esta � a extens�o correta
			if (!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}
			main.savePersonDataToFile(file);
		}
	}

    /**
     * Abre uma janela Sobre.
     */
    @FXML
    private void handleAbout() {
		Dialogs.create()
	        .title("AddressApp")
	        .masthead("Sobre")
	        .message("Autor: Marco Jakob\nWebsite: http://code.makery.ch")
	        .showInformation();
    }

    /**
     * Fecha a aplica��o.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
