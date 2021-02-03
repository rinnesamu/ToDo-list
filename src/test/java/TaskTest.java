import model.ITask;
import model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
  ITask task;
  static final String NAME = "Test name";
  static final Date DATE = new Date(1992, 1, 30);

  @BeforeEach
  void init(){
    task = new Task();
  }

  @Test
  void getSubTasks() {
    assertEquals(0, task.getSubTasks().size(),
      "Wrong amount of subtasks.");
    task.addSubTask(new Task());
    assertEquals(1, task.getSubTasks().size(),
      "Wrong amount of subtasks, getting subtask failed.");
  }

  @Test
  void addSubTask() {
    assertEquals(0, task.getSubTasks().size(),
      "Wrong amount of subtasks.");
    task.addSubTask(new Task());
    assertEquals(1, task.getSubTasks().size(),
      "Wrong amount of subtasks, adding subtask failed.");
  }

  @Test
  void getName() {
    task.setName(NAME);
    assertEquals(NAME, task.getName(), "Getting name failed");
  }

  @Test
  void setName() {
    task.setName(NAME);
    assertEquals(NAME, task.getName(), "Setting name failed");
  }

  @Test
  void getDate() {
    task.setDate(DATE);
    assertEquals(DATE, task.getDate(), "Getting date failed");
  }

  @Test
  void setDate() {
    task.setDate(DATE);
    assertEquals(DATE, task.getDate(), "Getting date failed");
  }

  @Test
  void isTaskCompleted() {
    assertFalse(task.isTaskCompleted(), "Getting isCompleted failed");
  }

  @Test
  void setTaskCompleted() {
    assertFalse(task.isTaskCompleted(), "Getting isCompleted failed");
    task.setTaskCompleted(true);
    assertTrue(task.isTaskCompleted(), "Setting isCompleted failed");
    task.setTaskCompleted(false);
    assertFalse(task.isTaskCompleted(), "Setting isCompleted failed");
  }

  @Test
  void completeTask() {
    assertFalse(task.isTaskCompleted(), "Getting isCompleted failed");
    task.completeTask();
    assertTrue(task.isTaskCompleted(), "completeTask failed");

    ITask newTask = new Task();
    ITask secondNewTask = new Task();
    newTask.addSubTask(secondNewTask);
    newTask.completeTask();
    assertFalse(newTask.isTaskCompleted(),
      "Model.Task was completed too early");
    secondNewTask.completeTask();
    newTask.completeTask();
    assertTrue(newTask.isTaskCompleted(),
      "completeTask with subtask failed");
  }

  @Test
  void setParentTask(){
    Task newTask = new Task();
    assertNull(newTask.getParentTask(), "Parent task should be null");
    task.addSubTask(newTask);
    assertEquals(task, newTask.getParentTask(),
      "Couldn't find parentTask");
  }

  @Test
  void deleteParentTask(){
    Task newTask = new Task();
    task.addSubTask(newTask);
    assertEquals(task, newTask.getParentTask(),
      "Couldn't find parentTask");
    assertEquals(1, task.getSubTasks().size(),
      "Model.Task wasn't added to ParentTasks subtasks");
    newTask.deleteParentTask();
    assertEquals(0, task.getSubTasks().size(),
      "Model.Task wasn't removed from ParentTasks subtasks");
    assertEquals(null, newTask.getParentTask(),
      "Still found ParentTask");
  }
}