package com.example.app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.app.dto.CambioData;

import reactor.core.publisher.Mono;

@Service
public class CambioService {
    @Autowired WebClient webClient;
    public Double calcularImporteCambiado(String monedaOrigen, String monedaDestino, Double importe){
        CambioData tasaCambio = obtenerTasaCambio(monedaOrigen, monedaDestino, importe).block();
        return importe * tasaCambio.getImporte();
    }
    public Mono<CambioData> obtenerTasaCambio(String monedaOrigen, String monedaDestino, Double importe){
        String url = "/latest?from="+monedaOrigen+"&to="+monedaDestino;
        System.out.println(url);
        return webClient.get()
        .uri(url)
        .retrieve()
        .bodyToMono(CambioData.class);
    }
}
