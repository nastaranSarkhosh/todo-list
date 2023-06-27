import java.io.*;
import java.util.LinkedList;
public class Sorting {
    public static void sortCreatedDate(){
        for (int i = 0; i < ListToDo.tasks.size(); i++) {
            for (int j = i + 1; j < ListToDo.tasks.size(); j++) {
                Task task = (Task) ListToDo.tasks.get(j);
                Task task2 = (Task) ListToDo.tasks.get(i);
                if (task.getCreatedDate().getYear() < task2.getCreatedDate().getYear()) {
                    ListToDo.tasks.set(j, task2);
                    ListToDo.tasks.set(i, task);
                } else if (task.getCreatedDate().getYear() == task2.getCreatedDate().getYear()) {
                    if (task.getCreatedDate().getMonth() < task2.getCreatedDate().getMonth()) {
                        ListToDo.tasks.set(j, task2);
                        ListToDo.tasks.set(i, task);
                    } else if (task.getCreatedDate().getMonth() == task2.getCreatedDate().getMonth()) {
                        if (task.getCreatedDate().getDay() < task2.getCreatedDate().getDay()) {
                            ListToDo.tasks.set(j, task2);
                            ListToDo.tasks.set(i, task);
                        }
                    }
                }
            }
        }
    }
    public static void sortTitle(){
        for (int i = 0; i <  ListToDo.tasks.size(); i++) {
            for (int j = i + 1; j <  ListToDo.tasks.size(); j++) {
                Task task = (Task)  ListToDo.tasks.get(j);
                Task task2 = (Task)  ListToDo.tasks.get(i);
                if (task.getTitle().charAt(0)< task2.getTitle().charAt(0)) {
                    ListToDo.tasks.set(j, task2);
                    ListToDo.tasks.set(i, task);
                }
            }
        }
    }
    public static void sortPriority(){
        for (int i = 0; i <  ListToDo.tasks.size() ; i++) {
            for (int j = i + 1; j <  ListToDo.tasks.size(); j++) {
                Task task = (Task)  ListToDo.tasks.get(j);
                Task task2 = (Task)  ListToDo.tasks.get(i);
                if (task2.getPriority()> task.getPriority()) {
                    ListToDo.tasks.set(j, task2);
                    ListToDo.tasks.set(i, task);
                }
            }
        }
    }
    public static void sortDateDue(){

        for (int i = 0; i <  ListToDo.tasks.size(); i++) {
            for (int j = i + 1; j <  ListToDo.tasks.size(); j++) {
                Task task = (Task)  ListToDo.tasks.get(j);
                Task task2 = (Task)  ListToDo.tasks.get(i);
                if (task2.getDateDue() > task.getDateDue()) {
                    ListToDo.tasks.set(j, task2);
                    ListToDo.tasks.set(i, task);
                }
            }
        }
    }
}