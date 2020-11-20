import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<TaskItem> itemList;

    public TaskList(){this.itemList = new ArrayList<>();}

    public String view(){
        System.out.println("Current Tasks");
        System.out.println("-------------");
        System.out.println();

        if(itemList.size() == 0){
            return "No items in list";
        }

        String list = "";

        for(int i = 0; i < itemList.size(); i++){
            if(itemList.get(i).isCompleted()){
                list += i + ") *** " + itemList.get(i).toString() + "\n";
            }
            else {
                list += i + ") " + itemList.get(i).toString() + "\n";
            }
        }

        return list;
    }

    public String viewIncompleteTasks(){
        System.out.println("Incomplete Tasks");
        System.out.println("-------------");
        System.out.println();

        String incompleteList = "";
        int counter = 0;

        for(int i = 0; i < itemList.size(); i++){
            if(!(itemList.get(i).isCompleted())){
                incompleteList += i + ") " + itemList.get(i).toString() + "\n";
                counter++;
            }
        }

        if(counter == 0){
            return "You have no incomplete tasks.";
        }

        return incompleteList;
    }

    public String viewCompleteTasks(){
        System.out.println("Completed Tasks");
        System.out.println("-------------");
        System.out.println();

        String completedList = "";
        int counter = 0;

        for(int i = 0; i < itemList.size(); i++){
            if(itemList.get(i).isCompleted()){
                completedList += i + ") *** " + itemList.get(i).toString() + "\n";
                counter++;
            }
        }

        if(counter == 0){
            return "You have no complete tasks.";
        }

        return completedList;
    }

    public void add(TaskItem task){
        itemList.add(task);
    }

    public void set(TaskItem task, int index){
        itemList.set(index, task);
    }

    public void remove(int index){
        itemList.remove(index);
    }

    public int size(){
        return itemList.size();
    }

    public TaskItem get(int index){
        return itemList.get(index);
    }

    public void saveFile(String fileName){

        File savedFile = new File(fileName);

        try{
            FileWriter taskWriter = new FileWriter(savedFile);
            taskWriter.write(itemList.size() + "\n");
            for(int i = 0; i < itemList.size(); i++){
                if(itemList.get(i).isCompleted()){
                    taskWriter.write("true\n" + itemList.get(i).toStringFile() + "\n");
                }
                else {
                    taskWriter.write("false\n" + itemList.get(i).toStringFile() + "\n");
                }
            }

            taskWriter.close();
            System.out.println("task list has been saved.");
        }
        catch(IOException e){
            System.out.println("A file error occured.\nCould not save task list.");
        }
    }

}
