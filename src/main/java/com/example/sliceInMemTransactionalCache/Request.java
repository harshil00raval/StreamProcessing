package com.example.sliceInMemTransactionalCache;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Request implements Runnable{


    Transaction ts;

    @Override public void run() {
        ts.executeAll();
    }
}
