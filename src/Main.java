import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean continueWorking = true;
        while (continueWorking){
            Scanner scanner = new Scanner(System.in);
            printMenu();
            String option = scanner.nextLine();
            switch (option){
                case "1":
                    TaskService.add();
                    break;
                case "2":
                    TaskService.remove();
                    break;
                case "3":
                    System.out.println(TaskService.getAllByDate());
                    break;
                case "4":
                    TaskService.printActiveTasks();
                    break;
                case "5":
                    TaskService.printDeletedTasks();
                    break;
                case "6":
                    TaskService.editTask();
                    break;
                case "7":
                    continueWorking = false;
                    break;
                default:
                    System.out.println("Unknown value was entered. Try again.");
            }
        }
    }
    public static void printMenu(){
        System.out.println("Select an action:\n" +
                "1 - add new task\n" +
                "2 - remove task by id\n" +
                "3 - get tasks by date\n" +
                "4 - print active tasks\n" +
                "5 - print deleted tasks\n" +
                "6 - edit task by id\n" +
                "7 - exit");
    }
}