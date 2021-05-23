package com.example.StreamProcessing.filter;

import com.example.StreamProcessing.domain.Tweet;
import com.example.StreamProcessing.filterRegistry.SimpleFilterRegistry;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//filter to call an api when user Harshil tweets 3 times
@Component
public class  NumberFilter implements Filter{

    private static Integer noOfTweets = 3;
    private static String user = "Harshil";

    private List<Tweet> tweets = new ArrayList<>();


    private SimpleFilterRegistry simpleFilterRegistry;

    public NumberFilter(SimpleFilterRegistry simpleFilterRegistry){
        this.simpleFilterRegistry = simpleFilterRegistry;
        this.simpleFilterRegistry.createFilter(this);
    }

    @Override public void process(Tweet tweet) {

        if(user.equals(tweet.getUser())){
            tweets.add(tweet);
            if(noOfTweets == tweets.size()){
                System.out.println("Harshil tweeted 3 times");
                tweets.clear();
            }
        }
    }
}
