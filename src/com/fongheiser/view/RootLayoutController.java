package com.fongheiser.view;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 */
public class RootLayoutController {

    private final FileChooser fileChooser = new FileChooser();
    private ContactViewController contactViewController;
    private Stage stage;

    /**
     * Allows the controller to have access to the app's stage
     * @param stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Allows the root layout to have access to the contactViewController
     * @param controller
     */
    public void setContactViewController(ContactViewController controller) {
        contactViewController = controller;
    }

    /**
     * Allows the user to select a txt file and parse it
     */
    @FXML
    private void handleAddCard() {
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text File", "*.txt")
        );
        File file = fileChooser.showOpenDialog(stage);
        String document = "";
        if (file != null) {
            try (Stream<String> stream = Files.lines(Paths.get(file.getPath()))) {

                for(String string : stream.toArray(String[]::new)) {
                    document +=  (string + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            contactViewController.setInputTextArea(document);
        }
    }

    /**
     * Closes the application
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}