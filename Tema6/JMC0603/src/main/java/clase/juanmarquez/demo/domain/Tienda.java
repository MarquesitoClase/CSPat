package clase.juanmarquez.demo.domain;

import java.util.ArrayList;

public class Tienda{
private double ganancias=0;
private ArrayList<Producto> productos;
public ArrayList<Producto> getProductos() {
    return productos;
}
/**
 * @param p
 * @param cantidad
 * @param c
 * @return
 */
public boolean comprar(Producto p, int cantidad, Cliente c){
    if(this.productos.contains(p) && (this.productos.get(this.productos.indexOf(p)).getCantidad())>
    cantidad&&c.poderMonetario>(p.getPrecio()*cantidad)){
        int can=this.productos.get(this.productos.indexOf(p)).getCantidad();
        this.productos.get(this.productos.indexOf(p)).setCantidad(can-cantidad);
        this.ganancias+=cantidad*p.getPrecio();
        this.productos.get(this.productos.indexOf(p)).setCantidad(can-cantidad);
        return true;
    }
    return false;
}
public void mostrarGanancias(){
    System.out.println("Hemos ganado "+this.ganancias);
}
}