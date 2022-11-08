package HW_03.Views;

import java.util.Scanner;

public class View {
    Scanner sc = new Scanner(System.in);

    public String getString (String stringUser) {
        System.out.printf("\n%s", stringUser);
        return sc.nextLine();
    }

    public void print(String text) {
        System.out.println(text);
    }
    
}
