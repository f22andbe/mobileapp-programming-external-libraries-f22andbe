package com.example.externallibraries;

public class WikiData {
    String wiki;
    String img;

    public WikiData(String wiki, String img) {
        this.wiki = wiki;
        this.img = img;
    }

    public String getWiki() {
        return wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }

    public String getImg() {
        return img;
    }


    @Override
    public String toString() {
        return "WikiData{" +
                "wiki='" + wiki + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
