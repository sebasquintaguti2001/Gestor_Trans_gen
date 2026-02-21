package unbosque.usuario.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unbosque.usuario.Entidad.UsuarioEntidad;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntidad, Long> {

    Optional<UsuarioEntidad> findByUsuarioAndPassword(String usuario, String password);
}