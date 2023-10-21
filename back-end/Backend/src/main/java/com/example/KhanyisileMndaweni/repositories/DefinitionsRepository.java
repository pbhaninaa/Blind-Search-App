package com.example.KhanyisileMndaweni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.KhanyisileMndaweni.entities.Definitions;

public interface DefinitionsRepository extends JpaRepository<Definitions, Long> {
  
    Definitions findByKey(String key);
}