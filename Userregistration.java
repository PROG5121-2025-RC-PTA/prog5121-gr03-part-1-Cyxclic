/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.userregistration;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class Userregistration {
// Class variables
    private final String username;
    private final String password;
    private final String cellPhoneNumber;

    // Constructor

    /**
     *
     * @param username
     * @param password
     * @param cellPhoneNumber
     */
    public Userregistration(String username, String password, String cellPhoneNumber) {
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    // Method to check username format
    public String checkUsername() {
        if (username.contains("_") && username.length() <= 5) {
            return "Username is valid.";
        } else {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
    }

    // Method to check password complexity
    public String checkPassword() {
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialChar = true;
            }
        }

        if (password.length() >= 8 && hasUpperCase && hasDigit && hasSpecialChar) {
            return "Password is valid.";
        } else {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
    }

    // Method to check cell phone number format
    public String checkCellPhoneNumber() {
        if (cellPhoneNumber.startsWith("+27") && cellPhoneNumber.length() == 10) {
            return "Cell phone number is valid.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain international code.";
        }
    }

    // Method to register user
    public String registerUser() {
        String usernameMessage = checkUsername();
        if (!usernameMessage.equals("Username is valid.")) {
            return usernameMessage;
        }

        String passwordMessage = checkPassword();
        if (!passwordMessage.equals("Password is valid.")) {
            return passwordMessage;
        }

        String cellPhoneMessage = checkCellPhoneNumber();
        if (!cellPhoneMessage.equals("Cell phone number is valid.")) {
            return cellPhoneMessage;
        }

        return "Registration successful!";
    }

    // Method to login user
    public String loginUser(String inputUsername, String inputPassword) {
        if (this.username.equals(inputUsername) && this.password.equals(inputPassword)) {
            return "Welcome " + username + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] userInputs = new String[3]; // Array to store user inputs
            
            // User input for registration
            System.out.print("Enter username: ");
            userInputs[0] = scanner.nextLine();
            System.out.print("Enter password: ");
            userInputs[1] = scanner.nextLine();
            System.out.print("Enter cell phone number: ");
            userInputs[2] = scanner.nextLine();
            
            // Create UserRegistration object
            Userregistration user;
            user = new Userregistration(userInputs[0], userInputs[1], userInputs[2]);
            
            // Register user
            String registrationMessage = user.registerUser();
            System.out.println(registrationMessage);
            
            // If registration is successful, proceed to login
            if (registrationMessage.equals("Registration successful!")) {
                System.out.print("Enter username to login: ");
                String inputUsername = scanner.nextLine();
                System.out.print("Enter password to login: ");
                String inputPassword = scanner.nextLine();
                
                // Login user
                String loginStatus = user.loginUser(inputUsername, inputPassword);
                System.out.println(loginStatus);
            }
        } // Array to store user inputs
    }
}

    