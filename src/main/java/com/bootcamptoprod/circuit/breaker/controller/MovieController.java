package com.bootcamptoprod.circuit.breaker.controller;

import com.bootcamptoprod.circuit.breaker.entity.Movie;
import com.bootcamptoprod.circuit.breaker.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/movies")
public class MovieController {

    private final Logger log = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String id, @RequestParam(defaultValue = "count-based-circuit-breaker") String circuitBreakerType) {
        switch (circuitBreakerType) {
            case "count-based-circuit-breaker" -> {
                log.info("Count based circuit breaker example");
                Movie movie = movieService.getMovieDetailsWithCountBasedCircuitBreaker(id);
                return ResponseEntity.ok(movie);
            }
            case "time-based-circuit-breaker" -> {
                log.info("Time based circuit breaker example");
                Movie movie = movieService.getMovieDetailsWithTimedBasedCircuitBreaker(id);
                return ResponseEntity.ok(movie);
            }
            case "circuit-breaker-on-exception" -> {
                log.info("Circuit breaker on exception example");
                Movie movie = movieService.getMovieDetailsWithCircuitBreakerOnException(id);
                return ResponseEntity.ok(movie);
            }
            case "circuit-breaker-with-record-failure-predicate" -> {
                log.info("Circuit breaker with record failure predicate example");
                Movie movie = movieService.getMovieDetailsWithCircuitBreakerRecordFailurePredicate(id);
                return ResponseEntity.ok(movie);
            }
            case "circuit-breaker-with-ignore-exception-predicate" -> {
                log.info("Circuit breaker with ignore exception predicate example");
                Movie movie = movieService.getMovieDetailsWithCircuitBreakerIgnoreExceptionPredicate(id);
                return ResponseEntity.ok(movie);
            }
            case "circuit-breaker-for-slow-calls" -> {
                log.info("Circuit breaker for slow calls example");
                Movie movie = movieService.getMovieDetailsWithCircuitBreakerForSlowCalls(id);
                return ResponseEntity.ok(movie);
            }
            case "circuit-breaker-with-fallback" -> {
                log.info("Circuit breaker with fallback method example");
                Movie movie = movieService.getMovieDetailsWithFallbackMethod(id);
                return ResponseEntity.ok(movie);
            }
            case "custom-circuit-breaker" -> {
                log.info("Custom Circuit breaker example");
                Movie movie = movieService.getMovieDetailsWithCustomCircuitBreaker(id);
                return ResponseEntity.ok(movie);
            }
        }
        return null;
    }
}
