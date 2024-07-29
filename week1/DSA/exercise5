//Exercise 5: Task Management System
class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
    }
}

class TaskNode {
    Task task;
    TaskNode next;

    TaskNode(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskList {
    private TaskNode head;

    public TaskList() {
        this.head = null;
    }

    public void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        TaskNode newNode = new TaskNode(newTask);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(int taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            return;
        }
        if (head.task.taskId == taskId) {
            head = head.next;
            return;
        }
        TaskNode current = head;
        while (current.next != null) {
            if (current.next.task.taskId == taskId) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void traverseTasks() {
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        taskList.addTask(1, "Task 1", "Pending");
        taskList.addTask(2, "Task 2", "Completed");
        taskList.addTask(3, "Task 3", "In Progress");

        System.out.println("Traversing tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearching for Task with ID 2:");
        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found");
        }

        System.out.println("\nDeleting Task with ID 2");
        taskList.deleteTask(2);

        System.out.println("\nTraversing tasks after deletion:");
        taskList.traverseTasks();
    }
}
