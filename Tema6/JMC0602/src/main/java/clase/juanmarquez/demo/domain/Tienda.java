package clase.juanmarquez.demo.domain;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Tienda{
private double ganancias=0;
private ArrayList<Producto> productos;

public void mostrarGanancias(){
    System.out.println("Hemos ganado "+this.ganancias);
}
}