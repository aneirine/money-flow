package com.aneirine.jarservice.api.jars;

import com.aneirine.jarservice.entities.Jar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JarRepository extends JpaRepository<Jar, Long> {


}
