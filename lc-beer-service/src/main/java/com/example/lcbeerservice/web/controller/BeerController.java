package com.example.lcbeerservice.web.controller;

import com.example.lcbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(("api/v1/beer"))
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId")UUID beerId){
        //todo impl
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveBeer(@RequestBody BeerDto beerDto){
        //todo impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId
            ,@RequestBody BeerDto beerDto ){
        //todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
