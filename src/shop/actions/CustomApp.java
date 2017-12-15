package shop.actions;

interface CustomApp {
    void runApp();
    void stopApp();
    void setState(State state);
    void changeApp(CustomApp app);
}
