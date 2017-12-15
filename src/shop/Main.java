package shop;




        import shop.actions.Action;
        import shop.actions.MainMenu;

        import java.util.InputMismatchException;
        import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        showWelcomeMessage();

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

    private static void showWelcomeMessage() {
        String message = "\n\n Best shop in console...\n\n\n";

        System.out.println(message);

    }
}

