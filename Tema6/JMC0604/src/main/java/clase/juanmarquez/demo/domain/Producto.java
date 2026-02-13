package clase.juanmarquez.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Producto {
    private long id;
    private String nombre;
    private boolean enOferta;
    private TipoIva tipoIva;
    private int cantidad;
    private double precio;
}
