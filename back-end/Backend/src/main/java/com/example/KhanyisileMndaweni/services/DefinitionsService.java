package com.example.KhanyisileMndaweni.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.KhanyisileMndaweni.entities.Definitions;
import com.example.KhanyisileMndaweni.repositories.DefinitionsRepository;
import org.springframework.stereotype.Service;
@Service
public class DefinitionsService {
    @Autowired
    private DefinitionsRepository repository;

    public Map<String, String> saveDefinition(Definitions definition) {
        Map<String, String> response = new HashMap<>();

        if (definition.getKey().isEmpty()) {
            response.put("message", "Fields must not be empty.");
            return response;
        }

        if (repository.findByKey(definition.getKey()) != null) {
            response.put("message", "Key already exists.");
            return response;
        }

        repository.save(definition);
        response.put("message", "Definition saved successfully.");
        return response;
    }

    public Definitions findByUKey(String key) {
        return repository.findByKey(key);
    }
}


// @Service
// public class DefinitionsService {
//       @Autowired
//     private DefinitionsRepository repository;

//     public String saveDefinition(Definitions definition) {

//         if (definition.getKey().isEmpty() ) {
//             return "Fields must not be empty.";
//         }

//         if (repository.findByKey(definition.getKey()) != null ) {
//             return "Key already exists.";
//         }

//         repository.save(definition);
//         return "Definition saved successfully.";
//     }

//     public Definitions findByUKey(String key) {
//         return repository.findByKey(key);
//     }

// }
