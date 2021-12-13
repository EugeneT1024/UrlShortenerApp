package com.yourcodereview.java01.eugenet1024.api.linkGenerator;

import com.yourcodereview.java01.eugenet1024.services.linkGenerator.LinkGeneratorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LinkGeneratorController {

    public static final String GENERATE_PATH = "/generate";
    public static final String SHORT_LINKS_PATH = "/l/";
    public static final String MESSAGE_500 = "Unexpected Error. Please contact the application developers";
    public static final Logger LOGGER = LogManager.getLogger();

    private final LinkGeneratorService linkGeneratorService;

    @Autowired
    public LinkGeneratorController(LinkGeneratorService linkGeneratorService) {
        this.linkGeneratorService = linkGeneratorService;
    }

    @RequestMapping(value = GENERATE_PATH, method = RequestMethod.POST)
    public ResponseEntity<GenerateLinkResponse> generateShortLink(@Valid @RequestBody GenerateLinkRequest request) {

        try {
            GenerateLinkResponse responseBody = linkGeneratorService.generateLink(SHORT_LINKS_PATH, request);
            return new ResponseEntity<>(responseBody, HttpStatus.CREATED);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            GenerateLinkResponse responseBody = new GenerateLinkResponse();
            responseBody.setErrorMessage(MESSAGE_500);
            return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
