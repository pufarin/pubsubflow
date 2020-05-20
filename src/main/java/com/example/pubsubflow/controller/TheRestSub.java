package com.example.pubsubflow.controller;

import com.example.pubsubflow.flow.TheSubscriber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheRestSub {

    TheSubscriber theSubscriber;

    public TheRestSub(TheSubscriber theSubscriber) {
        this.theSubscriber = theSubscriber;
    }

    @GetMapping("get/data")
    public String getData() throws InterruptedException {
        String myUUID = "123";
        while (!myUUID.equals(theSubscriber.getUuid())){
            Thread.sleep(1);
        }
        return theSubscriber.getUuid();
    }

}
