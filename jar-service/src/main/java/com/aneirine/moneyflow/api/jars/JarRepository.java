package com.aneirine.moneyflow.api.jars;

import com.aneirine.moneyflow.entities.Jar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JarRepository  extends JpaRepository<Jar, Long> {
}
