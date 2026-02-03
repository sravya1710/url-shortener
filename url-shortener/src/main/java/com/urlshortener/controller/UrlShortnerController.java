package com.urlshortener.controller;

import com.urlshortener.service.UrlShortenerService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public String shortenUrl(@RequestParam String longUrl) {
        return urlService.generateShortUrl(longUrl);
    }

    @GetMapping("/redirect/{code}")
    public void redirectToLongUrl(@PathVariable String code, HttpServletResponse response) throws IOException {

        String longUrl = urlService.sendRedirect("http://localhost:8080/redirect/" + code);

        response.sendRedirect(longUrl);
    }
}
