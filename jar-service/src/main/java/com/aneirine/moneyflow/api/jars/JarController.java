package com.aneirine.moneyflow.api.jars;

import com.aneirine.moneyflow.api.jars.domain.JarData;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jars")
public class JarController {

    private final JarService jarService;

    public JarController(JarService jarService) {
        this.jarService = jarService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createJar(@RequestBody JarData data) {
        return new ResponseEntity(jarService.createJar(data), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity getJarById(@PathVariable("id") long id) {
        return new ResponseEntity(jarService.getJarById(id), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity updateJarById(@RequestBody JarData data,
                                        @PathVariable("id") long id){
        return new ResponseEntity(jarService.updateJarById(data, id), HttpStatus.OK);
    }
}
