package com.urlshortener.controller;

import com.urlshortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="api/urlshortener")

public class UrlShortnerController {

    private final UrlShortenerService urlService;

    @Autowired
    public UrlShortnerController(UrlShortenerService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/short")
    public String shortenUrl(@RequestParam String longUrl){
        return urlService.generateShortUrl(longUrl);
    }


}
