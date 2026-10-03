public class TeamBmiCalculator {
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        }
        if (bmi < 25.0) {
            return "Normal";
        }
        if (bmi < 30.0) {
            return "Overweight";
        }
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights.length != weights.length) {
            throw new IllegalArgumentException("Height and weight counts must match");
        }
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        for (int index = 0; index < heights.length; index++) {
            if (heights[index] <= 0 || weights[index] < 0) {
                throw new IllegalArgumentException("Heights must be positive and weights non-negative");
            }
            double bmi = weights[index] / (heights[index] * heights[index]);
            System.out.printf("%6d | %10.2f | %11.1f | %5.2f | %s%n",
                    index + 1, heights[index], weights[index], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        printWellnessReport(
                new double[] {1.75, 1.60},
                new double[] {70.0, 90.0});
    }
}