import java.util.concurrent.Flow;

public class MySubscriber implements Flow.Subscriber {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(4);                // in here we use backpressure
    }

    @Override
    public void onNext(Object item) {
        System.out.println("Resaved " + item);      // print the data that comes from Publisher
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println("Error : " + throwable.getMessage());       // if any error occur in period of data sending publisher call's onError method and send the Throwable obj
    }

    @Override
    public void onComplete() {
        System.out.println(("Stream is Complete"));     // When data successfully send then this method calls by publisher
    }
}
