package abstraction.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class ParcelShippingDesk {
    private abstract static class Parcel {
        protected final double weight;
        protected final double declaredValue;

        protected Parcel(double weight, double declaredValue) {
            this.weight = weight;
            this.declaredValue = declaredValue;
        }

        abstract double charge();

        double insurance() {
            return 0.0;
        }

        final double total() {
            return charge() + insurance();
        }
    }

    private static final class StandardParcel extends Parcel {
        StandardParcel(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        @Override
        double charge() {
            return 40.0 + 10.0 * weight;
        }
    }

    private static final class ExpressParcel extends Parcel {
        ExpressParcel(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        @Override
        double charge() {
            return 80.0 + 15.0 * weight;
        }

        @Override
        double insurance() {
            return declaredValue * 0.02;
        }
    }

    private static final class FragileParcel extends Parcel {
        FragileParcel(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        @Override
        double charge() {
            return 40.0 + 10.0 * weight + 50.0;
        }

        @Override
        double insurance() {
            return declaredValue * 0.02;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int parcelCount = scanner.nextInt();
        double total = 0.0;

        for (int index = 0; index < parcelCount; index++) {
            String parcelType = scanner.next().toUpperCase(Locale.ROOT);
            double weight = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();

            Parcel parcel;
            switch (parcelType) {
                case "STANDARD":
                    parcel = new StandardParcel(weight, declaredValue);
                    break;
                case "EXPRESS":
                    parcel = new ExpressParcel(weight, declaredValue);
                    break;
                case "FRAGILE":
                    parcel = new FragileParcel(weight, declaredValue);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown parcel type: " + parcelType);
            }

            double charge = parcel.charge();
            double insurance = parcel.insurance();
            double parcelTotal = parcel.total();
            total += parcelTotal;
            System.out.printf(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcelType, charge, insurance, parcelTotal);
        }

        System.out.printf(Locale.US, "Grand Total: %.2f%n", total);
    }
}
