import java.util.Date;

public class TaskItem {

    private String name;
    private String dueDate;
    private String description;
    private boolean isCompleted;

    public TaskItem(String inputName, String inputDueDate, String inputDescription) {
        this.name = inputName;
        this.dueDate = inputDueDate;
        this.description = inputDescription;
        this.isCompleted = false;

    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void unsetCompleted(){
        this.isCompleted = false;
    }
    public void setCompleted() {
        this.isCompleted = true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "[" + dueDate + "] " + name + ": " + description;
    }
}
