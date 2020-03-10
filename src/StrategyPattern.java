public class StrategyPattern {

    public static void main(String[] args) {
        MessageSender sender = new MessageSender(); // create a message sender

        sender.setMethod(new EmailSendingMethod()); // set a concrete sending method

        sender.send("alice@gmail.com", "bob@gmail.com", "Hello!");

        sender.setMethod(new SmsSendingMethod()); // set another sending method

        sender.send("1-541-444-3333", "1-541-555-2222", "Hello!");
    }
}


interface SendingMethod {

    void send(String from, String to, String msg);
}

class SmsSendingMethod implements SendingMethod {

    @Override
    public void send(String from, String to, String msg) {
        System.out.println(String.format("send SMS from '%s' to '%s'", from, to));
    }
}

class EmailSendingMethod implements SendingMethod {

    @Override
    public void send(String from, String to, String msg) {
        System.out.println(String.format("Email from '%s' to '%s'", from, to));
    }
}

class MessageSender {

    private SendingMethod method;

    // it may contain additional fields as well

    public void setMethod(SendingMethod method) {
        this.method = method;
    }

    public void send(String from, String to, String msg) {
        this.method.send(from, to, msg);
    }
}