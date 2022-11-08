package HW_03.MVP;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import HW_03.Views.View;

public class UI {
    private static boolean loop = true;
    // View view;

    public void consoleUI() {
        String text = """
                * * * * * * * * * * * * * * * * * * * * * * * * *
                *   Press the number for the command:           *
                *   1 - create a contact file;                  *
                *   0 - exit.                                   *
                * * * * * * * * * * * * * * * * * * * * * * * * *
                """;
        View view = new View();
        Presenter pr = new Presenter(view, new UserCreater());
        view.print("\nHello!!");

        while (loop) {
            System.out.print(text);
            try {
                Scanner sc = new Scanner(System.in);
                int command = sc.nextInt();
                switch (command) {
                    case 1 -> {
                        try {
                            pr.buttonClick();
                        } catch (IOException e) {
                            e.printStackTrace();
                            sc.close();
                            loop = false;
                            view.print("\nNot correct path or problem on server. Come back later. We are woking on this problem!");
                        }
                    }
                    case 0 -> {
                        sc.close();
                        loop = false;
                        view.print("\nGood Buy!");
                    }
                    default -> view.print("Warning!!! You entered the wrong command!");
                }
            } catch (InputMismatchException e) {
                view.print("Warning!!! You entered the wrong command!");
            }
        }
    }
}
