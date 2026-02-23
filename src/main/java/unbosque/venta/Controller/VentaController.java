package unbosque.venta.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unbosque.detalleVenta.DTO.DetalleVentaDTO;
import unbosque.detalleVenta.Service.DetalleVentaService;
import unbosque.venta.DTO.VentaDTO;
import unbosque.venta.Service.VentaImplService;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaImplService ventaService;

    @Autowired
    private DetalleVentaService detalleVentaService;

    @PostMapping("/agregar")
    public VentaDTO guardar(@RequestBody VentaDTO ventaDTO) {
        return ventaService.guardarVenta(ventaDTO);
    }

    @GetMapping("/listar")
    public List<VentaDTO> listar() {
        return ventaService.listarVentas();
    }

    @GetMapping("/buscar/{id}")
    public VentaDTO buscar(@PathVariable int id) {
        return ventaService.buscarPorId(id);
    }

    @PutMapping("/actualizar/{id}")
    public String actualizar(@PathVariable int id, @RequestBody VentaDTO ventaDTO) {
        return ventaService.actualizarVenta(id, ventaDTO);
    }

    @DeleteMapping("/borrar/{id}")
    public String eliminar(@PathVariable int id) {
        return ventaService.borrarVenta(id);
    }

    @GetMapping("/listar-detalles")
    public List<DetalleVentaDTO> listarDetalles() {
        return detalleVentaService.listarDetalles();
    }

    @GetMapping("/buscar-detalle/{id}")
    public DetalleVentaDTO buscarDetalle(@PathVariable int id) {
        return detalleVentaService.buscarPorId(id);
    }

    @PutMapping("/actualizar")
    public String actualizarDetalle(@PathVariable int id, @RequestBody DetalleVentaDTO dto) {
        return detalleVentaService.actualizarDetalle(id, dto);
    }

    @DeleteMapping("/borrar-detalle/{id}")
    public String eliminarDetalle(@PathVariable int id) {
        return detalleVentaService.borrarDetalle(id);
    }
}
