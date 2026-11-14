package abstraction.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class CollegeFeeCounter {
    private enum StudentType {
        DAY_SCHOLAR {
            @Override
            double fee(String name) {
                return 40000.0 + 12000.0;
            }
        },
        HOSTELLER {
            @Override
            double fee(String name) {
                return 40000.0 + 60000.0;
            }
        },
        SCHOLAR {
            @Override
            double fee(String name) {
                return 20000.0 + 12000.0;
            }
        };

        abstract double fee(String name);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentCount = scanner.nextInt();
        double total = 0.0;

        for (int index = 0; index < studentCount; index++) {
            String typeName = scanner.next().toUpperCase(Locale.ROOT);
            String name = scanner.next();
            StudentType type = StudentType.valueOf(typeName);
            double fee = type.fee(name);
            total += fee;
            System.out.printf(Locale.US, "%s: %.2f%n", name, fee);
        }

        System.out.printf(Locale.US, "Total Collected: %.2f%n", total);
    }
}
