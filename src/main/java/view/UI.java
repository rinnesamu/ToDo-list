package view;

import model.ITask;

import java.util.List;

public interface UI {
  void showOptions();
  void addMainTask(ITask task);
  void showTasks();
  List<ITask> getMainTasks();
  void removeMainTask(ITask task);

}
