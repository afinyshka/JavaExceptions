package HW_03.Models;

public class User {
    private String userName;
    private String userSurname;
    private String userPatronymicName;
    private String userBirthDay;
    private long userPhoneNumber;
    private char UserSex;

    public User(String userSurname, String userName, String userPatronymicName, String userBirthDay,
            long userPhoneNumber, char sex) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPatronymicName = userPatronymicName;
        this.userBirthDay = userBirthDay;
        this.userPhoneNumber = userPhoneNumber;
        this.UserSex = sex;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public String getUserPatronymicName() {
        return userPatronymicName;
    }

    public String getUserBirthDay() {
        return userBirthDay;
    }

    public long getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public char getSex() {
        return UserSex;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public void setUserPatronymicName(String userPatronymicName) {
        this.userPatronymicName = userPatronymicName;
    }

    public void setUserBirthDay(String userBirthDay) {
        this.userBirthDay = userBirthDay;
    }

    public void setUserPhoneNumber(int userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public void setSex(char sex) {
        this.UserSex = sex;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %d %c", userSurname, userName, userPatronymicName, userBirthDay,
                userPhoneNumber, UserSex);
    }
}