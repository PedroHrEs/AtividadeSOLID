import java.util.List;

public class DoneFilter implements TaskFilterStrategy {
    @Override
    public List<Task> filter(List<Task> tasks) {
        return tasks.stream().filter(Task::isDone).toList();
    }
}
