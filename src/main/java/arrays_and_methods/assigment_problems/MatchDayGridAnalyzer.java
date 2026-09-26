package arrays_and_methods.assigment_problems;

public class MatchDayGridAnalyzer {
    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0.0;
        }

        int total = 0;
        for (int runs : row) {
            total += runs;
        }
        return (double) total / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder classifications = new StringBuilder();
        for (int match = 0; match < runsPerOver.length; match++) {
            if (match > 0) {
                classifications.append(" | ");
            }
            String result = rowAverage(runsPerOver[match]) >= threshold ? "Power Surge" : "Normal";
            classifications.append("Match ").append(match).append(": ").append(result);
        }
        return classifications.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {{4, 6, 8}, {10, 12, 14}, {2, 3, 1}};
        System.out.println(classifyMatches(runsPerOver, 8));
    }
}