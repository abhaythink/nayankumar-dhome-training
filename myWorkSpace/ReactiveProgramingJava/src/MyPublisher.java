import java.util.concurrent.Flow;

public class MyPublisher implements Flow.Publisher {

    @Override
    public void subscribe(Flow.Subscriber subscriber) {

        System.out.println(subscriber.getClass() + " is Subscribed");

        subscriber.onSubscribe(new Flow.Subscription() {

            private int count = 1;
            private boolean canceled = false;   // it is used for if subscriber calls canceled method then the onNext() method immediately stops

            @Override
            public void request(long l) {                       // design the mechanism for backpressure this is introduced in Java 9
                for (int i = 0; i < l && !canceled; i++) {
                    subscriber.onNext("Data: " + count++);      // one every onNext we send data in here we send count for visually understand how many times onNext() method called
                }
                subscriber.onComplete();        // onComplete method call becz the data successfully send
            }

            @Override
            public void cancel() {
                this.canceled = true;           // instantly change the cancel status
            }
        });
    }
}
