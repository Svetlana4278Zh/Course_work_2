package taskFromTicket;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Введите число");
        Scanner scanner = new Scanner(System.in);
        try{
            double num = scanner.nextDouble();
            System.out.println(num + "^3 = " + num*num*num);
        }catch (InputMismatchException e){
            System.out.println("Введено не число");
        }
    }
}
