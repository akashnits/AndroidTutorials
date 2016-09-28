package com.felight.javengers.Model;


import java.util.ArrayList;

public class Movie {
    private String title;
    private String url;
    private double rating;
    private int year;
    private ArrayList<String> genre;

    public Movie(){}

    public Movie(String title,String url, double rating, int year, ArrayList<String> genre)
    {
        this.title=title;
        this.url=url;
        this.rating = rating;
        this.year=year;
        this.genre=genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }
}
