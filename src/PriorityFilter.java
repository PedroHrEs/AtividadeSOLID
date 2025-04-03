import java.util.List;

public class PriorityFilter implements TaskFilterStrategy{
    private String priority;

    public PriorityFilter(String priority) {
        this.priority = priority;
    }

    @Override
    public List<Task> filter(List<Task> tasks) {
        return tasks.stream().filter(t -> t.getPriority().equalsIgnoreCase(priority)).toList();
    }
}
