package com.dam.breakingbadexcercise.adapter;

public class QuoteItem {

    private String quote;
    private String author;

    public QuoteItem(String quote, String author) {
        this.quote = quote;
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }
}
