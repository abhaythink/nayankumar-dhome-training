import java.util.concurrent.Flow;

public class Main {
    public static void main(String[] args) {

        Flow.Publisher publisher = new MyPublisher();
        Flow.Subscriber subscriber = new MySubscriber();

        publisher.subscribe(subscriber);


        Flow.Processor processor1 = new MyProcessor();
        Flow.Processor processor2 = new MyProcessor();

        publisher.subscribe(processor1);
        processor1.subscribe(processor2);   // Processor extends both the Interfaces Publisher and Subscriber it works like a bridge
        processor2.subscribe(subscriber);



        // publisher -->  processor1 --> processor2 --> subscriber
        // publisher always upstream
        // processor1 is in downstream in terms of publisher
        // processor1 is in upstream in terms of processor2
        // processor2 is in downstream in terms of processor1
        // processor2 is in upstream in terms of subscriber
        // subscriber always downstream
    }
}