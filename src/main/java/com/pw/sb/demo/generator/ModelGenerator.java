package com.pw.sb.demo.generator;

import com.pw.sb.demo.model.Person;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class ModelGenerator {

    private static PodamFactory factory = new PodamFactoryImpl();

    public static Person generate() {
        return factory.manufacturePojo(Person.class);

    }
}
