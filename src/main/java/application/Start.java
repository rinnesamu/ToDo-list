package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Start extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  private Stage primaryStage;
  private GridPane grid;
  FXMLLoader loader;

  @Override
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    this.primaryStage.setTitle("ToDo list");
    startApplication();
  }

  private void startApplication(){
    try {
      loader = new FXMLLoader();
      loader.setLocation(getClass().getClassLoader().getResource("UI.fxml"));
      grid = (GridPane) loader.load();

      Scene scene = new Scene(grid);
      primaryStage.setScene(scene);
      /*primaryStage.setHeight(800.0);
      primaryStage.setWidth(1200.0);

      primaryStage.centerOnScreen();*/
      primaryStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
