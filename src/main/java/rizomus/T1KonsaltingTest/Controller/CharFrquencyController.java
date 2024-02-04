package rizomus.T1KonsaltingTest.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

@RestController
public class CharFrquencyController {

    private HashMap<Character, Integer> charMap = new HashMap<>();
    private TreeMap<Integer, ArrayList<Character>> sortedChars = new TreeMap<>();

    @GetMapping("/charfreq")
    @Operation(summary = "Returns the number of occurrences of each character in a string" )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ОК", content = {@Content(mediaType = "text/plain;charset=UTF-8")}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema(defaultValue = "The request body must contain the string"))})
                    })
    public String charFrequency(@RequestBody String str, HttpServletRequest request, HttpServletResponse response) {

        charMap.clear();
        sortedChars.clear();

//        Arrays.stream(str.split("")).collect(Collectors.groupingBy())

        for (Character ch: str.toCharArray()) {

            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }
        int count = 0;                  // number of occurrences of the character
        ArrayList<Character> arr;       // chars with same count
        for (Character ch: charMap.keySet() ) {
            count = charMap.get(ch);
            if (sortedChars.containsKey(count)) {
                arr = sortedChars.get(count);
                arr.add(ch);
            } else {
                arr = new ArrayList<>();
                arr.add(ch);
            }
            sortedChars.put(charMap.get(ch), arr);
        }

        String resultString = "";
        int i = 0;
        for (Integer rate: sortedChars.descendingKeySet()) {
            arr = sortedChars.get(rate);
            for (Character ch: arr) {
                resultString += String.format("'%c':%d, ", ch, rate);
            }
        }

        resultString = resultString.substring(0, resultString.length() - 2) + ".";
        response.setStatus(HttpStatus.OK.value());
        return resultString;
    }
}
