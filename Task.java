package taskManager;
import java.util.*;
public class Task { // no public using online compler
    private int taskId;
    private String taskName;
    private String description;
    private String dueDate;
    private String status;
   // constructor
    Task(int taskId, String taskName, String description, String dueDate, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    // Getters
    public int getTaskId() {
        return taskId;
    }
    public String getTaskName() {
        return taskName;
    }
    public String getDescription() {
        return description;
    }
    public String getDueDate() {
        return dueDate;
    }
    public String getStatus() {
        return status;
    }

    // Setters
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public static void viewTask(List<Task> taskList, int taskId) {
        for (Task t : taskList) {
            if (t.getTaskId() == taskId) {
                System.out.println("ID: " + t.taskId);
                System.out.println("Name: " + t.taskName);
                System.out.println("Description: " + t.description);
                System.out.println("Due Date: " + t.dueDate);
                System.out.println("Status: " + t.status);
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public static void viewDetails(List<Task> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("No task updated");
            return;
        }
        for (Task t : taskList) {
            System.out.println("ID: " + t.taskId);
            System.out.println("Name: " + t.taskName);
            System.out.println("Description: " + t.description);
            System.out.println("Due Date: " + t.dueDate);
            System.out.println("Status: " + t.status);
            System.out.println("-------------------");
        }
    }

    public static boolean deleteTask(List<Task> taskList, int taskId) {
        Iterator<Task> iterator = taskList.iterator();
        while (iterator.hasNext()) {
            Task t = iterator.next();
            if (t.getTaskId() == taskId) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public static void update(List<Task> taskList, int taskId, int field, Scanner sc) {
        for (Task t : taskList) {
            if (t.getTaskId() == taskId) {
                switch (field) {
                    case 1:
                        System.out.println("Enter new Name:");
                        String newName = sc.nextLine();
                        String oldName = t.getTaskName();
                        t.setTaskName(newName);
                        System.out.println("Successfully changed " + oldName + " to " + newName);
                        break;
                    case 2:
                        System.out.println("Enter new Description:");
                        String newDescription = sc.nextLine();
                        String oldDesc = t.getDescription();
                        t.setDescription(newDescription);
                        System.out.println("Successfully changed " + oldDesc + " to " + newDescription);
                        break;
                    case 3:
                        System.out.println("Enter new Due Date:");
                        String newDueDate = sc.nextLine();
                        String oldDueDate = t.getDueDate();
                        t.setDueDate(newDueDate);
                        System.out.println("Successfully changed " + oldDueDate + " to " + newDueDate);
                        break;
                    case 4:
                        System.out.println("1. Pending\n2. Partially Completed\n3. Completed");
                        System.out.println("Enter the status option:");
                        int opt = sc.nextInt();
                        sc.nextLine(); // consume newline
                        String oldStatus = t.getStatus();
                        if (opt == 1) {
                            t.setStatus("Pending");
                        } else if (opt == 2) {
                            t.setStatus("Partially Completed");
                        } else if (opt == 3) {
                            t.setStatus("Completed");
                        } else {
                            System.out.println("Invalid status option.");
                            return;
                        }
                        System.out.println("Successfully changed " + oldStatus + " to " + t.getStatus());
                        break;
                    default:
                        System.out.println("Invalid field option.");
                        break;
                }
                return;
            }
        }
        System.out.println("Task not found.");
    }
}
