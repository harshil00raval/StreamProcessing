package com.example.StreamProcessing.filter;

import com.example.StreamProcessing.domain.Tweet;
import com.example.StreamProcessing.filterRegistry.SimpleFilterRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

//filter to call an api when user Harshil tweets from the location Sweden

@Component
public class StringFilter implements Filter{

    private static final Logger logger = LogManager.getLogger(StringFilter.class);


    private static final String user = "Harshil";
    private static final String location = "Sweden";

    private SimpleFilterRegistry simpleFilterRegistry;

    public StringFilter(SimpleFilterRegistry simpleFilterRegistry){
        this.simpleFilterRegistry = simpleFilterRegistry;
        this.simpleFilterRegistry.createFilter( this);
    }

    @Override public void process(Tweet tweet) {

        //check  if we can make this a predicate and pass it around
        // filter and action both are self aware and responsible for registration

        logger.info("Something happened");

        if(tweet.getUser().contentEquals(user) &&
                tweet.getLocation().contentEquals(location)){
            System.out.println("Performing Action on the tweet : " + tweet.getUser() +"  :  "+tweet.getLocation());
        }

    }


}
