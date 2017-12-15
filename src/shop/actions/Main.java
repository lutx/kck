package shop.actions;


import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        showWelcomeMessage();
        FSM mainState = new FSM();
        mainState.runState();
    }

    private static void showWelcomeMessage() {
        String message = "\n\n Best shop in console...\n\n\n";
        System.out.println(message);
        System.out.println("1. Console app");
        System.out.println("2. GUI app");

    }


}

