package com.andreas.urlsimilarity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestB‌​uilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestB‌​uilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CompareController.class)
public class CompareControllerTest {
    
    @Autowired
    private MockMvc mvc;
    
    @Test
    public void contextLoads() {
    }

    @Test
    public void getEndpointTest() throws Exception {
        this.mvc.perform(get("/compare?site1={site1}&site2={site2}",
                "bbc.co.uk/news/uk",
                "news.sky.com/uk"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"));
    }
    
    @Test
    public void getEndpointErrorTest() throws Exception {
        this.mvc.perform(get("/compare?site1={site1}",
                "bbc.co.uk/news/uk"))
            .andExpect(status().isBadRequest());
    }
    
    @Test
    public void postEndpointTest() throws Exception {
        this.mvc.perform(post("/compare")
                .param("site1", "bbc.co.uk/news/uk")
                .param("site2", "news.sky.com/uk"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"));
    }
    
    @Test
    public void postEndpointErrorTest() throws Exception {
        this.mvc.perform(post("/compare",
                "bbc.co.uk/news/uk"))
            .andExpect(status().isBadRequest());
    }
}
