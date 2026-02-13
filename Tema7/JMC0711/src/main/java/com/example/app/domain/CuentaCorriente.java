package com.example.app.domain;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class CuentaCorriente {
    @Id
    String iban;
    String nombre;
    Double saldo;

}
