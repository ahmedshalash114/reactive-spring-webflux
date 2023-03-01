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
         int stringLength = 4 ;
         var mapFlux = fluxAndMonoGeneratorService.stringFlux_usingMaps(stringLength);

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

     @Test
     void usingFlatMap() {
         var usingFlatMapped = fluxAndMonoGeneratorService.usingFlatMap();

         StepVerifier.create(usingFlatMapped).expectNext("A" , "Y" , "L" , "A")
                 .verifyComplete();
     }
 }