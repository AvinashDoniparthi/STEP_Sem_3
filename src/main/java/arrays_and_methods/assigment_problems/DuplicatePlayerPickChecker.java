package arrays_and_methods.assigment_problems;

public class DuplicatePlayerPickChecker {
    public static String findDuplicatePick(String[] playerNames) {
        for (int first = 0; first < playerNames.length; first++) {
            for (int next = first + 1; next < playerNames.length; next++) {
                if (playerNames[first].equals(playerNames[next])) {
                    return "Duplicate Found: " + playerNames[first];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println(findDuplicatePick(new String[]{"Kohli", "Bumrah", "Kohli", "Rohit"}));
        System.out.println(findDuplicatePick(new String[]{"Kohli", "Bumrah", "Rohit"}));
    }
}