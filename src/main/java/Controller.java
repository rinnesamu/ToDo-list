import java.util.Date;

public class Controller implements IController{
  UI view;
  public Controller(UI view){
    this.view = view;
  }

  public void createNewTask(String name, int year, int month, int day) {
    Date date = new Date(year, month, day);
    ITask task = new Task(name, date);
    view.addTask(task);
  }
}
