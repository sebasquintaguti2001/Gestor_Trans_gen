package unbosque.venta.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import unbosque.venta.Entidad.VentaEntidad;

public interface VentaRepository extends JpaRepository<VentaEntidad, Integer> {
}
