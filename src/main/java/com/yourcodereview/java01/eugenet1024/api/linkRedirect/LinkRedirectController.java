package com.yourcodereview.java01.eugenet1024.api.linkRedirect;

import com.yourcodereview.java01.eugenet1024.services.linkRedirect.LinkRedirectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.net.URI;

@RestController
public class LinkRedirectController {

    public static final String REDIRECT_PATH = "/l/";
    public static final String MESSAGE_500 = "Unexpected Error. Please contact the application developers";
    public static final Logger LOGGER = LogManager.getLogger();

    private final LinkRedirectService linkRedirectService;

    @Autowired
    public LinkRedirectController(LinkRedirectService linkRedirectService) {
        this.linkRedirectService = linkRedirectService;
    }

    @RequestMapping(value = REDIRECT_PATH + "{shortLink}", method = RequestMethod.GET)
    public ResponseEntity<String> redirectToOriginalByShortLink(@PathVariable String shortLink) {

        try {
            String originalURL = linkRedirectService.getOriginalUrlByShortLink(shortLink);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(originalURL));
            return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);

        } catch (EntityNotFoundException e) {
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(MESSAGE_500, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
