package com.example.pubsubflow.flow;

import org.springframework.stereotype.Component;

import java.util.concurrent.Flow;

@Component
public class TheSubscriber implements Flow.Subscriber<String> {
    private Flow.Subscription subscription;

    static String uuid;

    public static String getUuid() {
        return uuid;
    }

    public static void setUuid(String uuid) {
        TheSubscriber.uuid = uuid;
    }

    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        System.out.printf("Subscribed");
        subscription.request(1);
    }

    public void onNext(String message) {
        System.out.printf("%d: Received '%s'\n", this.hashCode(), message);
        this.setUuid(message);
        this.subscription.request(1);
    }

    public void onError(Throwable throwable) {
        System.out.printf("%d: Error %s\n", this.hashCode(), throwable.getMessage());
    }

    public void onComplete() {
        System.out.printf("Completed");

    }
}
