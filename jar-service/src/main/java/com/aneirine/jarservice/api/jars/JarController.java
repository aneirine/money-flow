package com.aneirine.jarservice.api.jars;

import com.aneirine.jarservice.api.jars.domain.IdListData;
import com.aneirine.jarservice.api.jars.domain.JarData;
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

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "/users/{userId}")
    public ResponseEntity createJar(@RequestBody JarData data,
                                    @PathVariable("userId") long userId) {
        return new ResponseEntity(jarService.createJar(data, userId), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity getJarById(@PathVariable("id") long id) {
        return new ResponseEntity(jarService.getJarById(id), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getJarsByIds(@RequestBody IdListData data) {
        return new ResponseEntity(jarService.getJarsByIds(data.getList()), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity updateJarById(@RequestBody JarData data,
                                        @PathVariable("id") long id) {
        return new ResponseEntity(jarService.updateJarById(data, id), HttpStatus.OK);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity deleteJarById(@PathVariable("id") long id) {
        jarService.deleteJarById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteJarsByIds(@RequestBody IdListData data) {
        jarService.deleteJarsByIds(data.getList());
        return new ResponseEntity(HttpStatus.OK);

    }
}
