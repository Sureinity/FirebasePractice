package com.finalproject.lasd.Model;

public class JournalModel {
    String title, about, purl;

    public JournalModel(String title, String about, String purl) {
        this.title = title;
        this.about = about;
        this.purl = purl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
