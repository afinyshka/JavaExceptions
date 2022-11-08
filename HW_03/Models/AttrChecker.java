package HW_03.Models;

import HW_03.Exceptions.NotADateException;
import HW_03.Exceptions.NotANumberException;
import HW_03.Exceptions.NotAStringException;
import HW_03.Exceptions.NotCorrectSexException;

public class AttrChecker {
    String str;

    public AttrChecker(String str) {
        this.str = str;
    }

    public void stringChecker() throws NotAStringException {
        for (char ch : str.toCharArray()) {
            if (!Character.isLetter(ch)) {
                // System.out.println("Not only letters.");
                throw new NotAStringException("\n!!!Exception: The full name can contain only letters.");
            }
        }
        System.out.println("Valid name.");
    }

    public void digitChecker() throws NotANumberException {
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
                // System.out.println("Not only letters.");
                throw new NotANumberException("\n!!!Exception: The phone number can contain only numbers.");
            }
        }
        System.out.println("Valid phone number.");
    }

    public void dateChecker() throws NotADateException, NumberFormatException {
        // String str = 12.12.1990;
        // boolean isValidFormat = str.matches("([0-9]{2}).([0-9]{2}).([0-9]{4})");
        // if (!isValidFormat) {
        // throw new NotADateException("\n!!!Exception: The wrong date formater.
        // Example: dd.mm.yyyy.");
        // }
        // System.out.println(str);
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
            // throw new NumberFormatException("\n" + e.getMessage());
            throw new NumberFormatException(
                    "\n!!!Exception: " + e.getMessage() + ". Only numbers are valid. Example: dd.mm.yyyy.");
        }
        System.out.println("Valid date of birth.");
    }

    public void sexChecker() {
        if (str.charAt(0) != 'f' && str.charAt(0) != 'm') {
            throw new NotCorrectSexException(
                    "\n!!!Exeption: You entered the wrong sex. 'f' for fermale or 'm' for male is only possible.");
        }
        System.out.println("Valid sex.");
    }

    public static void main(String[] args) {
        String str = "f";
        AttrChecker test = new AttrChecker("m");
        test.sexChecker();
        System.out.println(str);

    }

}
