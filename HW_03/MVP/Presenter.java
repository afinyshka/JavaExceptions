package HW_03.MVP;

import java.io.IOException;

import HW_03.Exceptions.NotADateException;
import HW_03.Exceptions.NotANumberException;
import HW_03.Exceptions.NotAStringException;
import HW_03.Exceptions.NotCorrectLengthException;
import HW_03.Exceptions.NotCorrectSexException;
import HW_03.Models.FileManager;
import HW_03.Models.User;

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
                    // System.out.println(user1);
                    FileManager fm = new FileManager(user1);
                    try {
                        fm.write();
                        check = false;
                    } catch (IOException e) {
                        throw new IOException(e.getMessage());
                    }
                } catch (NotCorrectLengthException e) {
                    System.out.println(e.getMessage() + " Try again.");
                } catch (NotAStringException e) {
                    System.out.println(e.getMessage() + " Try again.");
                } catch (NotADateException e) {
                    System.out.println(e.getMessage() + " Try again.");
                } catch (NotANumberException e) {
                    System.out.println(e.getMessage() + " Try again.");
                } catch (NotCorrectSexException e) {
                    System.out.println(e.getMessage() + " Try again.");
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage() + " Try again.");
                }
            }
        }
    }
}
