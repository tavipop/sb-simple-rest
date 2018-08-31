package com.pw.sb.demo.web;


import com.pw.sb.demo.generator.FluxGenerator;
import com.pw.sb.demo.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private FluxGenerator<Person> personFluxGenerator = new FluxGenerator<>();

    @GetMapping
    public Flux<Person> findAll() {
        return personFluxGenerator.generate();
    }
}