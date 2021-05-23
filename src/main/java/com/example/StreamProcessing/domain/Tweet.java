package com.example.StreamProcessing.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Tweet {
    private final String user;
    private final String hashTag;
    private final String content;
    private final String location;
}
