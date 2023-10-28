import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTableWithWordValues {

    public static Map<String, Integer> createHashTable(List<String> words) {
        Map<String, Integer> hashTable = new HashMap<>();

        for (String word : words) {
            int wordValue = calculateWordValue(word);
            hashTable.put(word, wordValue);
        }

        return hashTable;
    }

    public static int calculateWordValue(String word) {
        int sum = 0;

        for (char letter : word.toCharArray()) {
            // Converte a letra para minúscula para garantir consistência
            letter = Character.toLowerCase(letter);

            if (letter >= 'a' && letter <= 'z') {
                int letterValue = letter - 'a' + 1; // Posição da letra no alfabeto
                sum += letterValue;
            }
        }

        return sum % 7;
    }

    public static void main(String[] args) {
        List<String> words = List.of("beto", "rose", "ana", "eto", ");

        Map<String, Integer> hashTable = createHashTable(words);

        for (String word : words) {
            int wordValue = hashTable.get(word);
            System.out.println("Word: " + word + ", Hash Value: " + wordValue);
        }
    }
}

