package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Author Ahmed Shalash
 */
public class FluxAndMonoGeneratorService {


    public Flux<String> stringFlux(){
        return Flux.fromIterable(List.of("ahmed" , "ayla" , "shalash")).log(); // maybe come from api or db
    }

    public Mono<String> stringMono(){
        return Mono.just("Shalash");
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
