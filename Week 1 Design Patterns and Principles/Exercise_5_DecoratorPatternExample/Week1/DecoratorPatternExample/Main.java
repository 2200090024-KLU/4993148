package Week1.DecoratorPatternExample;

public class Main {
    public static void main(String[] args) {
        // Base Notifier
        Notifier email = new EmailNotifier();

        // Add SMS on top of Email
        Notifier sms = new SMSNotifierDecorator(email);

        // Add Slack on top of SMS and Email
        Notifier slack = new SlackNotifierDecorator(sms);

        // Send a message
        slack.send("Project deadline is tomorrow!");
    }
}
