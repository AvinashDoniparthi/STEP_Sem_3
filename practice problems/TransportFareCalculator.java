import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TransportFareCalculator {
    private abstract static class Transport {
        abstract double fare();
    }

    private static final class Bus extends Transport {
        private final double distance;

        private Bus(double distance) {
            this.distance = distance;
        }

        @Override
        double fare() {
            return Math.min(10, 2 + 0.10 * distance);
        }
    }

    private static final class Train extends Transport {
        private final double distance;

        private Train(double distance) {
            this.distance = distance;
        }

        @Override
        double fare() {
            return 3 + 0.15 * distance;
        }
    }

    private static final class Metro extends Transport {
        private final double distance;
        private final double peakHourFactor;

        private Metro(double distance, double peakHourFactor) {
            this.distance = distance;
            this.peakHourFactor = peakHourFactor;
        }

        @Override
        double fare() {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }
    }

    private static final class Journey {
        private final String type;
        private final Transport transport;

        private Journey(String type, Transport transport) {
            this.type = type;
            this.transport = transport;
        }
    }

    public static void main(String[] args) throws Exception {
        Week9Input input = Week9Input.read();
        int journeyCount = input.nextInt();
        List<Journey> journeys = new ArrayList<>();
        for (int index = 0; index < journeyCount; index++) {
            String type = input.next().toUpperCase(Locale.ROOT);
            double distance = input.nextDouble();
            Transport transport;
            switch (type) {
                case "BUS":
                    transport = new Bus(distance);
                    break;
                case "TRAIN":
                    transport = new Train(distance);
                    break;
                case "METRO":
                    transport = new Metro(distance, input.nextDouble());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown transport type: " + type);
            }
            journeys.add(new Journey(type, transport));
        }

        double total = 0;
        for (Journey journey : journeys) {
            double fare = journey.transport.fare();
            total += fare;
            System.out.printf(Locale.US, "%s: %.2f%n", journey.type, fare);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}