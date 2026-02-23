package unbosque.detalleVenta.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import unbosque.detalleVenta.Entidad.DetalleVentaEntidad;

public interface DetalleVentaRepository  extends JpaRepository<DetalleVentaEntidad, Integer> {
}
