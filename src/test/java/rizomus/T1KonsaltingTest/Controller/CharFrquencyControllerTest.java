package rizomus.T1KonsaltingTest.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest()
public class CharFrquencyControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    CharFrquencyController charFrquencyController;

    @Test
    public void test() throws Exception {

        MockMvc mockMvc = webAppContextSetup(webApplicationContext).build();

        mockMvc.perform(get("/charfreq")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content("aaa bb c"))
//                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().string("'a':3, ' ':2, 'b':2, 'c':1."));


    }


}