package Actividad2.PatronesSB.AbstractFactory;

import Actividad2.PatronesSB.Domain.Producto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PostgresqlDB implements IDAO_Producto{

    private Set<Producto> productos;

    public PostgresqlDB() {
        this.productos = new HashSet<>();
        productos.add(new Producto(1, "Producto Postgres A", 130.0));
        productos.add(new Producto(2, "Producto Postgres B", 230.0));
        productos.add(new Producto(3, "Producto Postgres C", 300.0));
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
        return (List<Producto>) productos   ;
    }

    @Override
    public void updateProducto(Producto producto) {
        productos.removeIf(p -> p.getId() == producto.getId());
        productos.add(producto);
    }

    @Override
    public void deleteProducto(int id) {
        productos.removeIf(p -> p.getId() == id);
    }
}
