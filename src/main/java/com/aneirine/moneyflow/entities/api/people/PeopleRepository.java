package com.aneirine.moneyflow.entities.api.people;

import com.aneirine.moneyflow.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<Person, Long> {
}
