package Homework_lesson13;

public class Authentication {
    public static boolean isValid(String login, String password, String confirm) {
        //check login
        try {
            if (!Validation.isLengthCorrect(login, 1, 19) || Validation.hasWhiteSpace(login))
                throw new WrongLoginException("login is not valid!!");

            if (!Validation.isLengthCorrect(password, 1, 19)
                    || Validation.hasWhiteSpace(password)
                    || !Validation.hasDigit(password)
                    || !password.equals(confirm))
                throw new WrongPasswordException("password is not valid");

            return true;
        } catch (WrongLoginException | WrongPasswordException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }
}
