package Actividad2.PatronesSB.AbstractFactory;

import Actividad2.PatronesSB.Domain.Producto;

import java.util.List;

public interface IDAO_Producto {
    void addProducto(Producto producto);
    Producto obtainProducto(int id);
    List<Producto> obtainAllProducto();
    void updateProducto(Producto producto);
    void deleteProducto(int id);
}
