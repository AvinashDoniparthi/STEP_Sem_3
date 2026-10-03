public class HackathonSeatingGridOptimizer {
    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0.0;
        }
        int total = 0;
        for (int score : row) {
            total += score;
        }
        return (double) total / row.length;
    }

    public static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < seatingScores.length; index++) {
            if (index > 0) {
                result.append(" | ");
            }
            String zone = rowAverage(seatingScores[index]) < threshold
                    ? "Quiet Zone" : "Buzzing Zone";
            result.append("Row ").append(index).append(": ").append(zone);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] scores = {{40, 50, 45}, {85, 90, 95}, {30, 20, 25}};
        System.out.println(classifyRows(scores, 60));
    }
}