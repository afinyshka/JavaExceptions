package HW_02;

import java.util.Scanner;
/*
3. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */
public class Err04 {
    public static void main(String[] args) {
        try {
            String myStr = getString1();
            System.out.println("The string = " + myStr);
        } catch (IllegalArgumentException e) {
            System.out.println("An empty string was entered");
        }
    }

    public static String getString() {
        // Scanner scan = new Scanner(System.in);
        System.out.println("Type something: ");
        String str = null;
        boolean checkFloat = true;
        while (checkFloat) {
            try {
                Scanner scan = new Scanner(System.in); // why here works?
                str = scan.nextLine();
                checkFloat = false;
                scan.close();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getClass().getSimpleName());
                System.out.println("You can't enter empty string!");
            }
        }
        System.out.println("The scaner is closed");
        return str;
    }

    public static String getString1() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Type something: ");
        String str = null;
        try {
            str = scan.nextLine();
            if (str.isEmpty()) {
                throw new IllegalArgumentException("You can't enter empty strings!");
            }
        } finally {
            scan.close();
            System.out.println("...The scaner is closed...");
        }
        return str;
    }
}
