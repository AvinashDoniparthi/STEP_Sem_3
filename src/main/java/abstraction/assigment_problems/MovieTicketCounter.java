package abstraction.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class MovieTicketCounter {
    private enum SeatType {
        REGULAR(150),
        PREMIUM(250),
        RECLINER(400);

        private final double pricePerTicket;

        SeatType(double pricePerTicket) {
            this.pricePerTicket = pricePerTicket;
        }

        double bookingAmount(int count) {
            return count * (pricePerTicket + 20.0);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bookingCount = scanner.nextInt();
        double total = 0.0;

        for (int index = 0; index < bookingCount; index++) {
            String seatName = scanner.next().toUpperCase(Locale.ROOT);
            int count = scanner.nextInt();
            SeatType seatType = SeatType.valueOf(seatName);
            double amount = seatType.bookingAmount(count);
            total += amount;
            System.out.printf(Locale.US, "%s: %.2f%n", seatName, amount);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
