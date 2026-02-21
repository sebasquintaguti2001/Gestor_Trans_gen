package unbosque.cliente.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unbosque.cliente.Entidad.ClienteEntidad;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntidad, Long> {

}