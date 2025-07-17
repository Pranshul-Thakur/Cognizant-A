public class DecoratorPatternExample {

    interface Notifier {
        void send(String message);
    }

    class EmailNotifier implements Notifier {
        public void send(String message) {
            System.out.println("Email: " + message);
        }
    }

    abstract class NotifierDecorator implements Notifier {
        protected Notifier wrappedNotifier;

        public NotifierDecorator(Notifier notifier) {
            this.wrappedNotifier = notifier;
        }

        public void send(String message) {
            wrappedNotifier.send(message);
        }
    }

    class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send(String message) {
            super.send(message);
            System.out.println("SMS: " + message);
        }
    }

    class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send(String message) {
            super.send(message);
            System.out.println("Slack: " + message);
        }
    }

    public static void main(String[] args) {
        DecoratorPatternExample app = new DecoratorPatternExample();

        Notifier notifier = app.new EmailNotifier();
        notifier = app.new SMSNotifierDecorator(notifier);
        notifier = app.new SlackNotifierDecorator(notifier);

        notifier.send("System maintenance scheduled at 10 PM.");
    }
}
