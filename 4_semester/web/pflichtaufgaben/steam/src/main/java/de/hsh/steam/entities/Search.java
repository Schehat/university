package de.hsh.steam.entities;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "search")
public class Search {

    String userName;
    Genre genre;
    Streamingprovider streamingprovider;
    Score score;

    public Search() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Streamingprovider getStreamingprovider() {
        return streamingprovider;
    }

    public void setStreamingprovider(Streamingprovider streamingprovider) {
        this.streamingprovider = streamingprovider;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

}
