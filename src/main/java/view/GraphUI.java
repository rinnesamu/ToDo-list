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
  TableView<Task> normalTasksView = new TableView<>();

  @FXML
  TableColumn<ITask, String> dailyName;

  @FXML
  TableColumn<Task, String> normalName = new TableColumn<>("Testiasd");


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
  public void removeCompleted(){
    controller.removeAllCompleted();
  }

  @FXML
  public void getAllMainTasks(){
    getMainTasks();
  }

  @FXML
  public void testMethod(){
    System.out.println(normalTasksView.getColumns());
    System.out.println(normalTasksView.getItems());
    System.out.println(normalName.getCellData(0));
  }

  @FXML
  public void initialize() {
    //TODO find out why table contents are not shown.
    normalName.setCellValueFactory(new PropertyValueFactory<Task, String>("name"));
    final ObservableList<Task> test = FXCollections.observableArrayList(
      new Task("Test", new Date(1,1,1)),
      new Task("Test2", new Date(1,1,1))
    );
    normalTasksView.setItems(test);
    normalTasksView.getColumns().add(normalName);
    System.out.println(normalTasksView.getColumns());
    System.out.println(normalTasksView.getItems());
    System.out.println(normalName.getCellData(0));
  }


}
