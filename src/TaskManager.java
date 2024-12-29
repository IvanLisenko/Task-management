import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public void addTask(String description ) {
        tasks.add(new Task(nextId++, description));
    }
    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    public void markTastAsCompleted(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setCompleted(true);
                break;
            }
        }
    }
    public void showAllTasks(){
        for(Task task : tasks) {
            System.out.println(task);
        }
    }

    public  void saveToFile(String filename) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for(Task task : tasks) {
                writer.write(task.getId() + "," + task.getDescription() + "," + task.isCompleted() + "\n");
            }
        }
    }
    public void loadFromFile(String filename) throws IOException {
        tasks.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Task task = new Task(Integer.parseInt(parts[0]),parts[1]);
                task.setCompleted(Boolean.parseBoolean(parts[2]));
                tasks.add(task);
            }
        }
    }

}

