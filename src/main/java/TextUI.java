import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TextUI implements UI {
  List<ITask> tasks = new ArrayList();
  Scanner scanner = new Scanner(System.in);
  IController controller = new Controller(this);

  public void showOptions() {
    String ans;
    do {
      showTasks();
      System.out.println("Enter a if you want to add a new task");
      System.out.println("Enter c if you want to complete a task");
      System.out.println("Enter e if you want to exit");
      ans = scanner.nextLine();
      switch (ans) {
        case "a":
          System.out.println("Give tasks name.");
          String name = scanner.nextLine();
          System.out.println("Tasks Deadline. First give year:");
          int year = scanner.nextInt() - 1900;
          System.out.println("Now give month");
          int month = scanner.nextInt() - 1;
          System.out.println("And lastly day");
          int day = scanner.nextInt();
          controller.createNewTask(name, year, month, day);
          break;
        case "c":
          System.out.println("Which task do you want to mark completed?");
          int completed = scanner.nextInt();
          controller.completeTask(tasks.get(completed - 1));
          break;
        case "e":
          System.out.println("Good bye!");
          break;
        default:
          System.out.println("Invalid answer, try again");
          break;
      }
    } while(!ans.equals("e"));

  }

  public void addTask(ITask task) {
    tasks.add(task);
  }

  public void showTasks() {
    System.out.println("Current tasks:");
    if(tasks.size() == 0){
      System.out.println("There is no tasks!");
    }else {
      for (int i = 0; i < tasks.size(); i++){
        System.out.println(i+1 + ". " + tasks.get(i));
      }
    }
    System.out.println("");
  }

  @Override
  public void completeTask(ITask task) {

  }

}
