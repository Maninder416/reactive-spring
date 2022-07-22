package io.reactivestax;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
public class ReactiveSpringApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testMono(){
		Mono<String> monTest= Mono.just("Maninder").log();
		monTest.subscribe(System.out::println);

	}

	@Test
	public void testMonoError(){
		Mono<?> monoString= Mono.just("javaTechie")
						.then(Mono.error(new RuntimeException("Exception occured")))
								.log();
		monoString.subscribe(System.out::println,e-> System.out.println(e.getMessage()));
	}

	@Test
	public void testFlux(){
		Flux<String> flux= Flux.just("Maninder","Singh").concatWithValues("joshan").log();
		flux.subscribe(System.out::println);
	}

	@Test
	public void testFluxWithError(){
		Flux<String> flux= Flux.just("Tst","dataguise").
				concatWithValues("gurjeet").
				concatWith(Flux.error(new RuntimeException("Exception occured in Flux")))
				.log();
		flux.subscribe(System.out::println,e-> System.out.println(e.getMessage()));

	}
}
