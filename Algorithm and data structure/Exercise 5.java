class Task {
    int taskId;
    String taskName;
    String status;

    Task(int id, String name, String status) {
        this.taskId = id;
        this.taskName = name;
        this.status = status;
    }

    @Override
    public String toString() {
        return taskId + " | " + taskName + " | " + status;
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

class TaskLinkedList {
    TaskNode head;

    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public Task searchTask(int id) {
        TaskNode temp = head;
        while (temp != null) {
            if (temp.task.taskId == id) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    public void deleteTask(int id) {
        if (head == null) return;

        if (head.task.taskId == id) {
            head = head.next;
            return;
        }

        TaskNode prev = head;
        TaskNode curr = head.next;

        while (curr != null) {
            if (curr.task.taskId == id) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Task not found.");
    }

    public void displayTasks() {
        TaskNode temp = head;
        if (temp == null) {
            System.out.println("No tasks found.");
            return;
        }

        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }
}

public class TaskManager {
    public static void main(String[] args) {
        TaskLinkedList list = new TaskLinkedList();

        list.addTask(new Task(1, "Write report", "Pending"));
        list.addTask(new Task(2, "Fix bugs", "In Progress"));
        list.addTask(new Task(3, "Test module", "Completed"));

        System.out.println("All Tasks:");
        list.displayTasks();

        System.out.println("\nSearching for Task with ID 2:");
        Task t = list.searchTask(2);
        System.out.println(t != null ? t : "Not found");

        System.out.println("\nDeleting Task with ID 2:");
        list.deleteTask(2);
        list.displayTasks();
    }
}

/*
Step 1: Linked Lists
- Singly Linked List: Nodes linked in one direction (next only).
- Doubly Linked List: Nodes linked in both directions (next and prev).

Step 4: Time Complexity
Add (at end):     O(n)
Search:           O(n)
Traverse:         O(n)
Delete (by id):   O(n)

Advantages of Linked List over Arrays:
- Dynamic size (no fixed capacity)
- No shifting required during insertion/deletion
- Efficient memory usage when data is frequently modified
*/
