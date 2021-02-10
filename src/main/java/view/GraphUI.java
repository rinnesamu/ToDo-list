package view;

import controller.Controller;
import controller.IController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ITask;

import java.util.List;

public class GraphUI implements UI {
  private int count = 1;
  IController controller = new Controller(this);

  @FXML
  TableView dailyTasksView = new TableView();

  @FXML
  TableView<ITask> normalTasksView = new TableView<>();

  @FXML
  TableColumn<ITask, String> dailyName;

  @FXML
  TableColumn<ITask, String> normalName = new TableColumn<>("Name");

  @FXML
  TableColumn<ITask, String> normalDue = new TableColumn<>("Name");

  ObservableList<ITask> normalTasks;


  @Override
  public void addMainTask(final ITask task) {
    normalTasks.add(task);
    //normalTasksView.setItems(normalTasks.getItems());

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
    System.out.println(normalTasks);
    return normalTasks;
  }

  @Override
  public void removeMainTask(ITask task) {
    normalTasks.remove(task);
  }

  @FXML
  public void onClick() {
    controller.createNewTask("Test" + count, count, count, count);
  }

  @FXML
  public void removeCompleted(){
    controller.removeAllCompleted();
  }

  @FXML
  public void getAllMainTasks(){
    getMainTasks();
  }

  @FXML
  public void initialize() {
    normalTasks = FXCollections.observableArrayList();
    normalName.setCellValueFactory(new PropertyValueFactory<ITask, String>("name"));
    normalDue.setCellValueFactory(new PropertyValueFactory<ITask, String>("date"));
    normalTasksView.setItems(normalTasks);
  }


}
