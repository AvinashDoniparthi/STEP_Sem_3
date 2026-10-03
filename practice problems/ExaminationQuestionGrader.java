import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ExaminationQuestionGrader {
    private abstract static class ExamQuestion {
        private final String type;
        private final String questionText;
        private final String correctAnswer;
        private final String studentAnswer;
        private final double points;

        private ExamQuestion(String type, String questionText, String correctAnswer, String studentAnswer, double points) {
            this.type = type;
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract double score();

        String questionText() {
            return questionText;
        }

        String correctAnswer() {
            return correctAnswer;
        }

        String studentAnswer() {
            return studentAnswer;
        }

        double points() {
            return points;
        }
    }

    private static final class MultipleChoiceQuestion extends ExamQuestion {
        private MultipleChoiceQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
            super("MCQ", questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        double score() {
            return correctAnswer().equals(studentAnswer()) ? points() : 0;
        }
    }

    private static final class TrueFalseQuestion extends ExamQuestion {
        private TrueFalseQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
            super("TF", questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        double score() {
            return correctAnswer().equals(studentAnswer()) ? points() : 0;
        }
    }

    private static final class EssayQuestion extends ExamQuestion {
        private EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
            super("ESSAY", questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        double score() {
            String response = studentAnswer().toLowerCase(Locale.ROOT);
            int matchedKeywords = 0;
            for (String keyword : correctAnswer().split(",")) {
                if (response.contains(keyword.trim().toLowerCase(Locale.ROOT))) {
                    matchedKeywords++;
                }
            }
            if (matchedKeywords >= 2) {
                return points() * 0.75;
            }
            return matchedKeywords == 1 ? points() * 0.50 : 0;
        }
    }

    private static ExamQuestion createQuestion(String type, String question, String correct, String answer, double points) {
        switch (type) {
            case "MCQ":
                return new MultipleChoiceQuestion(question, correct, answer, points);
            case "TF":
                return new TrueFalseQuestion(question, correct, answer, points);
            case "ESSAY":
                return new EssayQuestion(question, correct, answer, points);
            default:
                throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }

    public static void main(String[] args) throws Exception {
        Week9Input input = Week9Input.read();
        int questionCount = input.nextInt();
        List<ExamQuestion> questions = new ArrayList<>();
        for (int index = 0; index < questionCount; index++) {
            String type = input.next().toUpperCase(Locale.ROOT);
            String question = input.next();
            String correct = input.next();
            String answer = input.next();
            double points = input.nextDouble();
            questions.add(createQuestion(type, question, correct, answer, points));
        }

        double total = 0;
        for (ExamQuestion question : questions) {
            double score = question.score();
            total += score;
            System.out.printf(Locale.US, "%s: %.2f%n", question.type, score);
        }
        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
    }
}