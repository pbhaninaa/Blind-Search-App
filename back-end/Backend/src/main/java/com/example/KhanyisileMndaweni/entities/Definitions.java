package com.example.KhanyisileMndaweni.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Definitions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Definitions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "key_value") 
    private String key;
    
    private String description;
    private String information;
}
