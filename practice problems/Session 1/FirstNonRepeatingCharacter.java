public class FirstNonRepeatingCharacter {
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        int[] frequencies = new int[Character.MAX_VALUE + 1];
        for (int index = 0; index < text.length(); index++) {
            frequencies[text.charAt(index)]++;
        }
        for (int index = 0; index < text.length(); index++) {
            char character = text.charAt(index);
            if (frequencies[character] == 1) {
                return character;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        String text = args.length == 0 ? "swiss" : String.join(" ", args);
        char result = findFirstNonRepeatingChar(text);
        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
    }
}