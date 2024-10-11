package Actividad2.PatronesSB.AbstractFactory;

import Actividad2.PatronesSB.Domain.Producto;

import java.util.ArrayList;
import java.util.List;

public class MySQLDB implements IDAO_Producto{
    private List<Producto> productos;

    public MySQLDB() {
        this.productos = new ArrayList<>();
        productos.add(new Producto(1, "Producto MySQL A", 150.0));
        productos.add(new Producto(2, "Producto MySQL B", 250.0));
        productos.add(new Producto(3, "Producto MySQL C", 300.0));
    }

    @Override
    public void addProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public Producto obtainProducto(int id) {
        return productos.stream().filter(producto -> producto.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Producto> obtainAllProducto() {
        return productos;
    }

    @Override
    public void updateProducto(Producto producto) {
        Producto p = obtainProducto(producto.getId());
        if (p != null) {
            p.setDescription(producto.getDescription());
            p.setPrice(producto.getPrice());
        }
    }

    @Override
    public void deleteProducto(int id) {
        productos.removeIf(producto -> producto.getId() == id);
    }
}
