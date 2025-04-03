import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private TaskManager manager;
    private ITaskPrinter printer;

    public Menu(Scanner scanner, TaskManager manager, ITaskPrinter printer) {
        this.scanner = scanner;
        this.manager = manager;
        this.printer = printer;
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Criar nova tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("4. Filtrar por prioridade");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            try {
                int opcao = Integer.parseInt(scanner.nextLine());

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
                        int index = Integer.parseInt(scanner.nextLine());
                        if (index >= 0 && index < manager.getAllTasks().size()) {
                            manager.getAllTasks().get(index).markAsDone();
                        } else {
                            System.out.println("Índice inválido!");
                        }
                        break;
                    case 4:
                        System.out.print("Prioridade para filtrar: ");
                        String filtro = scanner.nextLine();
                        printer.printTasks(manager.getFilteredTasks(new PriorityFilter(filtro)));
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        running = false;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Entrada inválida! Digite um número.");
            }
        }
    }
}

