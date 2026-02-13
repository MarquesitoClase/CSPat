package com.example.app.domain;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Departamento {
    @GeneratedValue
    @Id
    Long id;
    String nombre;
    String funcion;
    @ManyToOne
    ArrayList<Empleado> TrabajadoresDep;
}
