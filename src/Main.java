import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        ITaskPrinter printer = new ConsoleTaskPrinter();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Criar nova tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("4. Filtrar por prioridade");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir \n

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Prioridade (Alta, Média, Baixa): ");
                    String prioridade = scanner.nextLine();
                    manager.addTask(new Task(titulo, prioridade));
                    break;
                case 2:
                    printer.printTasks(manager.getAllTasks());
                    break;
                case 3:
                    printer.printTasks(manager.getAllTasks());
                    System.out.print("Número da tarefa para marcar como concluída: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < manager.getAllTasks().size()) {
                        manager.getAllTasks().get(index).markAsDone();
                    } else {
                        System.out.println("Índice inválido!");
                    }
                    break;
                case 4:
                    System.out.print("Prioridade para filtrar: ");
                    String filtro = scanner.nextLine();
                    printer.printTasks(manager.filterByPriority(filtro));
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}