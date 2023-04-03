package com.sparta.group3.view;

import com.sparta.group3.controller.Controller;
import com.sparta.group3.controller.MenuResponse;

import java.util.Scanner;

public class CLI {
    Controller controller;
    public CLI(Controller controller){
        this.controller = controller;
        runCLI();
    }
    private void runCLI(){
        Menu proceedMenu = controller.getMenu("proceed");
        Menu actionMenu = controller.getMenu("action");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Hello and welcome to Group 3 Employee BST project.");
        System.out.println("From here you will be able to look up or list employees.");

        boolean proceed = true;
        String userInput;
        while(proceed){
            System.out.println("Would you like to continue?");
            System.out.println(proceedMenu);
            userInput = keyboard.nextLine();
            MenuResponse.ResponseCode responseCode = proceedMenu.handleAction(userInput, "").feedbackCode;

            while(responseCode == MenuResponse.ResponseCode.BAD_REQUEST){
                System.out.println("Incorrect input detected, please select one of the below options:");
                System.out.println(proceedMenu);
                userInput = keyboard.nextLine();
                responseCode = proceedMenu.handleAction(userInput, "").feedbackCode;
            }
            if(responseCode == MenuResponse.ResponseCode.FALSE) break;
            System.out.println("What action would you like to perform?");
            System.out.println(actionMenu);
            userInput = keyboard.nextLine();
            MenuResponse response = actionMenu.handleAction(userInput, "");
            while(response.feedbackCode == MenuResponse.ResponseCode.BAD_REQUEST){
                System.out.println("Incorrect input detected, please select one of the below options:");
                System.out.println(actionMenu);
                userInput = keyboard.nextLine();
                response = actionMenu.handleAction(userInput, "");
            }
            if(response.feedbackCode == MenuResponse.ResponseCode.ADDITIONAL_INFO_REQUIRED){
                String[] additionalInfo = response.responseMessage.split(";");
                System.out.println(additionalInfo[1]);
                userInput = keyboard.nextLine();
                response = actionMenu.handleAction(additionalInfo[0], userInput);
            }

            System.out.println(response.responseMessage);

        }
    }

}
