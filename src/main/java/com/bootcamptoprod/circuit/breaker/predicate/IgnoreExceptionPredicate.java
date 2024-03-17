package com.bootcamptoprod.circuit.breaker.predicate;


import com.bootcamptoprod.circuit.breaker.exception.MovieNotFoundException;

import java.util.function.Predicate;

public class IgnoreExceptionPredicate implements Predicate<Throwable> {
    @Override
    public boolean test(Throwable throwable) {
        System.out.println("Ignore Exception predicate is called.");
        return throwable instanceof MovieNotFoundException;
    }
}