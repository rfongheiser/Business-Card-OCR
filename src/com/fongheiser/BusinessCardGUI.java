package com.fongheiser;

import com.fongheiser.view.ContactViewController;
import com.fongheiser.view.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class BusinessCardGUI extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private RootLayoutController rootLayoutController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Business Card Parser");

        initRootLayout();
        showContactView();
    }

    /**
     * Initializes the root layout
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(BusinessCardGUI.class
                    .getResource("view/RootLayout.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            rootLayoutController = loader.getController();
            rootLayoutController.setStage(primaryStage);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the contact view inside the root layout.
     */
    public void showContactView() {
        try {
            // Load person overview
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(BusinessCardGUI.class.getResource("view/ContactView.fxml"));
            AnchorPane contactView = loader.load();

            // Set contact view into the center of root layout
            rootLayout.setCenter(contactView);
            ContactViewController controller = loader.getController();
            rootLayoutController.setContactViewController(controller);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
