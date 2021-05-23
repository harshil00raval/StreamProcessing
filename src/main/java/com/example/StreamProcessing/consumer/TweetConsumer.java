package com.example.StreamProcessing.consumer;

import com.example.StreamProcessing.domain.Tweet;
import com.example.StreamProcessing.filter.Filter;
import javaslang.control.Option;

public interface TweetConsumer {

    void publishToAllFilters(Option<Tweet> tweet);
    Boolean addFilter(Filter filter);
    Boolean removeFilter(Filter filter);
}
