package shop.actions;

/**
 * Created by lukas on 08.10.2017.
 */

public interface Action {
    void showPrompt();
    Action perform(int i);
}