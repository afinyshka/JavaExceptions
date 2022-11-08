package HW_03.MVP;


import HW_03.Exceptions.NotADateException;
import HW_03.Exceptions.NotANumberException;
import HW_03.Exceptions.NotAStringException;
import HW_03.Exceptions.NotCorrectLengthException;
import HW_03.Exceptions.NotCorrectSexException;
import HW_03.Models.AttrChecker;
import HW_03.Models.User;

public class UserCreater {

    public User createUser(String str) throws NotCorrectLengthException, NotAStringException, NotADateException , NotCorrectSexException, NotANumberException, NumberFormatException, RuntimeException {
        str = str.replaceAll("[\\s]{2,}", " ");
        String[] strng = str.split(" ");
        // System.out.println(Arrays.toString(strng) + strng.length);
        if (strng.length < 6) {
            throw new NotCorrectLengthException("\n!!!Exception: you entered less required parameters.");
        } else if (strng.length > 6) {
            throw new NotCorrectLengthException("\n!!!Exception: you entered more required parameters.");
        }
        AttrChecker atrCheckerSurname = new AttrChecker(strng[0]);
        try {
            atrCheckerSurname.stringChecker();
        } catch (NotAStringException e) {
            throw new NotAStringException(e.getMessage());
        }
        String userSurname = strng[0];
        AttrChecker atrCheckerName = new AttrChecker(strng[1]);
        try {
            atrCheckerName.stringChecker();
        } catch (NotAStringException e) {
            throw new NotAStringException(e.getMessage());
        }
        String userName = strng[1];
        AttrChecker atrCheckerPatronymic = new AttrChecker(strng[2]);
        try {
            atrCheckerPatronymic.stringChecker();
        } catch (NotAStringException e) {
            throw new NotAStringException(e.getMessage());
        }
        String userPatronymicName = strng[2];
        AttrChecker atrCheckerDate = new AttrChecker(strng[3]);
        try {
            atrCheckerDate.dateChecker();
        } catch (NotADateException e) {
            throw new NotADateException(e.getMessage());
        }
        String userBirthDay = strng[3];
        AttrChecker atrCheckerNumber = new AttrChecker(strng[4]);
        try {
            atrCheckerNumber.digitChecker();
        } catch (NotANumberException e) {
            throw new NotANumberException(e.getMessage());
        }
        Long userPhoneNumber = Long.parseLong(strng[4]);
        AttrChecker atrCheckerSex = new AttrChecker(strng[5]);
        try {
            atrCheckerSex.sexChecker();
        } catch (NotCorrectSexException e) {
            throw new NotCorrectSexException(e.getMessage());
        }
        char userSex = strng[5].charAt(0);
        // try {
        //     userPhoneNumber = Long.parseLong(strng[4]);
        // } catch (NumberFormatException e) {
        //     throw new NumberFormatException("\nYou entered the wrong number: " + e.getMessage());
        // } catch (RuntimeException e) {
        //     throw new RuntimeException(e.getMessage());
        // }
        // System.out.println(Character.class.isInstance(userSex));
        // if (userSex != 'f' && userSex != 'm') {
        //     throw new NotCorrectSexException("Exception: you entered the wrong sex. 'f' or 'm' is only possible.");
        // }
        return new User(userSurname, userName, userPatronymicName, userBirthDay, userPhoneNumber, userSex);
    }

    // public static void main(String[] args) {
    //     String user1 = "I3vanov Ivan Ivanovich 01.01.1990 89091234567 mas";

    //     UserCreater usCr = new UserCreater();
    //     User newUser = usCr.createUser(user1);
    //     System.out.println(newUser);
    // }

}
