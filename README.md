

## Resilience4j Circuit Breaker: Ensuring System Stability
For complete understanding of Resilience4j Circuit Breaker and how we can integrate it inside the Spring Boot application you can checkout our blog.
<br/><br/>**Blog Link:** [Resilience4j Circuit Breaker: Ensuring System Stability](https://bootcamptoprod.com/spring-boot-resilience4j-circuit-breaker/)
<br/>

# spring-boot-resilience4j-circuit-breaker
A simple app demonstrating how we can implement circuit breaker pattern using Resilience4j in Spring Boot

## App Overview
This is a simple app wherein we are fetching the movie details based on the movie id. The movie details are fetched from external service that is called using the Spring Rest Template. For simplicity, we have created a mock controller which acts as a external service for returning the movie details.

## Circuit Breaker Scenarios
We have created a single controller endpoint which accepts movie id as path parameter and query parameter circuitBreakerType which accepts predefined set of values to mimic the different circuit breaker examples.

### Acceptable Values

#### For Path Parameter - Movie Id
a. **1** - Mock controller returns valid movie information<br/>
b. **2** - Mock controller returns valid movie information but with a delay<br/>
c. **3** - Mock controller returns HTTP status code 404<br/>
d. **4** or **any other numeric value** - Mock controller returns null which leads to MovieNotFound Exception

#### For Query Parameter - circuitBreakerType
Different circuit breaker instances are defined inside the application.yml. To mimic different circuit breaker scenarios use:<br/>
a. **count-based-circuit-breaker:** countBasedCircuitBreaker circuit breaker instance will be triggered<br/>
b. **time-based-circuit-breaker:** timeBasedCircuitBreaker circuit breaker instance will be triggered.<br/>
c. **circuit-breaker-on-exception:** circuitBreakerOnException circuit breaker instance will be triggered.<br/>
d. **circuit-breaker-with-record-failure-predicate:** circuitBreakerWithRecordFailurePredicate circuit breaker instance will be triggered.<br/>
e. **circuit-breaker-with-ignore-exception-predicate:** circuitBreakerWithIgnoreExceptionPredicate circuit breaker instance will be triggered.<br/>
f. **circuit-breaker-for-slow-calls:** circuitBreakerForSlowCalls circuit breaker instance will be triggered.<br/>
g. **circuit-breaker-with-fallback:** countBasedCircuitBreaker circuit breaker instance will be triggered and fallback method logic will be executed in this case.<br/>
h. **custom-circuit-breaker:** customCircuitBreaker circuit breaker instance defined in CircuitBreakerConfiguration class will be triggered.<br/>

## cURL Commands
Check the application logs in order to get the better understanding of different circuit breaker scenarios.

### 1. Count Based Circuit Breaker
```
curl 'http://localhost:8080/movies/3?circuitBreakerType=count-based-circuit-breaker'
```

### 2. Time Based Circuit Breaker
```
curl 'http://localhost:8080/movies/3?circuitBreakerType=time-based-circuit-breaker'
```

### 3. Circuit Breaker on Exception
```
curl 'http://localhost:8080/movies/3?circuitBreakerType=circuit-breaker-on-exception'
```

### 4. Circuit Breaker with Record Failure Predicate
```
curl 'http://localhost:8080/movies/4?circuitBreakerType=circuit-breaker-with-record-failure-predicate'
```

### 5. Circuit Breaker with Ignore Exception Predicate
```
curl 'http://localhost:8080/movies/4?circuitBreakerType=circuit-breaker-with-ignore-exception-predicate'
```

### 6. Circuit Breaker for Slow Calls
```
curl 'http://localhost:8080/movies/2?circuitBreakerType=circuit-breaker-for-slow-calls'
```

### 7. Circuit Breaker with Fallback
```
curl 'http://localhost:8080/movies/3?circuitBreakerType=circuit-breaker-with-fallback'
```

### 8. Custom Circuit Breaker
```
curl 'http://localhost:8080/movies/3?circuitBreakerType=custom-circuit-breaker'
```

## Postman Collection
Additionally, the Postman collection is available under the resources folder.
<br/>[src > main > resources > postman > Spring-Boot-Resilience4j-Circuit-Breaker.postman_collection.json]