package shop.actions;

/**
 * Created by lukas on 08.10.2017.
 */
import shop.db.Model;


public class AccountDetails implements Action {
    @Override
    public void showPrompt() {
        System.out.println("*** Account details ***\n\n" +
                "Your balance: " + Model.getInstance().getBalance() + "\tPLN\n" +
                "Purchased products:");
        for (String p : Model.getInstance().getProductsPurchased()) {
            System.out.print("\t");
            System.out.println(p);
        }
        System.out.println("\n" +
                "1. Return to Main Menu");
    }

    @Override
    public Action perform(int i) {
        switch (i) {
            case 1:
                return new MainMenu();
            default:
                return this;
        }
    }
}