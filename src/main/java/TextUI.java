import utils.InputScanner;

import java.util.*;

public class TextUI implements UI {
  final String ADD_ANS = "a";
  final String COMPLETE_ANS = "c";
  final String EXIT_ANS = "e";
  final String ADD_SUB_ANS = "s";
  final String REMOVE_TASK = "r";
  final String REMOVE_COMP = "d";

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
      System.out.println("Enter " + REMOVE_TASK + " if you want to remove task");
      System.out.println("Enter " + REMOVE_COMP +
        " if you want to remove all completed tasks");
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
          int completed = InputScanner.scanIntMinMax(1, mainTasks.size());
          controller.completeTask(mainTasks.get(completed - 1));
          break;
        case ADD_SUB_ANS:
          if (checkIfTasksExist()) {
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
          }
          break;
        case REMOVE_TASK:
          System.out.println("What task you want to remove?");
          if(checkIfTasksExist()) {
            removeMainTask(
              mainTasks.get(InputScanner.scanIntMinMax(1, mainTasks.size()) - 1));
          }
          break;
        case REMOVE_COMP:
          controller.removeAllCompleted();
          break;
        case EXIT_ANS:
          System.out.println("Good bye!");
          break;
        case "q":
          testFunction();
          break;
        default:
          System.out.println("Invalid answer, try again");
          break;
      }
    } while(!ans.equals(EXIT_ANS));
  }

  public void addMainTask(ITask task) {
    mainTasks.add(task);
  }

  public void showTasks() {
    System.out.println("Current tasks:");
    if(mainTasks.size() == 0){
      System.out.println("There is no tasks!");
    }else {
      for (int i = 0; i < mainTasks.size(); i++){
        System.out.println(i+1 + ". " + mainTasks.get(i));
        for (int j = 0; j < mainTasks.get(i).getSubTasks().size(); j++){
          System.out.println("  " + (+i+1) + "." + (+j+1) + " " +
            mainTasks.get(i).getSubTasks().get(j));
        }
      }
    }
    System.out.println("");
  }

  @Override
  public List<ITask> getMainTasks() {
    return mainTasks;
  }

  @Override
  public void removeMainTask(ITask task) {
    mainTasks.remove(task);
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

  private boolean checkIfTasksExist(){
    if (mainTasks.size() == 0){
      System.out.println(
        "Cant execute this operation, because there is no tasks!");
        return false;
    }
    return true;
  }

  private void testFunction(){
    controller.createNewTask("Test1", 2020, 1, 1);
    controller.createNewTask("Test2", 2020, 1, 1);
    controller.createNewTask("Test3", 2020, 1, 1);
    controller.createNewTask("Test4", 2020, 1, 1);
    controller.createNewTask("Test5", 2020, 1, 1);
    controller.createNewTask("Test6", 2020, 1, 1, mainTasks.get(2));
    controller.createNewTask("Test7", 2020, 1, 1, mainTasks.get(2));
    controller.createNewTask("Test8", 2020, 1, 1, mainTasks.get(4));
  }
}
