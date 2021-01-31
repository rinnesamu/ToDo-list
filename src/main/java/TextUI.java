import utils.InputScanner;

import java.util.*;

public class TextUI implements UI {
  final String ADD_ANS = "a";
  final String COMPLETE_ANS = "c";
  final String EXIT_ANS = "e";
  final String ADD_SUB_ANS = "s";

  List<ITask> mainTasks = new ArrayList();
  IController controller = new Controller(this);

  public void showOptions() {
    String ans;
    do {
      showTasks();
      System.out.println("Enter " + ADD_ANS + " if you want to add a new task");
      System.out.println("Enter " + COMPLETE_ANS +
        " if you want to complete a task");
      System.out.println("Enter " + ADD_SUB_ANS +
        " if you want to add subtask to existing task");
      System.out.println("Enter " + EXIT_ANS + " if you want to exit");
      ans = InputScanner.scanString().toLowerCase();
      switch (ans) {
        case ADD_ANS:
          List<Object> taskInformation = askTaskInformation();
          controller.createNewTask(
            (String)taskInformation.get(0),
            (int)taskInformation.get(1),
            (int)taskInformation.get(2),
            (int)taskInformation.get(3));
          break;
        case COMPLETE_ANS:
          System.out.println("Which task do you want to mark completed?");
          int completed = InputScanner.scanInt();
          controller.completeTask(mainTasks.get(completed - 1));
          break;
        case ADD_SUB_ANS:
          if (mainTasks.size() > 0) {
            taskInformation = askTaskInformation();
            System.out.println("Which task is parent task?");
            ITask parent =
              mainTasks.get(InputScanner.scanIntMinMax(1, mainTasks.size()) - 1);
            controller.createNewTask(
              (String) taskInformation.get(0),
              (int) taskInformation.get(1),
              (int) taskInformation.get(2),
              (int) taskInformation.get(3),
              parent);
          }else{
            System.out.println(
              "You can't add subtask because you don't have tasks");
          }
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
    mainTasks.add(task);
  }

  public void showTasks() {
    System.out.println("Current tasks:");
    if(mainTasks.size() == 0){
      System.out.println("There is no tasks!");
    }else {
      for (int i = 0; i < mainTasks.size(); i++){
        System.out.println(i+1 + ". " + mainTasks.get(i));
      }
    }
    System.out.println("");
  }

  private List<Object> askTaskInformation(){
    List<Object> returnList = new ArrayList<>();
    System.out.println("Give tasks name.");
    returnList.add(InputScanner.scanString());
    System.out.println("Tasks Deadline. First give year:");
    returnList.add(InputScanner.scanInt() - 1900);
    System.out.println("Now give month");
    returnList.add(InputScanner.scanInt() - 1);
    System.out.println("And lastly day");
    returnList.add(InputScanner.scanInt());
    return returnList;
  }
}
