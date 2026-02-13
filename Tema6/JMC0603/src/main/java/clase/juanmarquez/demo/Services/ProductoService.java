package clase.juanmarquez.demo.Services;

import org.springframework.stereotype.Service;

import clase.juanmarquez.demo.domain.Cliente;
import clase.juanmarquez.demo.domain.Producto;
import clase.juanmarquez.demo.domain.Tienda;

@Service
public class Servicio implements ProductoService{
    public boolean comprarProducto(Producto p, int cantidad, Cliente c, Tienda t){
        if((c.getPoderMonetario()>(p.getPrecio()*cantidad))) return true;
        return false;
    }
}
