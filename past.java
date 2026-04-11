import java.nio.file.*;
import java.util.List;
import java.util.Map;
import java.io.IOException;
java.util.*;
public class past {
     public String countdown(char[] letters, Path dictionary){
        // edge
        if (dictionary == null || letters == null || letters.length == 0) return "";

        List<String> words;
        words = Files.readAllLines(dictionary);

        if (words.isEmpty()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char c : letters) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        String longest = "";
        for (String word : words) {
            
        }
     }
}
