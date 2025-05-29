import java.util.concurrent.Flow;

public class MyProcessor implements Flow.Processor {        // Processor extends both the Interfaces Publisher and Subscriber it works like a bridge

    private Flow.Subscription subscription;

    @Override
    public void subscribe(Flow.Subscriber subscriber) {

        System.out.println(subscriber.getClass() + " is Subscribed!");

        subscriber.onSubscribe(new Flow.Subscription() {

            private boolean canceled = false;

            @Override
            public void request(long n) {
                while (n > 0 && !canceled) {
                    subscriber.onNext("Send: " + n--);
                }
                subscriber.onComplete();
            }

            @Override
            public void cancel() {
                this.canceled = true;
            }
        });
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(8);
        subscription.cancel();
        subscription.request(5);
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
        System.out.println("Stream completed");
    }
}
