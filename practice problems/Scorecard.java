public class Scorecard {
    private final boolean[] results;
    private int recordedAnswers;

    public Scorecard(int questionCount) {
        if (questionCount < 0) {
            throw new IllegalArgumentException("Question count cannot be negative");
        }
        results = new boolean[questionCount];
    }

    public boolean recordAnswer(boolean correct) {
        if (recordedAnswers == results.length) {
            return false;
        }
        results[recordedAnswers++] = correct;
        return true;
    }

    public int getScore() {
        int score = 0;
        for (int index = 0; index < recordedAnswers; index++) {
            if (results[index]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard scorecard = new Scorecard(4);
        scorecard.recordAnswer(true);
        scorecard.recordAnswer(true);
        scorecard.recordAnswer(false);
        scorecard.recordAnswer(true);
        System.out.println("Score: " + scorecard.getScore());
    }
}