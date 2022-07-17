package com.vadkon.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleService {
    private double balance;
    private double creditLimit;

    public ConsoleService() {
        balance = 0;
        creditLimit = 1000;
    }

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

    private void add() {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextDouble()) return;

        double amount = scanner.nextDouble();
        if (amount > 0)
            balance += amount;
        System.out.println("Now your balance: " + balance);
    }

    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextDouble()) return;

        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Now your balance: " + balance);
        } else {
            balance = 0;
            creditLimit -= amount + 10;
            System.out.println("Your balance: " + balance + ", credit limit left: " + creditLimit);
        }
    }

    private void transfer() {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextDouble()) return;

        double amount = scanner.nextDouble();
        balance -= amount;
        System.out.println("Balance: " + balance);
    }

    private void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    private void checkCreditLimit() {
        System.out.println("Credit limit: " + creditLimit);
    }

    private void getDataFromConsole() {
        System.out.print("LOGIN: ");
        handleInputLogin();
        System.out.println("Password must consist at least one digit, " +
                "lower case letter and upper case letter and length !< 8");
        System.out.print("PASSWORD: ");
        handleInputPassword();
    }

    private void handleMenu() {
        Scanner scanner = new Scanner(System.in);
        List<String> commandHistory = new ArrayList<>();

        while (!commandHistory.contains("q")) {
            String input = scanner.nextLine();
            switch (input) {
                case "wd":
                    commandHistory.add(input);
                    withdraw();
                    break;
                case "t":
                    commandHistory.add(input);
                    transfer();
                    break;
                case "add":
                    commandHistory.add(input);
                    add();
                    break;
                case "cb":
                    commandHistory.add(input);
                    checkBalance();
                    break;
                case "ccl":
                    commandHistory.add(input);
                    checkCreditLimit();
                    break;
                case "q":
                    commandHistory.add(input);
                    System.out.println("Have a good day!");
                    return;
                default:
                    commandHistory.add("Error: unavailable value - " + input);
                    System.out.println("Choose available operation");
            }
        }
    }

    public void run() {
        System.out.println("Hello! Please authorise to get access to your account");
        getDataFromConsole();
        System.out.println("You have been successfully authorised!");
        System.out.println("Enter to continue: wd - to withdraw, t - to transfer, add - to top up, " +
                "cb - to check balance, ccl - to check credit limit");
        handleMenu();
    }
}
