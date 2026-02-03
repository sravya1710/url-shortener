package com.urlshortener.service;
import com.urlshortener.entity.Url;
import com.urlshortener.repository.UrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;
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
        Url url = new Url();
        String shortUrl = "http://localhost:8080/redirect/" + shortCode;
        url.setLongUrl(longUrl);
        url.setShortUrl(shortUrl);
        urlrepo.save(url);
        return shortUrl;
    }

    public String sendRedirect(String shortUrl){
        Optional<Url> urlOptional = urlrepo.findByShortUrl(shortUrl);
        if(! urlOptional.isPresent()){
            throw new IllegalStateException("long url doesnt exist");
        }
        Url url = urlOptional.get();

        return url.getLongUrl();
    }

}
