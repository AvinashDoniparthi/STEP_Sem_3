import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PaymentFeeCalculator {
    private abstract static class PaymentMethod {
        abstract double adjustedAmount(double amount);
    }

    private static final class CardPayment extends PaymentMethod {
        @Override
        double adjustedAmount(double amount) {
            return amount * 1.02;
        }
    }

    private static final class WalletPayment extends PaymentMethod {
        @Override
        double adjustedAmount(double amount) {
            return amount * 1.01;
        }
    }

    private static final class BankTransferPayment extends PaymentMethod {
        @Override
        double adjustedAmount(double amount) {
            return amount;
        }
    }

    private static final class Transaction {
        private final String type;
        private final PaymentMethod method;
        private final double amount;

        private Transaction(String type, PaymentMethod method, double amount) {
            this.type = type;
            this.method = method;
            this.amount = amount;
        }
    }

    private static PaymentMethod createPaymentMethod(String type) {
        switch (type) {
            case "CARD":
                return new CardPayment();
            case "WALLET":
                return new WalletPayment();
            case "BANKTRANSFER":
                return new BankTransferPayment();
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void main(String[] args) throws Exception {
        Week9Input input = Week9Input.read();
        int transactionCount = input.nextInt();
        List<Transaction> transactions = new ArrayList<>();
        for (int index = 0; index < transactionCount; index++) {
            String type = input.next().toUpperCase(Locale.ROOT);
            transactions.add(new Transaction(type, createPaymentMethod(type), input.nextDouble()));
        }

        double total = 0;
        for (Transaction transaction : transactions) {
            double adjusted = transaction.method.adjustedAmount(transaction.amount);
            total += adjusted;
            System.out.printf(Locale.US, "%s: %.2f%n", transaction.type, adjusted);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}