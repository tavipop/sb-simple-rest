package com.pw.sb.demo;

import com.pw.sb.demo.generator.ModelGenerator;
import com.pw.sb.demo.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@RunWith(SpringRunner.class)
@SpringBootTest//(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	//@Autowired
	private WebTestClient webTestClient;

	private final ModelGenerator<Person> personGenerator = new ModelGenerator<>(Person.class);

	@Test
	public void testCreatePerson() {
		final Person person = personGenerator.generate();

		webTestClient.post().uri("/api/persons/")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.body(Mono.just(person), Person.class)
				.exchange()
				.expectStatus().isOk();
				//.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
				//.expectBody()
				//.jsonPath("$.id").isNotEmpty()
				//.jsonPath("$.text").isEqualTo("This is a Test Tweet");
	}

	@Test
	public void realCreatePerson(){
		WebClient client = WebClient.create("http://localhost:8080");
		final Person person = personGenerator.generate();

		client.post().uri("/api/persons/")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.body(Mono.just(person), Person.class)
				.exchange()
				.then();//response -> response.bodyToMono(Person.class)

		/*Mono<Person> account = client.get()
				.url("/accounts/{id}", 1L)
				.accept(APPLICATION_JSON)
				.exchange(request)
				.then(response -> response.bodyToMono(Account.class));*/
	}
}
