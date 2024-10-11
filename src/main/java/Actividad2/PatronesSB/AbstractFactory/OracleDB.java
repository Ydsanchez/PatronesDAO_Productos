package Actividad2.PatronesSB.AbstractFactory;

import Actividad2.PatronesSB.Domain.Producto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OracleDB implements IDAO_Producto{
    private Map<Integer, Producto> productos;

    public OracleDB() {
        this.productos = new HashMap<>();

        productos.put(1, new Producto(1, "Producto Oracle A", 180.0));
        productos.put(2, new Producto(2, "Producto Oracle B", 280.0));
        productos.put(3, new Producto(3, "Producto Oracle C", 350.0));
    }


    @Override
    public void addProducto(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    @Override
    public Producto obtainProducto(int id) {
        return productos.get(id);
    }

    @Override
    public List<Producto> obtainAllProducto() {
        return (List<Producto>) productos;
    }

    @Override
    public void updateProducto(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    @Override
    public void deleteProducto(int id) {
        productos.remove(id);
    }
}
