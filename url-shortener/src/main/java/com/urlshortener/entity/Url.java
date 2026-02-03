package com.urlshortener.entity;


// Entity class - represents the Database Table
// this creates a table with long rul and short url columns


import jakarta.persistence.*;

@Entity
@Table(name="url_shortener_db")

public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String longUrl;
    private String shortUrl;

    public Url() {
    }

    public Url(Long id ,String longUrl, String shortUrl) {
        this.id=id;
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", long_url='" + longUrl + '\'' +
                ", short_url='" + shortUrl + '\'' +
                '}';
    }
}
