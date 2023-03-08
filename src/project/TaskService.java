package project;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TaskService {
    public static Map<Integer,Task> taskMap = new HashMap<>();
    public static Map<Integer,Task> removedTasks = new HashMap<>();
    public static void add() {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Enter title:");
            String title = Validate.validateString(scanner.nextLine());
            System.out.println("Enter description:");
            String description = Validate.validateString(scanner.nextLine());
            System.out.println("Enter type:\n" +
                    "1 - work\n" +
                    "2 - personal");
            String typeTask = scanner.nextLine();
            Type type;
            switch (typeTask) {
                case "1":
                    type = Type.WORK;
                    break;
                case "2":
                    type = Type.PERSONAL;
                    break;
                default:
                    System.out.println("Unknown value was entered. Default value is selected");
                    type = Type.PERSONAL;
            }
            System.out.println("Enter the date in the format: dd.MM.yyyy HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            System.out.println("Select the task type of repeatability:\n" +
                    "1 - one time task\n" +
                    "2 - daily task\n" +
                    "3 - weekly task\n" +
                    "4 - monthly task\n" +
                    "5 - yearly task");
            String typeOfRepeatability = scanner.nextLine();
            switch (typeOfRepeatability){
                case "1":
                    OneTimeTask currentTask1 = new OneTimeTask(title,description,type,dateTime);
                    taskMap.put(currentTask1.getId(), currentTask1);
                    System.out.println("Task created: " + currentTask1);
                    break;
                case "2":
                    DailyTask currentTask2 = new DailyTask(title,description,type,dateTime);
                    taskMap.put(currentTask2.getId(), currentTask2);
                    System.out.println("Task created: " + currentTask2);
                    break;
                case "3":
                    WeeklyTask currentTask3 = new WeeklyTask(title,description,type,dateTime);
                    taskMap.put(currentTask3.getId(), currentTask3);
                    System.out.println("Task created: " + currentTask3);
                    break;
                case "4":
                    MonthlyTask currentTask4 = new MonthlyTask(title,description,type,dateTime);
                    taskMap.put(currentTask4.getId(), currentTask4);
                    System.out.println("Task created: " + currentTask4);
                    break;
                case "5":
                    YearlyTask currentTask5 = new YearlyTask(title,description,type,dateTime);
                    taskMap.put(currentTask5.getId(), currentTask5);
                    System.out.println("Task created: " + currentTask5);
                    break;
                default:
                    System.out.println("Unknown value was entered.");
                    throw new IncorrectArgumentException();
            }
        } catch (DateTimeParseException e){
            System.out.println("The task has not been created");
            System.out.println(e.getMessage());
        } catch (IncorrectArgumentException e){
            System.out.println("The task has not been created");
        }
    }
    public static void remove(){
        if (taskMap.isEmpty()){
            System.out.println("There are no active tasks");
        } else{
            Scanner scanner = new Scanner(System.in);
            printActiveTasks();
            System.out.println("Enter id");
            int idTask = scanner.nextInt();
            try {
                if (taskMap.containsKey(idTask)) {
                    removedTasks.put(idTask,taskMap.get(idTask));
                    taskMap.remove(idTask);
                } else {
                    throw new TaskNotFoundExceptoin();
                }
            }catch (TaskNotFoundExceptoin e){
                System.out.println("Task not found");
            }
        }
    }
    public static ArrayList<Task> getAllByDate(){
        System.out.println("Enter the date in the format: dd.MM.yyyy");
        Scanner scanner = new Scanner(System.in);
        try {
            LocalDate date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            Predicate<Task> predicateTask = task -> task.appearsIn(date);
            return taskMap.values().stream()
                    .filter(predicateTask)
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (DateTimeParseException e){
            System.out.println("Incorrect date");
        }
        return null;
    }
    public static void printActiveTasks(){
        if (taskMap.isEmpty()){
            System.out.println("There are no active tasks");
        } else {
            System.out.println("Active tasks:");
            for (Map.Entry<Integer,Task> entry : taskMap.entrySet()){
                System.out.println(entry);
            }
        }
    }
    public static void printDeletedTasks(){
        if (removedTasks.isEmpty()) {
            System.out.println("There are no deleted tasks");
        } else {
            System.out.println("Deleted tasks:");
            for (Map.Entry<Integer,Task> entry : removedTasks.entrySet()){
                System.out.println(entry);
            }
        }
    }
    public static void editTask(){
        if (taskMap.isEmpty()){
            System.out.println("There are no active tasks");
        } else{
            Scanner scanner = new Scanner(System.in);
            printActiveTasks();
            System.out.println("Enter id of the task you want to edit:");
            int idTask = scanner.nextInt();
            try {
                if (taskMap.containsKey(idTask)) {
                    Scanner scannerStr = new Scanner(System.in);
                    System.out.println("Enter new title:");
                    taskMap.get(idTask).setTitle(scannerStr.nextLine());
                    System.out.println("Enter new description:");
                    taskMap.get(idTask).setDescription(scannerStr.nextLine());
                } else {
                    throw new TaskNotFoundExceptoin();
                }
            }catch (TaskNotFoundExceptoin e){
                System.out.println("Task not found");
            }
        }
    }
}
