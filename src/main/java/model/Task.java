package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task implements ITask {
    private String name;
    private Date date;
    private List<ITask> subTasks;
    private boolean taskCompleted = false;
    private ITask parentTask;

    public Task(){}

    public Task(String name, Date dueDate){
        this.name = name;
        this.date = dueDate;
    }

    public List<ITask> getSubTasks() { return subTasks; }

    public void addSubTask(ITask task) {
        if (subTasks == null){
            subTasks = new ArrayList<>();
        }
        subTasks.add(task);
        task.setParentTask(this);
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
        if (subTasks != null) {
            for (ITask t : subTasks) {
                if (!t.isTaskCompleted()) {
                    allCompleted = false;
                    break;
                }
            }
        }
        setTaskCompleted(allCompleted);
    }

    public void setParentTask(ITask task) {
        parentTask = task;
    }

    public ITask getParentTask() {
        return parentTask;
    }

    public void deleteParentTask() {
        parentTask.getSubTasks().remove(this);
        parentTask = null;
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
