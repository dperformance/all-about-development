package tobyspring.hellospring;

public class PaymentService {
    public Payment prepare() {
        return new Payment();
    }

    public static void main(String[] args) {
        Payment payment = new Payment();
        System.out.println(payment);
    }
}
