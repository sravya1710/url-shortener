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
    private String long_url;
    private String short_url;

    public Url() {
    }

    public Url(Long id ,String long_url, String short_url) {
        this.id=id;
        this.long_url = long_url;
        this.short_url = short_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLong_url() {
        return long_url;
    }

    public void setLong_url(String long_url) {
        this.long_url = long_url;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", long_url='" + long_url + '\'' +
                ", short_url='" + short_url + '\'' +
                '}';
    }
}
