package unbosque.producto.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unbosque.producto.Entidad.ProductoEntidad;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntidad, Integer> {
}
