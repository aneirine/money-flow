package com.aneirine.moneyflow.entities.api.people;

import com.aneirine.moneyflow.entities.Person;
import com.aneirine.moneyflow.entities.api.people.domain.PeopleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    public Person cratePerson(PeopleData data){
        Person person = new Person() ;
        person.setEmail(data.getEmail());
        person.setUsername(data.getUsername());
        peopleRepository.save(person);
        return person;
    }
}
