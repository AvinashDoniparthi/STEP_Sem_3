package abstraction.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class HomeApplianceEnergyReport {
    private enum ApplianceType {
        FRIDGE(150.0, false),
        AC(1500.0, true),
        TV(100.0, false),
        WASHER(500.0, true);

        private final double powerRating;
        private final boolean saverSupported;

        ApplianceType(double powerRating, boolean saverSupported) {
            this.powerRating = powerRating;
            this.saverSupported = saverSupported;
        }

        double unitsUsed(double hours, boolean saverMode) {
            double units = (powerRating * hours) / 1000.0;
            if (saverMode && saverSupported) {
                units *= 0.75;
            }
            return units;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int applianceCount = scanner.nextInt();
        scanner.nextLine();
        double totalCost = 0.0;

        for (int index = 0; index < applianceCount; index++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");
            String applianceName = parts[0].toUpperCase(Locale.ROOT);
            double hours = Double.parseDouble(parts[1]);
            boolean saverMode = parts.length > 2 && "SAVER".equalsIgnoreCase(parts[2]);

            ApplianceType appliance = ApplianceType.valueOf(applianceName);
            if (saverMode && !appliance.saverSupported) {
                System.out.printf(Locale.US, "%s: saver mode not supported%n", applianceName);
                continue;
            }

            double units = appliance.unitsUsed(hours, saverMode);
            double cost = units * 8.0;
            totalCost += cost;
            System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n", applianceName, units, cost);
        }

        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
    }
}
