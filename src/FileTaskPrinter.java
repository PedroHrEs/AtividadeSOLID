import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileTaskPrinter implements ITaskPrinter {
    @Override
    public void printTasks(List<Task> tasks) {
        try (FileWriter writer = new FileWriter("tasks.txt")) {
            for (Task task : tasks) {
                writer.write(task.getTitle() + " [" + task.getPriority() + "] - " +
                        (task.isDone() ? "Concluída" : "Pendente") + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo.");
        }
    }
}
