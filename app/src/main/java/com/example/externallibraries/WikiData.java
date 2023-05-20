package com.example.externallibraries;

public class WikiData {
    String wiki;


    public WikiData(String wiki, String img) {
        this.wiki = wiki;

    }

    public String getWiki() {
        return wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }



    @Override
    public String toString() {
        return "WikiData{" +
                "wiki='" + wiki + '\'' +
                '}';
    }
}
