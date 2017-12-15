package shop.actions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleApp implements CustomApp {

    State state;
    @Override
    public void runApp() {
        Scanner scanner = new Scanner(System.in);
        Action currentAction = new MainMenu();
        while (true) {
            try {
                currentAction.showPrompt();
                Integer choice = scanner.nextInt();
                currentAction = currentAction.perform(choice);
                System.out.println();
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println();
            } catch (Exception e) {
                continue;
            }
        }
    }

    @Override
    public void stopApp() {
        return;
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void changeApp(CustomApp app) {
        this.state.changeState(app);
    }
}
