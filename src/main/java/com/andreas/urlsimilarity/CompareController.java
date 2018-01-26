package com.andreas.urlsimilarity;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/compare")
public class CompareController {
    
    @RequestMapping(params = { "site1", "site2" }, method = GET)
    @ResponseBody
    public float get(
        @RequestParam("site1") String site1,
        @RequestParam("site2") String site2,
        HttpServletRequest request) throws IOException {
            Logger.getLogger(CompareController.class.getName()).log(Level.INFO,
                    "GET /compare request from {0}", request.getRemoteAddr());
            try {
                return new WebUtils().compareWebsites(site1, site2);
            } catch (IOException ex) {
                Logger.getLogger(CompareController.class.getName()).log(
                        Level.SEVERE, null, ex);
                throw ex;
            }
    }
    
    @RequestMapping(params = { "site1", "site2" }, method = POST)
    public float post(
        @RequestParam("site1") String site1,
        @RequestParam("site2") String site2,
        HttpServletRequest request)throws IOException {
            Logger.getLogger(CompareController.class.getName()).log(Level.INFO,
                    "POST /compare request from {0}", request.getRemoteAddr());
            try {
                return new WebUtils().compareWebsites(site1, site2);
            } catch (IOException ex) {
                Logger.getLogger(CompareController.class.getName()).log(
                        Level.SEVERE, null, ex);
                throw ex;
            }
    }
}
