package rizomus.T1KonsaltingTask.Service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.HashMap;


@Service
public class StreamCharFrequencyService {

    private final HashMap<String, Integer> charMap = new HashMap<>();
    private final TreeMap<Integer, ArrayList<Character>> sortedChars = new TreeMap<>();

    public String getCharFrequency(String str) {

        charMap.clear();
        sortedChars.clear();

        for (String s: str.split("")) {
            charMap.compute(s, (k, v) -> (v == null) ? 1 : v + 1);
        }
        TreeMap<Integer, List<String>> sortedChars =
                charMap.keySet()
                       .stream()
                       .collect(
                               Collectors.groupingBy(charMap::get,
                                                     TreeMap::new,
                                                     Collectors.toList())
                       );

        StringBuilder resultString = new StringBuilder();
        for (Integer count: sortedChars.descendingKeySet()) {
            for (String ch: sortedChars.get(count)) {
                resultString.append(String.format("'%s':%d, ", ch, count));
            }
        }
        resultString.replace(resultString.length() - 2, resultString.length(), ".");

//        JSONObject resultJson = new JSONObject();
//        for (Integer count: sortedChars.descendingKeySet()) {
//            for (String ch: sortedChars.get(count)) {
//                resultJson.put(ch, count);
//            }
//        }

        return resultString.toString();
    }
}
