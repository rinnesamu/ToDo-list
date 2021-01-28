import java.util.Date;
import java.util.List;

public interface ITask {
  List<ITask> getSubTasks();
  void addTask(ITask task);
  String getName();
  void setName(String name);
  Date getDate();
  void setDate(Date date);
  boolean isTaskCompleted();
  void setTaskCompleted(boolean status);
  void completeTask();

}
