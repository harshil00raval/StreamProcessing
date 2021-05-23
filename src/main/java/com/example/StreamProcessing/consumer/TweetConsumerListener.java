package com.example.StreamProcessing.consumer;

import com.example.StreamProcessing.domain.Tweet;
import com.example.StreamProcessing.filter.Filter;
import javaslang.control.Option;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Service
public class TweetConsumerListener implements TweetConsumer{

    //Check for concurency issues for multiple requests
    List<Filter> filters = new ArrayList<>();

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.group.id}",
            containerFactory = "kafkaListenerContainerFactory")
    public void consumeJson(@Payload String tweet, @Headers MessageHeaders headers) {
        System.out.println("Message from kafka: " + tweet.toString());

        publishToAllFilters(format(tweet));
    }

    @Override public void publishToAllFilters(Option<Tweet> tweet) {
        if(tweet.isDefined())
            filters.forEach(f-> f.process(tweet.get()));
    }

    @Override public Boolean addFilter(Filter filter) {
        filters.add(filter);
        return filters.contains(filter);
    }

    @Override public Boolean removeFilter(Filter filter) {
        filters.remove(filter);
        return !filters.contains(filter);
    }

    //this is sort of validation and format step
    private Option<Tweet> format(String tweet){

        Map<String, String> tweetInfo = new HashMap<>();
        JSONParser jsonParser = new JSONParser();
        JSONObject tweetDetails = null;
        try {
            tweetDetails = (JSONObject) jsonParser.parse(tweet);
        } catch (ParseException e) {
            return Option.none();
        }
        tweetInfo = new Gson().fromJson(
                String.valueOf(tweetDetails), new TypeToken<HashMap<String, String>>() {}.getType()
        );

        return Option.of(new Tweet(tweetInfo.get("user"),tweetInfo.get("hashtag"),tweetInfo.get("content"), tweetInfo.get("location")));

    }
}
