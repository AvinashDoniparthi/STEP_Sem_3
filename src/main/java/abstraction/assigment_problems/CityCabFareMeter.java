package abstraction.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class CityCabFareMeter {
    private enum CabType {
        MINI(10.0, false),
        SEDAN(14.0, true),
        SUV(18.0, true);

        private final double ratePerKm;
        private final boolean nightServiceAvailable;

        CabType(double ratePerKm, boolean nightServiceAvailable) {
            this.ratePerKm = ratePerKm;
            this.nightServiceAvailable = nightServiceAvailable;
        }

        double fareFor(int distance, boolean isNight) {
            double fare = distance * ratePerKm;
            if (fare < 100.0) {
                fare = 100.0;
            }
            if (isNight && nightServiceAvailable) {
                fare *= 1.20;
            }
            return fare;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tripCount = scanner.nextInt();
        double total = 0.0;

        for (int index = 0; index < tripCount; index++) {
            String cabName = scanner.next().toUpperCase(Locale.ROOT);
            int distance = scanner.nextInt();
            String time = scanner.next().toUpperCase(Locale.ROOT);
            CabType cabType = CabType.valueOf(cabName);

            if (cabType == CabType.MINI && "NIGHT".equals(time)) {
                System.out.printf(Locale.US, "%s: night service not available%n", cabName);
                continue;
            }

            boolean isNight = "NIGHT".equals(time);
            double fare = cabType.fareFor(distance, isNight);
            total += fare;
            System.out.printf(Locale.US, "%s: %.2f%n", cabName, fare);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
