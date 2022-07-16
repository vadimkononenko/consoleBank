package com.vadkon.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorService {
    public boolean checkLogin(String login) {
        String loginRegex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(loginRegex);
        Matcher matcher = pattern.matcher(login);

        return matcher.matches();
    }

    public boolean checkPassword(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
}