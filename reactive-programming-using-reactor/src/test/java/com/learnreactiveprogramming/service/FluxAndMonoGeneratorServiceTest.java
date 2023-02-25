package com.learnreactiveprogramming.service;


import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

 public class FluxAndMonoGeneratorServiceTest {

     FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

     @Test
     void fluxAndMonosTestCases() {

         var stringFlux = fluxAndMonoGeneratorService.stringFlux();

         StepVerifier.create(stringFlux)
                 .expectNext("ahmed" , "ayla" , "shalash")
                 .expectNextCount(0)
                 .verifyComplete();
     }

     @Test
     void testMapOperators(){
         var mapFlux = fluxAndMonoGeneratorService.stringFlux_usingMaps();

         StepVerifier.create(mapFlux)
                 .expectNext("ASD", "SHALASH" , "TEST")
                 .verifyComplete();
     }


     /**
      * Prove that flux is immutable
      */
     @Test
     void testImmutable(){

         var mapFlux = fluxAndMonoGeneratorService.stringFlux_Immutable();
         StepVerifier.create(mapFlux)
                 .expectNext("ASD", "SHALASH" , "TEST")
                 .verifyComplete();
     }
 }