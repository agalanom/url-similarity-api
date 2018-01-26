package com.andreas.urlsimilarity;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 
 * @author Andrew
 * Utilities for getting and comparing the content of a web page
 */
public class WebUtils {
    
    /**
     * Gets the plain text of a web page
     * @param url
     * @return
     * @throws IOException
     */
    public String getWebpageContent(String url) throws IOException {
        if (!url.matches("^http[s]?://.*")) {
            url = "http://" + url;
        }
        Document doc = Jsoup.connect(url).followRedirects(true).get();
        Logger.getLogger(WebUtils.class.getName()).log(Level.INFO, String.format("Got content for %s",doc.baseUri()));
        return doc.text();
    }
    
    /**
     * Compare two web sites using the Jaccard similarity index
     * @param url1
     * @param url2
     * @return The Jaccard similarity index
     * @throws IOException
     */
    public float compareWebsites(String url1, String url2) throws IOException {
        return new WordUtils().compareStrings(getWebpageContent(url1), getWebpageContent(url2));
    }
}
