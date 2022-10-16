package com.company.M2ChallengeDiazNicholas.controller;

import com.company.M2ChallengeDiazNicholas.models.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
/** Just realized that I was missing these 3 imports below.*/
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**Used Testing Exceptions with Spring MockMvc
 * https://www.baeldung.com/spring-mvc-test-exceptions for guidance.*/

@RunWith(SpringRunner.class)
@WebMvcTest(MonthController.class)
public class MonthControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnMonthEnteredByNumber() throws Exception {
        Month monthOutput = new Month(1, "January");
        monthOutput.setMonthNumber(1);
        monthOutput.setMonthName("January");
        String output = mapper.writeValueAsString(monthOutput);

    mockMvc.perform(get("/month/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(output));

    }
    @Test
    public void shouldReturnStatusCode422WhenMonthInputIsOutOfRange() throws Exception {
        mockMvc.perform(get("/month/-1"))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

        mockMvc.perform(get("/month/100"))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    public void shouldReturnRandomMonthForRandomMonth()throws Exception {
        mockMvc.perform(get("randomMonth"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").isNotEmpty())
                .andExpect(jsonPath("$.name").isNotEmpty());
    }


}