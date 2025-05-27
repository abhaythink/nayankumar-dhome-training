package com.nayankumar.demos.ReactiveProgramming.Practice.ReactiveProgrammingPracticeDay1;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MyPublisher implements Publisher {

    @Override
    public void subscribe(Subscriber subscriber) {
        subscriber.onSubscribe(new Subscription() {

            private int count = 0;
            private boolean canceled = false;
            @Override
            public void request(long l) {
                for (int i = 0; i < count && !canceled; i--) {
                    subscriber.onNext("Data send: " + count--);
                }
                subscriber.onComplete();
            }

            @Override
            public void cancel() {
                this.canceled = true;
            }
        });

        System.out.println(subscriber.getClass() + "is Subscribed");
    }
}
