package HW_03.MVP;

import java.io.IOException;

import HW_03.Models.FileManager;
import HW_03.Models.User;
import HW_03.Views.View;

public class Presenter {
    View view;
    UserCreater userCreater;

    public Presenter(View view, UserCreater userCreater) {
        this.view = view;
        this.userCreater = userCreater;
    }

    public void buttonClick() throws IOException {
        boolean check = true;
        String text = """
                 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                |  Enter user's data in the following order:                                |
                |  <Surname> <Name> <Patronymic_Name> <date_of_birth> <phone_number> <sex>. |
                |  Formats:                                                                 |
                |  Birthdate: dd.mm.yyyy. Sex: m / f. Phone number: 10-digits.              |
                |- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -|
                |  Example: Ivanov Ivan Ivanovich 01.01.1990 89091234567 m                  |
                |- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -|
                |  For previous menu type: exit                                             |
                | _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
                    """;
        while (check) {
            String a = view.getString(text);
            if (a.equals("exit")) {
                break;
            } else {
                try {
                    User user1 = userCreater.createUser(a);
                    FileManager fm = new FileManager(user1);
                    try {
                        fm.write();
                        view.print("\n!!!Info: The file was successfully written!");
                        check = false;
                    } catch (IOException e) {
                        throw new IOException(e.getMessage());
                    }
                } catch (NumberFormatException e) {
                    view.print(e.getMessage() + " Try again.");
                } catch (RuntimeException e) {
                    view.print(e.getMessage() + " Try again.");
                }
            }
        }
    }
}
