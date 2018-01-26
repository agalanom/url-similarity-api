package com.andreas.urlsimilarity;

import java.io.IOException;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlSimilarityApplicationTests {
    
    @Test
    public void compareIdenticalTest() {
        float jidx = new WordUtils().compareStrings(
                "this sentence is the exactly the same",
                "this sentence is the exactly the same");
        assertThat(jidx).isEqualTo(1.0f);
    }
    
    @Test
    public void compareTest() {
        float jidx = new WordUtils().compareStrings(
                "this is a book",
                "this is an apple");
        assertThat(jidx).isEqualTo((float)1/3);
    }
    
    @Test
    public void compareSameWebsiteTest() throws IOException {
        float jidx = new WebUtils().compareWebsites(
                "http://en.wikipedia.org/wiki/Main_Page",
                "https://en.wikipedia.org/wiki/Main_Page");
        assertThat(jidx).isEqualTo((float)1);
    }
    
    @Test
    public void compareWebsiteTest() throws IOException {
        float jidx = new WebUtils().compareWebsites(
                "bbc.co.uk/news/uk",
                "news.sky.com/uk");
        assertThat(jidx).isLessThan((float)1);
    }
}
