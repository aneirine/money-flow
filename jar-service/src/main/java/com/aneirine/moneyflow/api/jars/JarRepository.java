package com.aneirine.moneyflow.api.jars;

import com.aneirine.moneyflow.entities.Jar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JarRepository extends JpaRepository<Jar, Long> {


    List<Jar> findAllByIdIn(List<Long> list);
}
