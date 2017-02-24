package com.chaikenintegrations.spring.tutorial.controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import javax.json.Json;
import java.io.IOException;

public class Boxrec {

    private final String content;
    private final Integer boxrecId;

    public Boxrec(String content, Integer boxrecId) {
        this.content = content;
        this.boxrecId = boxrecId;
    }

    public Integer getboxrecId() {
        return boxrecId;
    }

    public String getContent() {
        return content;
    }

    public String getData() {

        Document doc;
        try {

            // need http protocol
            doc = Jsoup.connect("http://boxrec.com/boxer/" + boxrecId).get();

            // get boxer attributes
            Elements birthName = doc.select(".boxerTitle");
            Elements wins = doc.select(".bgwonBlock span");
            Elements losses = doc.select(".bglostBlock span");
            Elements draws = doc.select(".bgdrawBlock span");
            Elements profileImage = doc.select("#profile_image");

            // build json object
            String json = Json.createObjectBuilder()
                    .add("Name", birthName.text())
                    .add("Wins", wins.text())
                    .add("Losses", losses.text())
                    .add("Draws", draws.text())
                    .add("Image", profileImage.attr("abs:src"))
                    .build()
                    .toString();

            return json;

        } catch (IOException e) {
            e.printStackTrace();
            return "error : " + e.getMessage();
        }

    }
}
