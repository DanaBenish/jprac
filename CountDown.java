import java.nio.file.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;

public class CountDown {
    public String countdown(char[] letters, Path dictionary) throws IOException {
        // edge
        if (dictionary == null || letters == null || letters.length == 0)
            return "";

        List<String> words;
        words = Files.readAllLines(dictionary);

        if (words.isEmpty())
            return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char c : letters) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        String longest = "";
        for (String word : words) {
            if (word.length() > letters.length)
                continue;
            if (word.length() <= longest.length())
                continue;
            if (canForm(word, map)) {
                longest = word;
            }
        }
        return longest.isEmpty() ? "NO WORDs" : longest;
    }

    private boolean canForm(String word, Map<Character, Integer> map) {
        Map<Character, Integer> tempMap = new HashMap<>(map);
        for (char c : word.toCharArray()) {
            // Count how many times this letter appears in the word
            tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);

            // If the word uses more of a letter than available → invalid
            if (tempMap.get(c) > tempMap.getOrDefault(c, 0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        CountDown c = new CountDown();

        // Test letters
        char[] letters = { 'R', 'T', 'E', 'T', 'N' };

        // Path to your dictionary file
        Path path = Paths.get("dictionary.txt");

        String result = c.countdown(letters, path);

        System.out.println("Result: " + result);
    }

}
