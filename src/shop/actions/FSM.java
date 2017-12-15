package shop.actions;

import java.util.Scanner;

public class FSM implements State {

    public static CustomApp customApp = null;

    public void runState(){
        Scanner scanner = new Scanner(System.in);

        Integer choice = scanner.nextInt();

        switch(choice)
        {
            case 1:
                customApp = new ConsoleApp();
                break;
            case 2:
                customApp = new ShoppingCart();
                break;
        }
        customApp.setState(this);
        customApp.runApp();
    }

    @Override
    public void changeState(CustomApp app) {
        customApp.stopApp();
        customApp = app;
        customApp.runApp();
    }
}
