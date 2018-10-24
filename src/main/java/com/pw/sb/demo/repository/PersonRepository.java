package com.pw.sb.demo.repository;

import com.pw.sb.demo.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PersonRepository {

    private Map<Integer, Person> personMap = new HashMap<>();

    public Mono<Person> get(final int id){
        final Person person = personMap.get(id);
        if (person == null){
            return Mono.just(person);
        }
        return Mono.empty();
    }

    public Flux<Person> getAll(){
        final Collection<Person> allPersons = personMap.values();
        return Flux.fromIterable(allPersons);
    }

    public Mono<Void> save(final Mono<Person> personMono){
        personMono.subscribe(person -> personMap.put(person.getId(), person));
        return Mono.empty();
    }
}
