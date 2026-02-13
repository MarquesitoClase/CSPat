package clase.juanmarquez.demo.Services;

import clase.juanmarquez.demo.domain.Cliente;
import clase.juanmarquez.demo.domain.Producto;
import clase.juanmarquez.demo.domain.Tienda;

public interface ProductoService {
    public boolean comprarProducto(Producto p, int cantidad, Cliente c, Tienda t);
}
