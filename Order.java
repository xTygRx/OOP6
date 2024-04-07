class Order{

    private NotificationSender ns;

    public Order(NotificationSender ns) {
        this.ns = ns;
    }

    public void createOrder(){
        System.out.println("Create order");
        ns.sentNotification();
    }

    public static void main(String[] args){
        Order order = new Order(new EmailSender());
        order.createOrder();
        OrderLogger logger = new OrderLogger(order);
        logger.logOrder();

    }
}
interface NotificationSender{
    public void sentNotification();

}

class EmailSender implements  NotificationSender{

    @Override
    public void sentNotification() {
        System.out.println("Call method");
    }
}

class OrderLogger{

    private Order log;

    public OrderLogger(Order log) {
        this.log = log;
    }

    public void logOrder(){
        System.out.println("add log");
    }

}

//class Order {
//    private EmailSender emailSender;
//
//    public Order(EmailSender emailSender) {
//        this.emailSender = emailSender;
//    }
//
//    public void placeOrder() {
//// Логика размещения заказа
//        emailSender.sendEmail("Ваш заказ успешно размещен.");
//    }
//}
//
//class EmailSender {
//    public void sendEmail(String message) {
//// Логика отправки электронного письма
//    }
//}