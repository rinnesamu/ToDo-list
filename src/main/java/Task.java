import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task implements ITask {
    private String name;
    private Date date;

    private List<ITask> subTasks = new ArrayList<ITask>();
    private boolean taskCompleted = false;

    public Task(){}

    public Task(String name, Date dueDate){
        this.name = name;
        this.date = dueDate;
    }

    public List<ITask> getSubTasks() {
        return subTasks;
    }

    public void addTask(ITask task) {
        subTasks.add(task);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskCompleted(boolean status) {
        this.taskCompleted = status;
    }

    public void completeTask() {
        boolean allCompleted = true;
        for (ITask t : subTasks) {
            if (!t.isTaskCompleted()){
                allCompleted = false;
                break;
            }
        }
        setTaskCompleted(allCompleted);
    }

    @Override
    public String toString(){
        String returnString;
        if (this.taskCompleted){
            returnString = this.name + " " + this.date.toString() + " Completed!" ;
        }else{
            returnString = this.name + " " + this.date.toString();
        }
        return returnString;
    }


}
