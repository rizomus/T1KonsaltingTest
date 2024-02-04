package rizomus.T1KonsaltingTask.Service;


import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.HashMap;

@Service

public class CharFrequencyService {

    private final HashMap<Character, Integer> charMap = new HashMap<>();
    private final TreeMap<Integer, List<Character>> sortedChars = new TreeMap<>();

    public String getCharFrequency(String str) {

        charMap.clear();
        sortedChars.clear();

        for (Character ch: str.toCharArray()) {

            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }

        for (Integer rate: charMap.values() ) {
            sortedChars.put(rate, new ArrayList<>());
        }

        for (Character ch: charMap.keySet() ) {
            int count = charMap.get(ch);
            sortedChars.get(count).add(ch);
        }


        StringBuilder resultString = new StringBuilder();
        for (Integer count: sortedChars.descendingKeySet()) {
            for (Character ch: sortedChars.get(count)) {
                resultString.append(String.format("'%c':%d, ", ch, count));
            }
        }

        resultString.replace(resultString.length() - 2, resultString.length(), ".");

        return resultString.toString();
    }
}
