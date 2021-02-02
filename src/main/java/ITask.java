import java.util.Date;
import java.util.List;

public interface ITask {
  List<ITask> getSubTasks();
  void addSubTask(ITask task);
  String getName();
  void setName(String name);
  Date getDate();
  void setDate(Date date);
  boolean isTaskCompleted();
  void setTaskCompleted(boolean status);
  void completeTask();
  void setParentTask(ITask task);
  ITask getParentTask();
  void deleteParentTask();

}
