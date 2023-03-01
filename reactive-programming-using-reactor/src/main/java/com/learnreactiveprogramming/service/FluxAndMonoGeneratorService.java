package com.learnreactiveprogramming.service;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Author Ahmed Shalash
 */
public class FluxAndMonoGeneratorService {

    public Flux<String> stringFlux(){
        return Flux.fromIterable(List.of("ahmed" , "ayla" , "shalash")).log(); // maybe come from api or db

        // and log for logging all events
    }

    public Flux<String> stringFlux_usingMaps(int stringLength){
        return Flux.fromIterable(List.of("asd", "shalash" , "test"))
                .map(String::toUpperCase)
                .filter(x->x.length() > stringLength)
                .log();
    }

    public Flux<String> usingFlatMap(){
        return Flux.fromIterable(List.of("ayla"))
                .map(String::toUpperCase)
                .flatMap(s->splitString(s))
                .log();
    }

    private Flux<String> splitString(String name) {

        var splittedChar = name.split("");
        return Flux.fromArray(splittedChar);


    }


    public Flux<String> stringFlux_Immutable(){
        var immutableFlux =  Flux.fromIterable(List.of("asd", "shalash" , "test"));
            immutableFlux.map(String::toUpperCase);

            return immutableFlux;
    }

    public Mono<String> stringMono(){
        return Mono.just("Shalash").log();
    }

    public static void main(String[] args) {

        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

        fluxAndMonoGeneratorService.stringFlux()
                .subscribe(name->{
                    System.out.println( " Flux is " + name);
                });

        fluxAndMonoGeneratorService.stringMono().subscribe( name -> {
            System.out.println( "Mono is ->" + name);
        });

    }


}
