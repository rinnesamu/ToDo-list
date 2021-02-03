package controller;

import model.ITask;
import model.Task;
import view.UI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller implements IController{
  UI view;
  public Controller(UI view){
    this.view = view;
  }

  public void createNewTask(String name, int year, int month, int day) {
    Date date = new Date(year, month, day);
    ITask task = new Task(name, date);
    view.addMainTask(task);
  }

  @Override
  public void completeTask(ITask task) {
    task.completeTask();
  }

  @Override
  public void createNewTask(String name, int year, int month, int day, ITask parentTask) {
    Date date = new Date(year, month, day);
    ITask task = new Task(name, date);
    parentTask.addSubTask(task);
  }

  @Override
  public void removeAllCompleted() {
    List<ITask> tasks = view.getMainTasks();
    List<ITask> tasksToRemove = new ArrayList<>();
    System.out.println(tasks);
    for (ITask t : tasks){
      if (t.isTaskCompleted()){
        tasksToRemove.add(t);
      }
    }
    for (ITask task : tasksToRemove) {
      view.removeMainTask(task);
    }
  }

  @Override
  public void removeSubtask(ITask task) {
    task.deleteParentTask();
  }

}
