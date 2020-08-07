package com.aneirine.moneyflow.entities.api.people.domain;

import com.aneirine.moneyflow.entities.api.people.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createPerson(@RequestBody PeopleData peopleData){
        return new ResponseEntity(peopleService.cratePerson(peopleData), HttpStatus.OK);
    }
}
