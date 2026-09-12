public class Word_Reversal_Encoder {
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String reversedWord = new StringBuilder(words[i]).reverse().toString();
            if (i > 0) {
                result.append(" ");
            }
            result.append(reversedWord);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club"));
    }
}
