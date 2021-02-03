package view;

import javafx.fxml.FXML;
import model.ITask;

import javax.swing.text.html.ListView;
import java.util.ArrayList;
import java.util.List;

public class GraphUI implements UI {
  List<ITask> mainTasks = new ArrayList<>();

  @FXML
  ListView dailyTasks;

  @FXML
  ListView normalTasks;

  @Override
  public void addMainTask(ITask task) {
    mainTasks.add(task);
  }

  @Override
  public List<ITask> getMainTasks() {
    return mainTasks;
  }

  @Override
  public void removeMainTask(ITask task) {
    mainTasks.remove(task);
  }
}
