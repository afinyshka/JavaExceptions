package HW_02;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное
значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо
повторно запросить у пользователя ввод данных.
 */
public class Err01 {
    public static void main(String[] args) {
        float num = getFLoat();
        System.out.println("Your number is: " + num);
    }

    public static float getFLoat() {
        // Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number: ");
        Float num = null;
        boolean checkFloat = true;
        while (checkFloat) {
            try {
                Scanner scan = new Scanner(System.in); // why here works?
                num = scan.nextFloat();
                checkFloat = false;
                scan.close();
            } catch (InputMismatchException e) {
                System.out.println(e.getClass().getSimpleName());
                System.out.println("Try to enter the number in the right format: ");
            }
        }
        System.out.println("...The scaner is closed...");
        return num;
    }
}
