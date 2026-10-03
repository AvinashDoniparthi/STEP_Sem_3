import java.util.Arrays;

public class PlacementShortlistingEngine {
    public static final class Candidate implements Comparable<Candidate> {
        private final String name;
        private final double cgpa;
        private final int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        private double compositeScore() {
            return cgpa * 10.0 + codingScore / 2.0;
        }

        @Override
        public int compareTo(Candidate other) {
            int scoreOrder = Double.compare(other.compositeScore(), compositeScore());
            return scoreOrder != 0 ? scoreOrder : name.compareTo(other.name);
        }

        @Override
        public String toString() {
            return name + " (" + String.format("%.1f", compositeScore()) + ")";
        }
    }

    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;
        for (Candidate candidate : candidates) {
            if (isEligible(candidate.cgpa)
                    || isEligible(candidate.cgpa, candidate.codingScore)) {
                shortlisted[count++] = candidate;
            }
        }
        shortlisted = Arrays.copyOf(shortlisted, count);
        Arrays.sort(shortlisted);

        StringBuilder result = new StringBuilder();
        for (int index = 0; index < shortlisted.length; index++) {
            if (index > 0) {
                result.append(" | ");
            }
            result.append(index + 1).append(". ").append(shortlisted[index]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}