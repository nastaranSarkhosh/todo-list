import java.io.*;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.Scanner;
public class Project {
    public static void main(String[] args) {
        File file2=new File(".\\Tasks.txt");
        try {
            readTasks(file2);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
        System.out.print("Welcome");
        Menu.mainMenu();
        try {
            writeTasks(file2);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }

    }
    public static void writeTasks(File file) throws IOException {
        file.createNewFile();
        FileOutputStream fileOutputStream=new FileOutputStream(file,false);
        Formatter formatter=new Formatter(fileOutputStream);
        for(var listName:ListToDo.groups.keySet()){
            LinkedList list=ListToDo.groups.get(listName);
            for(int i=0;i<list.size();i++){
                Task task=(Task)list.get(i);
                formatter.format("%s %d %d %d %d %d %d %s %s\n",task.getTitle(),task.getPriority(),task.getDateDue(),task.getCreatedDate().getDay(),task.getCreatedDate().getMonth(),task.getCreatedDate().getYear(),task.getSteps(),task.getGroupName(),task.getNote());
            }
        }
        formatter.flush();
    }
    public static void readTasks(File file2) throws IOException {
        file2.createNewFile();
        FileInputStream fileInputStream=new FileInputStream(file2);
        Scanner scanner=new Scanner(fileInputStream);
        while (scanner.hasNext()) {
            String title = scanner.next();
            int priority = scanner.nextInt();
            int dateDue = scanner.nextInt();
            int createdDateDay = scanner.nextInt();
            int createdDateMonth = scanner.nextInt();
            int createdDateYear = scanner.nextInt();
            int steps = scanner.nextInt();
            String nameGroup = scanner.next();
            String note = scanner.nextLine();
            Date date=new Date(createdDateYear,createdDateMonth,createdDateDay);
            LinkedList list =ListToDo.groups.get(nameGroup);
            if(list!=null){
                list.add(new Task(title,priority,dateDue,note,date,steps,nameGroup));
            }else {
                ListToDo.groups.put(nameGroup,new LinkedList<>());
                LinkedList list1=ListToDo.groups.get(nameGroup);
                list1.add(new Task(title,priority,dateDue,note,date,steps,nameGroup));
            }

        }
    }
}
