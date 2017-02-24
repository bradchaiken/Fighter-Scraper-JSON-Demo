package com.chaikenintegrations.spring.tutorial.controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import javax.json.Json;
import java.io.IOException;

public class Sherdog {

    private final String content;
    private final Integer sherdogId;

    public Sherdog(String content, Integer sherdogId) {
        this.content = content;
        this.sherdogId = sherdogId;
    }

    public Integer getsherdogId() {
        return sherdogId;
    }

    public String getContent() {
        return content;
    }

    public String getData() {

        Document doc;
        try {

            // need http protocol
            doc = Jsoup.connect("http://www.sherdog.com/fighter/" + sherdogId).get();

            // get page title
            String title = doc.title();

            // get fighter attributes
            Elements birthName = doc.select(".fn");
            Elements wins = doc.select("body > div.container > div:nth-child(3) > div.col_left > section:nth-child(2) > div > div.content > div:nth-child(1) > div > div.record > div > div.left_side > div:nth-child(1) > span.card > span.counter");
            Elements losses = doc.select("body > div.container > div:nth-child(3) > div.col_left > section:nth-child(2) > div > div.content > div:nth-child(1) > div > div.record > div > div.left_side > div.bio_graph.loser > span.card > span.counter");
            Elements profileImage = doc.select(".profile_image");

            // build json object
            String json = Json.createObjectBuilder()
                    .add("Name", birthName.text())
                    .add("Wins", wins.text())
                    .add("Losses", losses.text())
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

