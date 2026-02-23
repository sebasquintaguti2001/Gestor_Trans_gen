package unbosque.venta.Service;

import unbosque.venta.DTO.VentaDTO;

import java.util.List;

public interface VentaInterface {

    public VentaDTO guardarVenta(VentaDTO ventaDTO);
    public List<VentaDTO> listarVentas();
    public VentaDTO buscarPorId(int id);
    public String actualizarVenta(int id, VentaDTO ventaDTO);
    public String borrarVenta(int id);
}
