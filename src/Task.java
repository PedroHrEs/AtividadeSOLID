public class Task implements  Completable, Printable{
    private String title;
    private String priority;
    private boolean done;

    public Task(String title, String priority) {
        this.title = title;
        this.priority = priority;
        this.done = false;
    }

    public String getTitle() {
        return title;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public void markAsDone() {
        this.done = true;
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public void print() {
        System.out.println("[" + (done ? "X" : " ") + "] " + title + " (Prioridade: " + priority + ")");
    }
}
