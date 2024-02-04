package rizomus.T1KonsaltingTask.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StreamCharFrequencyServiceTest {

    @InjectMocks
    private StreamCharFrequencyService streamCharFrequencyService;

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    public void CharFrequencyIsCorrectTest() {

        String requestString = "a bb ccc";
        assertEquals("'c':3, ' ':2, 'b':2, 'a':1.", streamCharFrequencyService.getCharFrequency(requestString));
    }
}