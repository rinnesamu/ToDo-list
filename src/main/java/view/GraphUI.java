package view;

import controller.Controller;
import controller.IController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.ITask;
import javafx.scene.control.ListView;

//import javax.swing.text.html.ListView;
import java.util.ArrayList;
import java.util.List;

public class GraphUI implements UI {
  private int count = 1;
  IController controller = new Controller(this);

  @FXML
  ListView dailyTasks = new ListView();

  @FXML
  ListView normalTasks = new ListView();


  @Override
  public void addMainTask(final ITask task) {
    normalTasks.getItems().add(task);

    /*EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>(){
      @Override
      public void handle(MouseEvent event){
        controller.completeTask(task);
      }
    };
    button.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
    */
  }

  @Override
  public List<ITask> getMainTasks() {
    System.out.println(normalTasks.getItems());
    return normalTasks.getItems();
  }

  @Override
  public void removeMainTask(ITask task) {
    normalTasks.getItems().remove(task);
  }

  @FXML
  public void onClick() {
    controller.createNewTask("Test" + count, count, count, count);
    System.out.println("Working");
  }

  @FXML
  public void delete(){
    controller.removeAllCompleted();
  }

  @FXML
  public void get(){
    getMainTasks();
  }
}
