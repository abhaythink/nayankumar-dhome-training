package com.nayankumar.demos.ReactiveProgramming.Practice.ReactiveProgrammingPractice;

import com.nayankumar.demos.ReactiveProgramming.Practice.ReactiveProgrammingPractice.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple6;

import java.util.Locale;
import java.util.function.Consumer;

@SpringBootTest
class ReactiveProgrammingPracticeApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void workingWithMono() {
		//  Mono --> is a Publisher returns 0 or 1

//		Mono<Object> error = Mono
//				.error(new RuntimeException("ERROR"))
//				.log();
//
//		Mono<String> mono1 = Mono
//				.just("Learn Reactive Programming")
//				.log()
////				.then(error)
//				;

//		mono1.subscribe(data -> {
//			System.out.println("Data is " + data);
//		});



//		error.subscribe(System.out::println);

//		Mono<Tuple2<String, Object>> zip = Mono.zip(mono1, error);
//
//		zip.subscribe(data -> {
//			System.out.println(data.getT1());
//			System.out.println(data.getT2());
//		});

		Mono<String> stringMono = Mono
									.just("This data inside Mono")
									.doOnNext(data -> {
										simulateDelay("string Mono");
									})
									.subscribeOn(Schedulers.boundedElastic())
									.log();
		Mono<Double> doubleMono = Mono
									.just(22.036)
									.doOnNext(data -> {
										simulateDelay("Double Mono");
									})
									.subscribeOn(Schedulers.boundedElastic())
									.log();
		Mono<Boolean> booleanMono = Mono
										.just(true)
										.doOnNext(data -> {
											simulateDelay("Boolean Mono");
										})
										.log();
		Mono<Integer> integerMono = Mono
										.just(100 * 15)
										.doOnNext(data -> {
											simulateDelay("Integer Mono");
										})
										.subscribeOn(Schedulers.boundedElastic())
										.log();
		Mono<Object> objectMono = Mono
									.just(new Object())
									.doOnNext(data -> {
										simulateDelay("Object Mono");
									})
									.subscribeOn(Schedulers.boundedElastic())
									.log();
		Mono<Student> studentMono = Mono
										.just(new Student(101, 75.62, "Nayankumar"))
										.doOnNext(data -> {
											simulateDelay("Student Mono");
										})
										.subscribeOn(Schedulers.boundedElastic())
										.log();

		Mono<Tuple6<String, Double, Boolean, Integer, Object, Student>> combineMono = Mono
				.zip(stringMono,
						doubleMono,
						booleanMono,
						integerMono,
						objectMono,
						studentMono);

		combineMono.doOnNext(data -> {
			System.out.println(data.getT1().toUpperCase(Locale.ROOT));
			System.out.println(data.getT2().byteValue());
			System.out.println(data.getT3().getClass());
			System.out.println(data.getT4().getClass());
			System.out.println(data.getT5().getClass());
			System.out.println(data.getT6());
		})
				.block();
	}

	private void simulateDelay(String name) {
		System.out.println(Thread.currentThread().getName() + " --> Start: " + name);
		try {
			Thread.sleep(500); // simulate delay
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " --> End: " + name);
	}
}
