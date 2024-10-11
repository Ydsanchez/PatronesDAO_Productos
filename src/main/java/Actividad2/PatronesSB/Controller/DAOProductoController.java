package Actividad2.PatronesSB.Controller;

import Actividad2.PatronesSB.AbstractFactory.IDAO_Producto;
import Actividad2.PatronesSB.Configuration.DBConfiguration;
import Actividad2.PatronesSB.Domain.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class DAOProductoController implements IDAO_Producto {
    private IDAO_Producto idaoProducto;

    public DAOProductoController() {
        DBConfiguration.DBConfiguration("mysql");
        this.idaoProducto = DBConfiguration.getDaoProducto();
    }

    @PostMapping
    public void addProducto(@RequestBody Producto producto) {
        idaoProducto.addProducto(producto);
    }

    @GetMapping("/{id}")
    public Producto obtainProducto(@PathVariable int id     ) {
        return idaoProducto.obtainProducto(id);
    }

    @GetMapping
    public List<Producto> obtainAllProducto() {
        return idaoProducto.obtainAllProducto();
    }

    @PutMapping
    public void updateProducto(@RequestBody Producto producto) {
        idaoProducto.updateProducto(producto);
    }

    @DeleteMapping("{id}")
    public void deleteProducto(@PathVariable int id) {
        idaoProducto.deleteProducto(id);
    }
}
