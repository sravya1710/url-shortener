package com.urlshortener.service;
import com.urlshortener.entity.Url;
import com.urlshortener.repository.UrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Service
public class UrlShortenerService {

    private final UrlRepo urlrepo;

    @Autowired
    public UrlShortenerService(UrlRepo urlrepo) {
        this.urlrepo = urlrepo;
    }

    public String generateShortUrl(String longUrl){

        String shortCode = UUID.randomUUID().toString().substring(0, 6);

        String shortUrl = "http://localhost:8080/u/" + shortCode;

        Url url = new Url();
        url.setLong_url(longUrl);
        url.setShort_url(shortUrl);

        urlrepo.save(url);
        return shortUrl;
    }

}
