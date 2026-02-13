package com.example.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CambioData {
    private Double importe;
    private String monedaOrigen;
    private String monedadestino;
}
