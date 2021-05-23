package com.example.StreamProcessing.filter;

import com.example.StreamProcessing.domain.Tweet;

public interface Filter {

    void process(Tweet tweet);

    default String getName() {
        return StringFilter.class.getName();
    }
}
