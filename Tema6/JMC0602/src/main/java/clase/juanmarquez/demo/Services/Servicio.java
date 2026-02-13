package clase.juanmarquez.demo.Services;

import org.springframework.stereotype.Service;

import clase.juanmarquez.demo.domain.Cliente;
import clase.juanmarquez.demo.domain.Producto;
import clase.juanmarquez.demo.domain.Tienda;

@Service
public class Servicio {
    public boolean comprarProducto(Producto p, int cantidad, Cliente c, Tienda t){
        if((c.getPoderMonetario()>(p.getPrecio()*cantidad))){
            c.setPoderMonetario(p.getPrecio()*cantidad);
            t.setGanancias(t.getGanancias()+cantidad);
           // t.setProductos();
            return true;
        }
        else System.out.println("No se puede realizar la venta.");
        return false;
    }
    public void añadirStock(Producto p, int cantidad, Tienda t){
        Producto mod;
        mod=t.getProductos().get(t.getProductos().indexOf(p));
        mod.setCantidad(mod.getCantidad()+cantidad);
    }
}
