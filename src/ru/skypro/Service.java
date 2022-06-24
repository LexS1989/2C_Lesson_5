package ru.skypro;

import java.util.Objects;

public class Service {

    private static final String VALID_SYMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789";

    private Service() {
    }

    public static boolean user(String login,
                               String password,
                               String confirmPassword) {
        try {
            validate(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void validate(String login,
                                 String password,
                                 String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() > 20) {
            throw new WrongLoginException("Login должен быть равен или меньше 20 символов.");
        }
        if (!checkSymbol(login)) {
            throw new WrongLoginException("Login должен содержать в себе только латинские буквы, цифры и знак подчеркивания");
        }
        if (Objects.isNull(password) || password.length() >= 20) {
            throw new WrongPasswordException("Password должен быть меньше 20 символов.");
        }
        if (!checkSymbol(password)) {
            throw new WrongPasswordException("Password должен содержать в себе только латинские буквы, цифры и знак подчеркивания");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password и confirmPassword должны совпадать");
        }
    }

    private static boolean checkSymbol(String a) {
        char[] symbols = a.toCharArray();
        for (char symbol : symbols) {
            if (!VALID_SYMBOLS.contains(String.valueOf(symbol))) {
                return false;
            }
        }
        return true;
    }
}
