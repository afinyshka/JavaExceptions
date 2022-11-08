package HW_03.MVP;

import HW_03.Exceptions.NotADateException;
import HW_03.Exceptions.NotANumberException;
import HW_03.Exceptions.NotAStringException;
import HW_03.Exceptions.NotCorrectLengthException;
import HW_03.Exceptions.NotCorrectSexException;
import HW_03.Models.AttrChecker;
import HW_03.Models.User;

public class UserCreater {

    public User createUser(String str) throws NotCorrectLengthException, NotAStringException, NotADateException,
            NotCorrectSexException, NotANumberException, NumberFormatException, RuntimeException {
        str = str.replaceAll("[\\s]{2,}", " ");
        String[] strng = str.split(" ");
        if (strng.length < 6) {
            throw new NotCorrectLengthException("\n!!!Exception: you entered less required parameters.");
        } else if (strng.length > 6) {
            throw new NotCorrectLengthException("\n!!!Exception: you entered more required parameters.");
        }
        AttrChecker atrChecker = new AttrChecker();
        try {
            atrChecker.stringChecker(strng[0]);
            String userSurname = strng[0];
            atrChecker.stringChecker(strng[1]);
            String userName = strng[1];
            atrChecker.stringChecker(strng[2]);
            String userPatronymicName = strng[2];
            atrChecker.dateChecker(strng[3]);
            String userBirthDay = strng[3];
            atrChecker.digitChecker(strng[4]);
            Long userPhoneNumber = Long.parseLong(strng[4]);
            atrChecker.sexChecker(strng[5]);
            char userSex = strng[5].charAt(0);
            return new User(userSurname, userName, userPatronymicName, userBirthDay, userPhoneNumber, userSex);
        } catch (NotCorrectSexException e) {
            throw new NotCorrectSexException(e.getMessage());
        }
    }
}
