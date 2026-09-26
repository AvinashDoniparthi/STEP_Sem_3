package arrays_and_methods.assigment_problems;

public class TopPerformerTracker {
    public static String findMinMaxSpread(int[] scores) {
        int minimum = scores[0];
        int maximum = scores[0];

        for (int score : scores) {
            if (score < minimum) {
                minimum = score;
            }
            if (score > maximum) {
                maximum = score;
            }
        }

        return "Min: " + minimum + " | Max: " + maximum + " | Spread: " + (maximum - minimum);
    }

    public static void main(String[] args) {
        System.out.println(findMinMaxSpread(new int[]{45, 82, 79, 90, 33, 90, 61}));
    }
}