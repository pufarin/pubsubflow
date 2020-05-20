package com.example.pubsubflow.controller;

import com.example.pubsubflow.flow.TheSubscriber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.SubmissionPublisher;

@RestController
public class TheRestPub {

    SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
    TheSubscriber theSubscriber;

    public TheRestPub(TheSubscriber theSubscriber){
        this.theSubscriber = theSubscriber;
        publisher.subscribe(theSubscriber);

    }


    @GetMapping("produce/data/{param}")
    public String produceData(@PathVariable String param){

        publisher.submit(param);
        return "This is the: " + param;
    }
}
