package com.example.app.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Entity
public class Movimiento {
    @Id
    @GeneratedValue
    int id;
    double cantidad;
    @ManyToOne
    @OnDelete(action=OnDeleteAction.CASCADE)
    CuentaCorriente cuentaCorrientePropietaria;
}
