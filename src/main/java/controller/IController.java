package controller;

import model.ITask;

public interface IController {
  void createNewTask(String name, int year, int month, int day);
  void completeTask(ITask task);
  void createNewTask(String name, int year, int month, int day, ITask parentTask);
  void removeAllCompleted();
  void removeSubtask(ITask task);
}
