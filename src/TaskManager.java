import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public List<Task> getFilteredTasks(TaskFilterStrategy filterStrategy) {
        return filterStrategy.filter(tasks);
    }

}
