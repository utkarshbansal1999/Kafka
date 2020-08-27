package com.example.producer.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String name;
    private String tech;
    private Long price;
}
