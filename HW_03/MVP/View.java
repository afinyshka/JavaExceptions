package HW_03.MVP;

import java.util.Scanner;

public class View {
    Scanner sc = new Scanner(System.in);

    public String getString (String stringUser) {
        System.out.printf("\n%s", stringUser);
        return sc.nextLine();
    }  
    
}
