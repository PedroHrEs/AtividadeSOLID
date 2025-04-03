import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        ITaskPrinter printer = new ConsoleTaskPrinter();  // Ou FileTaskPrinter()

        Menu menu = new Menu(scanner, manager, printer);
        menu.run();
    }
}