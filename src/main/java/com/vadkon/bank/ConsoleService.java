package com.vadkon.bank;

import java.util.Scanner;

public class ConsoleService {
    private String handleInputLogin() {
        ValidatorService validator = new ValidatorService();
        Scanner scanner = new Scanner(System.in);
        String inputLogin = scanner.nextLine();
        if (validator.checkLogin(inputLogin)) {
            return inputLogin;
        } else {
            System.out.println("Please try again, login is incorrect");
            return handleInputLogin();
        }
    }

    private String handleInputPassword() {
        ValidatorService validator = new ValidatorService();
        Scanner scanner = new Scanner(System.in);
        String inputPassword = scanner.nextLine();
        if (validator.checkPassword(inputPassword)) {
            return inputPassword;
        } else {
            System.out.println("Please try again, password is incorrect");
            return handleInputPassword();
        }
    }

    private void getDataFromConsole() {
        System.out.print("LOGIN: ");
        handleInputLogin();
        System.out.println("Password must consist at least one digit, " +
                "lower case letter and upper case letter and length !< 8");
        System.out.print("PASSWORD: ");
        handleInputPassword();
    }

    public void run() {
        System.out.println("Hello! Please authorise to get access to your account");
        getDataFromConsole();
    }
}
