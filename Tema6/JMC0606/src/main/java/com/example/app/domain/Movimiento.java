package com.example.app.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class Movimiento {
    @Id
    @GeneratedValue
    int id;
    double cantidad;
}
