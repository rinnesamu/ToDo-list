import utils.InputScanner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TextUI implements UI {
  final String ADD_ANS = "a";
  final String COMPLETE_ANS = "c";
  final String EXIT_ANS = "e";
  List<ITask> tasks = new ArrayList();
  IController controller = new Controller(this);

  public void showOptions() {
    String ans;
    do {
      showTasks();
      System.out.println("Enter " + ADD_ANS + " if you want to add a new task");
      System.out.println("Enter " + COMPLETE_ANS + " if you want to complete a task");
      System.out.println("Enter " + EXIT_ANS + " if you want to exit");
      ans = InputScanner.scanString();
      switch (ans) {
        case ADD_ANS:
          System.out.println("Give tasks name.");
          String name = InputScanner.scanString();
          System.out.println("Tasks Deadline. First give year:");
          int year = InputScanner.scanInt() - 1900;
          System.out.println("Now give month");
          int month = InputScanner.scanInt() - 1;
          System.out.println("And lastly day");
          int day = InputScanner.scanInt();
          controller.createNewTask(name, year, month, day);
          break;
        case COMPLETE_ANS:
          System.out.println("Which task do you want to mark completed?");
          int completed = InputScanner.scanInt();
          controller.completeTask(tasks.get(completed - 1));
          break;
        case EXIT_ANS:
          System.out.println("Good bye!");
          break;
        default:
          System.out.println("Invalid answer, try again");
          break;
      }
    } while(!ans.equals(EXIT_ANS));
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
