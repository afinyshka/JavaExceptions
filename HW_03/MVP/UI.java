package HW_03.MVP;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    private static boolean loop = true;

    public void consoleUI() throws IOException {
        String text = """
                * * * * * * * * * * * * * * * * * * * * * * * * *
                *   Press the number for the command:           *
                *   1 - create a contact file;                  *
                *   0 - exit.                                   *
                * * * * * * * * * * * * * * * * * * * * * * * * *
                """;

        Presenter pr = new Presenter(new View(), new UserCreater());

        while (loop) {
            System.out.print(text);
            try {
                Scanner sc = new Scanner(System.in);
                int command = sc.nextInt();
                switch (command) {
                    case 1 -> pr.buttonClick();
                    case 0 -> {
                        sc.close();
                        loop = false;
                        System.out.println("\nGood Buy!");
                    }
                    default -> System.out.println("Warning!!! You entered the wrong command!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Warning!!! You entered the wrong command!");
            // } catch (IOException e) {
            //     e.getStackTrace(); // с ними не крашится! 
            }
        }
    }
}
