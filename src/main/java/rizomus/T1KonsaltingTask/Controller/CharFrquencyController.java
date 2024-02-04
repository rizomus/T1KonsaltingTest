package rizomus.T1KonsaltingTask.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rizomus.T1KonsaltingTask.Service.CharFrequencyService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * контроллер возвращает частоту встречи символов по заданной строке
 */

@RestController
public class CharFrquencyController {

    private CharFrequencyService charFrequencyService;

    @Autowired
    public CharFrquencyController(CharFrequencyService charFrequencyService) {
        this.charFrequencyService = charFrequencyService;
    }

    private HashMap<Character, Integer> charMap = new HashMap<>();
    private TreeMap<Integer, ArrayList<Character>> sortedChars = new TreeMap<>();

    @GetMapping("/charfreq")
    @Operation(summary = "Returns the number of occurrences of each character in a string" )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ОК", content = {@Content(mediaType = "text/plain;charset=UTF-8")}),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema(defaultValue = "The request body must contain the string"))})
                    })
    public String charFrequency(@RequestBody String str, HttpServletRequest request, HttpServletResponse response) {

        response.setStatus(HttpStatus.OK.value());
        return charFrequencyService.getCharFrequency(str);
    }
}
