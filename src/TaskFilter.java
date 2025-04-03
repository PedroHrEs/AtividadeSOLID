import java.util.List;

public class TaskFilter {
    public List<Task> filterByPriority(List<Task> tasks, String priority) {
        return tasks.stream()
                .filter(t -> t.getPriority().equalsIgnoreCase(priority))
                .toList();
    }
}
