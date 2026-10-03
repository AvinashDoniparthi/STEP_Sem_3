import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DeliveryFeeCalculator {
    private abstract static class Delivery {
        abstract double fee();
    }

    private static final class StandardDelivery extends Delivery {
        private final double weight;
        private final double distance;

        private StandardDelivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        @Override
        double fee() {
            return 5 + 0.50 * weight + 0.10 * distance;
        }
    }

    private static final class ExpressDelivery extends Delivery {
        private final double weight;
        private final double distance;

        private ExpressDelivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        @Override
        double fee() {
            return 15 + weight + 0.20 * distance;
        }
    }

    private static final class InternationalDelivery extends Delivery {
        private final double weight;
        private final double distance;
        private final double customsFee;

        private InternationalDelivery(double weight, double distance, double customsFee) {
            this.weight = weight;
            this.distance = distance;
            this.customsFee = customsFee;
        }

        @Override
        double fee() {
            return 25 + 2 * weight + 0.50 * distance + customsFee;
        }
    }

    private static final class DeliveryRequest {
        private final String type;
        private final Delivery delivery;

        private DeliveryRequest(String type, Delivery delivery) {
            this.type = type;
            this.delivery = delivery;
        }
    }

    public static void main(String[] args) throws Exception {
        Week9Input input = Week9Input.read();
        int requestCount = input.nextInt();
        List<DeliveryRequest> requests = new ArrayList<>();
        for (int index = 0; index < requestCount; index++) {
            String type = input.next().toUpperCase(Locale.ROOT);
            double weight = input.nextDouble();
            double distance = input.nextDouble();
            Delivery delivery;
            switch (type) {
                case "STANDARD":
                    delivery = new StandardDelivery(weight, distance);
                    break;
                case "EXPRESS":
                    delivery = new ExpressDelivery(weight, distance);
                    break;
                case "INTERNATIONAL":
                    delivery = new InternationalDelivery(weight, distance, input.nextDouble());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown delivery type: " + type);
            }
            requests.add(new DeliveryRequest(type, delivery));
        }

        double total = 0;
        for (DeliveryRequest request : requests) {
            double fee = request.delivery.fee();
            total += fee;
            System.out.printf(Locale.US, "%s: %.2f%n", request.type, fee);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}