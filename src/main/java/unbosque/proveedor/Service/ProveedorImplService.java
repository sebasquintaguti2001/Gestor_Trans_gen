package unbosque.proveedor.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unbosque.proveedor.DTO.ProveedorDTO;
import unbosque.proveedor.Entidad.ProveedorEntidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProveedorImplService implements ProveedorInterface {

    @Autowired
    private ProveedorRepository proveedorRepository;

    private ProveedorDTO mapToDTO(ProveedorEntidad entidad) {
        return new ProveedorDTO(
                entidad.getNitProveedor(),
                entidad.getNombreProveedor(),
                entidad.getDireccionProveedor(),
                entidad.getTelefonoProveedor(),
                entidad.getCiudadProveedor()
        );
    }

    private ProveedorEntidad mapToEntidad(ProveedorDTO dto) {
        return new ProveedorEntidad(
                dto.getNitProveedor(),
                dto.getNombreProveedor(),
                dto.getDireccionProveedor(),
                dto.getTelefonoProveedor(),
                dto.getCiudadProveedor()
        );
    }

    @Override
    public ProveedorDTO guardarProveedor(ProveedorDTO proveedorDTO) {
        if (proveedorDTO.getNitProveedor() == null
                || proveedorDTO.getNombreProveedor()    == null || proveedorDTO.getNombreProveedor().isBlank()
                || proveedorDTO.getDireccionProveedor() == null || proveedorDTO.getDireccionProveedor().isBlank()
                || proveedorDTO.getTelefonoProveedor()  == null || proveedorDTO.getTelefonoProveedor().isBlank()
                || proveedorDTO.getCiudadProveedor()    == null || proveedorDTO.getCiudadProveedor().isBlank()) {
            throw new IllegalArgumentException("Faltan datos del proveedor");
        }
        ProveedorEntidad entidad = proveedorRepository.save(mapToEntidad(proveedorDTO));
        return mapToDTO(entidad);
    }

    @Override
    public List<ProveedorDTO> listarProveedores() {
        List<ProveedorEntidad> entidades = proveedorRepository.findAll();
        List<ProveedorDTO> lista = new ArrayList<>();
        for (ProveedorEntidad e : entidades) {
            lista.add(mapToDTO(e));
        }
        return lista;
    }

    @Override
    public ProveedorDTO obtenerProveedorPorNit(Long nit) {
        Optional<ProveedorEntidad> optional = proveedorRepository.findById(nit);
        return optional.map(this::mapToDTO).orElse(null);
    }

    @Override
    public ProveedorDTO actualizarProveedor(ProveedorDTO proveedorDTO) {
        if (!proveedorRepository.existsById(proveedorDTO.getNitProveedor())) {
            throw new IllegalArgumentException("Proveedor Inexistente");
        }
        if (proveedorDTO.getNombreProveedor()    == null || proveedorDTO.getNombreProveedor().isBlank()
                || proveedorDTO.getDireccionProveedor() == null || proveedorDTO.getDireccionProveedor().isBlank()
                || proveedorDTO.getTelefonoProveedor()  == null || proveedorDTO.getTelefonoProveedor().isBlank()
                || proveedorDTO.getCiudadProveedor()    == null || proveedorDTO.getCiudadProveedor().isBlank()) {
            throw new IllegalArgumentException("Datos faltantes");
        }
        ProveedorEntidad entidad = proveedorRepository.save(mapToEntidad(proveedorDTO));
        return mapToDTO(entidad);
    }

    @Override
    public void eliminarProveedor(Long nit) {
        if (!proveedorRepository.existsById(nit)) {
            throw new IllegalArgumentException("NIT Errado");
        }
        proveedorRepository.deleteById(nit);
    }
}