package Week1.DecoratorPatternExample;

public class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // delegate to previous
        System.out.println("Slack message sent: " + message);
    }
}
