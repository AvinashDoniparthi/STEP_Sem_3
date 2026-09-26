import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stop_Word_Filtered_Word_Frequency_Report {
    public static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        Set<String> stopSet = new HashSet<>(Arrays.asList(stopWords));

        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "");

        String[] words = cleaned.split("\\s+");
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            String cleanWord = word.trim();
            if (cleanWord.isEmpty() || stopSet.contains(cleanWord)) {
                continue;
            }
            frequencyMap.put(cleanWord, frequencyMap.getOrDefault(cleanWord, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());
        Collections.sort(entries, (e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
