package com.bootcamptoprod.circuit.breaker.predicate;


import com.bootcamptoprod.circuit.breaker.exception.MovieNotFoundException;

import java.util.function.Predicate;

public class RecordFailurePredicate implements Predicate<Throwable> {
    @Override
    public boolean test(Throwable throwable) {
        System.out.println("Record failure predicate is called.");
        return throwable instanceof MovieNotFoundException;
    }
}
