package com.example.sliceInMemTransactionalCache;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Operation {

    private final String operation;
    private final String key;
    private final String value;
}
