package healthy.com;

public class ConsoleDisplayImpl implements ConsoleDisplay {
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
}

