import java.util.*;
public class ListToDo {
    static Map<String, LinkedList> groups = new HashMap<String, LinkedList>();
    static LinkedList<Task> tasks;

    static void newTask(String title, int priority, int dateDue, String note, Date createdDate, int steps, String groupN) {
        tasks.add(new Task(title, priority, dateDue, note, createdDate, steps, groupN));
    }
    static void editSteps(int steps,int index){
        Task task= (Task) ListToDo.tasks.get(index);
        task.setSteps(steps);
    }
    static void editTitle(String title,int index){
        Task task= (Task) ListToDo.tasks.get(index);
        task.setTitle(title);
    }
    static void editPriority(int priority,int index){
        Task task= (Task) ListToDo.tasks.get(index);
        task.setPriority(priority);

    }
    static void editDateDue(int dateDue,int index){
        Task task= (Task) ListToDo.tasks.get(index);
        task.setDateDue(dateDue);

    }
    static void editNote( String note,int index){
        Task task= (Task) ListToDo.tasks.get(index);
        task.setNote(note);

    }
    static int searchTask(String title) {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = (Task) (tasks.get(i));
            if (task.getTitle().compareTo(title) == 0) {
                return i;
            }
        }
        return -1;
    }
    public static void sortTask(int option){
        switch (option){
            case 1:
                Sorting.sortCreatedDate();
                break;
            case 2:
                Sorting.sortTitle();
                break;
            case 3:
                Sorting.sortPriority();
                break;
            case 4:
                Sorting.sortDateDue();
                break;
        }
    }
}
