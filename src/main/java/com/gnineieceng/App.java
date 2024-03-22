package com.gnineieceng;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/gnineieceng/view/InventorEaseLayout.fxml")));

        Scene scene = new Scene(root);

        primaryStage.setTitle("InventorEase");
        primaryStage.getIcons().add(new Image(App.class.getResourceAsStream("/com/gnineieceng/view/icons/iconInventorEase.png")));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}