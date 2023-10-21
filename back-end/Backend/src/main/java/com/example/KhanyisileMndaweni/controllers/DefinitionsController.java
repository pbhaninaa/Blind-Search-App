package com.example.KhanyisileMndaweni.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.KhanyisileMndaweni.entities.Definitions;
import com.example.KhanyisileMndaweni.repositories.UserRepository;
import com.example.KhanyisileMndaweni.services.DefinitionsService;

@RestController
@CrossOrigin(origins = "*")

public class DefinitionsController {
    
    @Autowired
    private DefinitionsService definitionsService;

    @Autowired
    UserRepository userRepository;

    @CrossOrigin(origins = "*")
     @PostMapping("/save")
    public ResponseEntity<Map<String, String>> saveDefinition(@RequestBody Definitions definition) {
        Map<String, String> response = definitionsService.saveDefinition(definition);
        HttpStatus status = response.containsKey("message") ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
        return new ResponseEntity<>(response, status);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/getDef/{key}")
    public Definitions getDefinition(@PathVariable String key) {
        Definitions definition = definitionsService.findByUKey(key);

        if (definition != null) {
            return definition;
        } else {
            Definitions des = new Definitions();
            des.setKey("Nothing!!");
            des.setDescription("Nothing!!");
            des.setInformation("Nothing!!");
            return des;

        }
    }

    
}
