package com.nayankumar.demos.ReactiveProgramming.Practice.ReactiveProgrammingPracticeDay1;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySubscriber implements Subscriber {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(4);
    }

    @Override
    public void onNext(Object item) {
        System.out.println("Resaved " + item);
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println("Error : " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(("Stream is Complete"));
    }
}
