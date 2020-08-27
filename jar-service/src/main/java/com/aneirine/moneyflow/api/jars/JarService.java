package com.aneirine.moneyflow.api.jars;

import com.aneirine.moneyflow.api.jars.domain.JarData;
import com.aneirine.moneyflow.api.jars.domain.JarResponse;
import org.springframework.stereotype.Service;

@Service
public class JarService {

    private final JarRepository jarRepository;

    public JarService(JarRepository jarRepository) {
        this.jarRepository = jarRepository;
    }

    public JarResponse createJar(JarData data) {
        return null;
    }
}
