package com.pw.sb.demo.generator;

import com.pw.sb.demo.model.Person;
import reactor.core.publisher.Flux;

public class FluxGenerator<T> {

    public Flux<Person> generate(){
        return Flux.range(0, 100000)
                .map(nr -> ModelGenerator.generate());
                //.map(Integer::toString);
                //.subscribe(System.out::println);
    }
}
