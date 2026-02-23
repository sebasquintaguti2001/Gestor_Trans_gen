package unbosque.producto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unbosque.producto.DTO.ProductoDTO;
import unbosque.producto.Service.ProductoInterface;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoInterface productoService;

    @PostMapping("/agregar")
    public ProductoDTO guardar(@RequestBody ProductoDTO productoDTO) {
        return productoService.guardarProducto(productoDTO);
    }

    @GetMapping("/listar")
    public List<ProductoDTO> listar() {
        return productoService.listarProductos();
    }

    @GetMapping("/buscar/{id}")
    public ProductoDTO buscar(@PathVariable int id) {
        return productoService.buscarPorId(id);
    }

    @PutMapping("/actualizar/{id}")
    public String actualizar(@PathVariable int id,@RequestBody ProductoDTO productoDTO) {
        return productoService.actualizarProducto(id, productoDTO);
    }

    @DeleteMapping("/borrar/{id}")
    public String eliminar(@PathVariable int id) {
        return productoService.borrarProducto(id);
    }
}
