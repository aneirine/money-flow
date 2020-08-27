package com.aneirine.moneyflow.api.jars;

import com.aneirine.moneyflow.api.jars.domain.JarData;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jars")
public class JarController {

    private final JarService jarService;

    public JarController(JarService jarService) {
        this.jarService = jarService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createJar(@RequestBody JarData data){
        return new ResponseEntity(jarService.createJar(data), HttpStatus.OK);
    }
}
