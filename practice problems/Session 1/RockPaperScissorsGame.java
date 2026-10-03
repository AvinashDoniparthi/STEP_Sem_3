import java.util.Random;

public class RockPaperScissorsGame {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    public static String playRound(String playerMove, String computerMove) {
        String player = normalizeMove(playerMove);
        String computer = normalizeMove(computerMove);

        if (player.equals(computer)) {
            return "Draw";
        }
        if ((player.equals("Rock") && computer.equals("Scissors"))
                || (player.equals("Paper") && computer.equals("Rock"))
                || (player.equals("Scissors") && computer.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    private static String normalizeMove(String move) {
        for (String validMove : MOVES) {
            if (validMove.equalsIgnoreCase(move)) {
                return validMove;
            }
        }
        throw new IllegalArgumentException("Move must be Rock, Paper, or Scissors");
    }

    public static void playRounds(String[] playerMoves) {
        Random random = new Random();
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Round | Player | Computer | Result");
        for (int index = 0; index < playerMoves.length; index++) {
            String computerMove = MOVES[random.nextInt(MOVES.length)];
            String result = playRound(playerMoves[index], computerMove);
            System.out.printf("%5d | %-6s | %-8s | %s%n",
                    index + 1, normalizeMove(playerMoves[index]), computerMove, result);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage = playerMoves.length == 0
                ? 0.0 : wins * 100.0 / playerMoves.length;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %%: %.1f%%%n",
                wins, losses, draws, winPercentage);
    }

    public static void main(String[] args) {
        playRounds(new String[] {"Rock", "Paper", "Scissors", "Rock", "Paper"});
    }
}