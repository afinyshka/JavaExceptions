package HW_03.Models;

import HW_03.Exceptions.NotADateException;
import HW_03.Exceptions.NotANumberException;
import HW_03.Exceptions.NotAStringException;
import HW_03.Exceptions.NotCorrectSexException;

public class AttrChecker {

    public void stringChecker(String str) throws NotAStringException {
        for (char ch : str.toCharArray()) {
            if (!Character.isLetter(ch)) {
                throw new NotAStringException("\n!!!Exception: The full name can contain only letters.");
            }
        }
    }

    public void digitChecker(String str) throws NotANumberException {
        if (str.charAt(0) != '8') {
            throw new NotANumberException("\n!!!Exception: The phone number have to begin with '8'.");
        }
        if (str.length() > 11) {
            throw new NotANumberException("\n!!!Exception: The phone number is too long.");
        } else if (str.length() < 11) {
            throw new NotANumberException("\n!!!Exception: The phone number is too short.");
        }
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new NotANumberException("\n!!!Exception: The phone number can contain only numbers.");
            }
        }
    }

    public void dateChecker(String str) throws NotADateException, NumberFormatException {
        if (str.length() != 10) {
            throw new NotADateException("\n!!!Exception: The wrong date formater. Example: dd.mm.yyyy.");
        }
        String[] strng = str.split("\\.");
        if (strng.length != 3) {
            throw new NotADateException("\n!!!Exception: The wrong date format. Example: dd.mm.yyyy.");
        }
        try {
            Integer dd = Integer.parseInt(strng[0]);
            if (dd < 1 || dd > 31) {
                throw new NotADateException("You entered the wrong day of birth");
            }
            Integer mm = Integer.parseInt(strng[1]);
            if (mm < 1 || mm > 12) {
                throw new NotADateException("You entered the wrong month of birth");
            }
            Integer yyyy = Integer.parseInt(strng[2]);
            if (yyyy < 1900 || yyyy > 2022) {
                throw new NotADateException("You entered the wrong year of birth");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException(
                    "\n!!!Exception: " + e.getMessage() + ". Only numbers are valid. Example: dd.mm.yyyy.");
        }
    }

    public void sexChecker(String str) {
        if (str.charAt(0) != 'f' && str.charAt(0) != 'm') {
            throw new NotCorrectSexException(
                    "\n!!!Exeption: You entered the wrong sex. 'f' for fermale or 'm' for male is only possible.");
        }
    }
}
