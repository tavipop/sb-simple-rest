package com.pw.sb.demo.web;


import com.pw.sb.demo.generator.FluxGenerator;
import com.pw.sb.demo.model.Person;
import com.pw.sb.demo.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class PersonController {

    private PersonRepository repository = new PersonRepository();

    /*@GetMapping(name = "/api/persons/")
    public Flux<Person> getAll() {
        final FluxGenerator<Person> personFluxGenerator = new FluxGenerator<>(Person.class, 100);
        return personFluxGenerator.generate();
    }*/


    @GetMapping(name = "/api/persons/")
    public Flux<Person> getAll() {
        return Flux.from(repository.getAll());
        /*final FluxGenerator<Person> personFluxGenerator = new FluxGenerator<>(Person.class, 100);
        return personFluxGenerator.generate();*/
    }

    @GetMapping(value = "/api/persons/{count}")
    public Flux<Person> getSome(@PathVariable("count") Integer count) {
        final FluxGenerator<Person> personFluxGenerator = new FluxGenerator<>(Person.class, count);
        System.out.println("Generating " + count + " persons");
        return personFluxGenerator.generate();
    }

    @PostMapping(value = "/api/persons/")
    public Mono<Void> create(@RequestBody Person person) {
        System.out.println("Creating new person");
        return this.repository.save(Mono.just(person)).then();
    }
}