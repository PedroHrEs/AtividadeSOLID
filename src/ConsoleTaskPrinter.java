import java.util.List;

public class ConsoleTaskPrinter implements ITaskPrinter {

    @Override
    public void printTasks(List<Task> tasks) {
        for (Task t : tasks) {
            t.print();
        }
    }

}
