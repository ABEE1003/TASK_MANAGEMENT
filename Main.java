public class Main {
    public static void main(String[] args) {
        List<Task> taskList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int id = 1;
        boolean valid = true;

        while (valid) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. View All Tasks");
            System.out.println("5. View Specific Task");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Enter Task Name:");
                    String taskName = sc.nextLine();
                    System.out.println("Enter Description:");
                    String description = sc.nextLine();
                    System.out.println("Enter Due Date:");
                    String dueDate = sc.nextLine();
                    System.out.println("Enter Status:");
                    String status = sc.nextLine();
                    taskList.add(new Task(id++, taskName, description, dueDate, status));
                    break;
                case 2:
                    if (taskList.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.print("Enter Task ID to update: ");
                        int taskId = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Fields: 1. Name 2. Description 3. Due Date 4. Status");
                        System.out.print("Enter field number to update: ");
                        int field = sc.nextInt();
                        sc.nextLine();
                        Task.update(taskList, taskId, field, sc);
                    }
                    break;
                case 3:
                    if (taskList.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.print("Enter Task ID to delete: ");
                        int taskId = sc.nextInt();
                        sc.nextLine();
                        if (Task.deleteTask(taskList, taskId)) {
                            System.out.println("Task deleted successfully.");
                        } else {
                            System.out.println("Task not found.");
                        }
                    }
                    break;
                case 4:
                    Task.viewDetails(taskList);
                    break;
                case 5:
                    System.out.print("Enter Task ID to view: ");
                    int taskId = sc.nextInt();
                    sc.nextLine();
                    Task.viewTask(taskList, taskId);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    valid = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
    }
}
