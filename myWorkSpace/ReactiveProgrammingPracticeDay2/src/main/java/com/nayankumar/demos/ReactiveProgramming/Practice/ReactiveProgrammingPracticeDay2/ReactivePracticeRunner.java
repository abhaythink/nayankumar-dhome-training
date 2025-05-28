package com.nayankumar.demos.ReactiveProgramming.Practice.ReactiveProgrammingPracticeDay2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple6;

import java.io.Serializable;
import java.time.Duration;
import java.util.ArrayList;
@Component
public class ReactivePracticeRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        runMonoExamples();
        runFilterExample();
        runFluxMapExample();
        runFlatMapManyExample();
        runMapVsFlatMapExample();
        runThenAndConcatWithExample();
        runMergeWithDelayExample();
        runZipExample();
        runCombineLatestExample();
        runOnErrorReturnExample();
        runRetryExample();
        runOnErrorResumeExample();
    }

    private static void runMonoExamples() {
        Mono<String> stringMono = Mono.just("This is a String Mono");
        stringMono.subscribe(System.out::println);

        Mono<Double> doubleMono = Mono.just(12.035);
        Mono<Boolean> booleanMono = Mono.just(true);
        Mono<Object[]> objecArrayMono = Mono.just(new Object[0]);
        Mono<ArrayList<Object>> arraylistMono = Mono.just(new ArrayList<>());
        Mono<Student> studentMono = Mono.just(new Student(33, "Nayankumar Dhome", 75.36));

        Mono<Tuple6<String, Double, Boolean, Object[], ArrayList<Object>, Student>> combinedMono =
                Mono.zip(stringMono, doubleMono, booleanMono, objecArrayMono, arraylistMono, studentMono).log();

        combinedMono.subscribe(val -> {
            System.out.println(val.getT1().getClass());
            System.out.println(val.getT2().getClass());
            System.out.println(val.getT3().getClass());
            System.out.println(val.getT4().getClass());
            System.out.println(val.getT5().getClass());
            System.out.println(val.getT6().name());
        });
    }

    private static void runFilterExample() {
        Mono<String> stringMono = Mono.just("This is a String Mono");
        stringMono.filter(val -> val.split(" ").length > 3)
                .subscribe(System.out::println,
                        e -> System.out.println(e.getMessage()),
                        () -> System.out.println("Completed without match"));
    }

    private static void runFluxMapExample() {
        Flux<Student> studentFlux = Flux.just(
                new Student(33, "Nayan", 75.21),
                new Student(274, "Rohit", 85.47),
                new Student(18, "Rumesh", 63.75),
                new Student(12, "Ketan", 66)
        ).log();
        Flux<Double> map = studentFlux.map(Student::percentage);
        map.subscribe(System.out::println);
    }

    private static void runFlatMapManyExample() {
        Mono<String> stringMono = Mono.just("This is a Mono");
        Flux<String> wordsFlux = stringMono.flatMapMany(val -> Flux.just(val.split(" ")));
        wordsFlux.subscribe(System.out::println);
    }

    private static void runMapVsFlatMapExample() {
        Flux<Integer> integerFlux = Flux.just(10, 20, 30, 40, 50);

        Flux<Integer> mapFlux = integerFlux.map(val -> val / 10).log();
        mapFlux.subscribe(System.out::println);

        Flux<Integer> flattedIntegerFlux = integerFlux.flatMap(val -> Mono.just(val / 2));
        flattedIntegerFlux.subscribe(System.out::println);

        Flux<Integer> concatedIntegerFlux = integerFlux.concatMap(val -> Mono.just(val / 2));
        concatedIntegerFlux.subscribe(System.out::println);
    }

    private static void runThenAndConcatWithExample() {
        Mono<String> stringMono = Mono.just("This is a Mono");
        Mono<Student> studentMono = Mono.just(new Student(33, "Nayankumar Dhome", 75.36));

        stringMono.then(studentMono).subscribe(System.out::println);

        Flux<Integer> integerFlux = Flux.just(10, 20, 30, 40, 50);
        Flux<Integer> flattedIntegerFlux = integerFlux.flatMap(val -> Mono.just(val / 2));
        integerFlux.thenMany(flattedIntegerFlux).subscribe(System.out::println);

        stringMono.concatWith(Mono.just("This is a Mono")).subscribe(System.out::println);
    }

    private static void runMergeWithDelayExample() throws InterruptedException {
        Flux<? extends Serializable> merge = Flux.merge(
                Flux.just(1, 2, 3).delayElements(Duration.ofMillis(300)),
                Flux.just("One", "Two", "Three").delayElements(Duration.ofMillis(200)),
                Flux.just('A', 'B', 'C').delayElements(Duration.ofMillis(400))
        );

        merge.subscribe(System.out::println);
        Thread.sleep(5000);
    }

    private static void runZipExample() {
        Flux<String> names = Flux.just("Nayan", "Rohit");
        Flux<Integer> scores = Flux.just(90, 85);

        Flux.zip(names, scores)
                .subscribe(t -> System.out.println("zip(): " + t.getT1() + " = " + t.getT2()));
    }

    private static void runCombineLatestExample() throws InterruptedException {
        Flux.combineLatest(
                Flux.just("X", "Y").delayElements(Duration.ofMillis(200)),
                Flux.just(1, 2, 3).delayElements(Duration.ofMillis(100)),
                (s, i) -> s + i
        ).subscribe(val -> System.out.println("combineLatest(): " + val));

        Thread.sleep(1000);
    }

    private static void runOnErrorReturnExample() {
        Flux<Integer> integerFlux1 = Flux.just(16, 13, 0, 21)
                .map(val -> 100 / val)
                .onErrorReturn(-1);

        integerFlux1.subscribe(System.out::println);
    }

    private static void runRetryExample() {
        Flux<Object> retryFlux = Flux.create(sink -> {
            sink.next(1);
            sink.next(2);
            sink.error(new RuntimeException("Retry after sometime"));
        }).retry(1);

        retryFlux.subscribe(
                val -> System.out.println(val),
                e -> System.out.println("Error msg: " + e.getMessage())
        );
    }

    private static void runOnErrorResumeExample() {
        Flux<Integer> integerFlux2 = Flux.just(16, 13, 0, 21)
                .map(val -> 100 / val)
                .onErrorResume(e -> Flux.just(0));

        integerFlux2.subscribe(val -> System.out.println("OnErrorResume: " + val));
    }
}
