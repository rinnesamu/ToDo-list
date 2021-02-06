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
import javafx.scene.control.ListView;
import model.Task;

import java.util.Date;
import java.util.List;

public class GraphUI implements UI {
  private int count = 1;
  IController controller = new Controller(this);

  @FXML
  ListView dailyTasks = new ListView();

  @FXML
  ListView normalTasks = new ListView();

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

  ObservableList<ITask> test;


  @Override
  public void addMainTask(final ITask task) {
    normalTasks.getItems().add(task);
    test.add(task);
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
    test = FXCollections.observableArrayList();
    normalName.setCellValueFactory(new PropertyValueFactory<ITask, String>("name"));
    normalDue.setCellValueFactory(new PropertyValueFactory<ITask, String>("date"));
    normalTasksView.setItems(test);
    //normalTasksView.getColumns().add(normalName);
  }


}
