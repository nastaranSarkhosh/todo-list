import java.util.LinkedList;
import java.util.Scanner;
public class Menu {
    static Scanner input = new Scanner(System.in);
    public static void mainMenu() {
        int option;
        do {
            System.out.print("-.-Please select an option-.-\n1-New group for tasks\t2-Enter a group\n0-Exit\n");
            option = input.nextInt();
            switch (option){
                case 1:
                    System.out.println("Please chose a name for this group:   ");
                    ListToDo.groups.put(input.next(),new LinkedList<>());
                    break;
                case 2:
                    System.out.println("Please enter the name of group that you want to see:");
                    String groupName=input.next();
                    ListToDo.tasks=ListToDo.groups.get(groupName);
                    if(ListToDo.tasks!=null)
                        enterGroup(groupName);
                    else {
                        System.out.println("...Sorry but there is no such group...\n");
                    }
                    break;
            }

        } while (option != 0);
    }
    public static void enterGroup(String gName){
        int option;
        do {
            System.out.print("\n1-Make a new task\n2-Edit task\n3-Remove task\n4-Search in tasks\n5-Organize tasks\n6-Show list of tasks \n7-Exit\n");
            option=input.nextInt();
            switch (option) {
                case 1:
                    newTask(gName);
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    searchTask();
                    break;
                case 5:
                    sortTask();
                    break;
                case 6:
                    showTasks();
                    break;
            }
        }while (option!=7);
    }
    public static void editTask(){
        showTasks();
        System.out.println("Which task do you want to edit?");
        int index = input.nextInt();
        if ((index - 1) >= 0 && (index - 1) < ListToDo.tasks.size()) {
            System.out.println("Do you want to edit which part?\n1.Title\t2.Priority\t3.Deadline\t4.Steps\t5.Note\n");
            switch (input.nextInt()){
                case 1:
                    System.out.print("Enter the new title of the task");
                    String title = input.next();
                    ListToDo.editTitle(title,index - 1);
                    break;
                case 2:
                    System.out.print("Enter the new priority of the task(Choose a number from 1 to 5)");
                    int priority = input.nextInt();
                    ListToDo.editPriority(priority,index - 1);
                    break;
                case 3:
                    System.out.print("Enter the deadline (number of days)");
                    int dateDue = input.nextInt();
                    ListToDo.editDateDue(dateDue,index - 1);
                    break;
                case 4:
                    System.out.print("Enter the number of steps");
                    int steps = input.nextInt();
                    ListToDo.editSteps(steps,index - 1);
                    break;
                case 5:
                    input.nextLine();
                    System.out.print("Enter the note");
                    String note = input.nextLine();
                    ListToDo.editNote(note,index - 1);
                    break;
            }
        }
        else {
            System.out.print("This task does not exist");
        }
        System.out.print("________________________________________________________________\n");
    }
    public static void searchTask(){
        System.out.println("Please enter the title of task you're looking for :\n");
        int index=ListToDo.searchTask(input.next());
        if (index<0)
            System.out.println("We couldn't find the task with the title that you want?\n");
        else
            System.out.println(ListToDo.tasks.get(index).toString());
    }
    public static void sortTask(){
        System.out.println("On what ... do you want to sort tasks?\n1-CreatedDate\t2-Title\t3-Priority\t4-DateDue");
        ListToDo.sortTask(input.nextInt());
    }
    public static void deleteTask(){
        showTasks();
        System.out.println("Which task do you want to delete?");
        int index=input.nextInt();
        if((index-1)>=0 && (index-1)<ListToDo.tasks.size()){
            ListToDo.tasks.remove(index-1);
        }else{
            System.out.print("This task does not exist");
        }
        System.out.print("________________________________________________________________\n");
    }
    public static void showTasks(){
        for(int i=0;i<ListToDo.tasks.size();i++){
            System.out.println((i+1)+" : "+ListToDo.tasks.get(i).toString());
        }
    }
    public static void newTask(String gName){
        System.out.print("Enter the title of this task (it should start with capital letter)");
        String title=input.next();
        System.out.print("Enter the priority of this task(Choose a number from 1 to 5)");
        int priority=input.nextInt();
        System.out.print("Enter the deadline (number of days)");
        int dateDue=input.nextInt();
        System.out.print("Enter today's date (year month day)");
        Date date=new Date(input.nextInt(),input.nextInt(),input.nextInt());
        System.out.print("Enter the number of steps");
        int steps=input.nextInt();
        input.nextLine();
        System.out.print("Enter the note");
        String note=input.nextLine();
        ListToDo.newTask(title,priority,dateDue,note,date,steps,gName);
        System.out.print("________________________________________________________________\n");
    }
}


