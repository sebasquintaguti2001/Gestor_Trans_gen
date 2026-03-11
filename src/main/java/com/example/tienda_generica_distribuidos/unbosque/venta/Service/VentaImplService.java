package com.example.tienda_generica_distribuidos.unbosque.venta.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tienda_generica_distribuidos.unbosque.venta.DTO.VentaDTO;
import com.example.tienda_generica_distribuidos.unbosque.venta.Entidad.VentaEntidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VentaImplService implements VentaInterface {

    @Autowired
    private VentaRepository ventaRepository;


    @Override
    public VentaDTO guardarVenta(VentaDTO ventaDTO) {
        VentaEntidad entidad = new VentaEntidad(
                ventaDTO.getCodigo_venta(),
                ventaDTO.getCedula_cliente(),
                ventaDTO.getCedula_usuario(),
                ventaDTO.getIvaventa(),
                ventaDTO.getValor_venta(),
                ventaDTO.getTotal_venta()
        );

        try {
            VentaEntidad guardada = ventaRepository.save(entidad);
            ventaDTO.setCodigo_venta(guardada.getCodigo_venta());
            return ventaDTO;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<VentaDTO> listarVentas() {
        List<VentaEntidad> ventas = ventaRepository.findAll();
        List<VentaDTO> listaDTO = new ArrayList<>();

        for (VentaEntidad v : ventas) {
            listaDTO.add(new VentaDTO(
                    v.getCodigo_venta(),
                    v.getCedula_cliente(),
                    v.getCedula_usuario(),
                    v.getIvaventa(),
                    v.getValor_venta(),
                    v.getTotal_venta()
            ));
        }

        return listaDTO;
    }

    @Override
    public VentaDTO buscarPorId(int id) {
        VentaEntidad venta = ventaRepository.findById(id).orElse(null);

        if (venta == null) {
            return null;
        } else {
            return new VentaDTO(
                    venta.getCodigo_venta(),
                    venta.getCedula_cliente(),
                    venta.getCedula_usuario(),
                    venta.getIvaventa(),
                    venta.getValor_venta(),
                    venta.getTotal_venta()
            );
        }
    }

    @Override
    public String actualizarVenta(int id, VentaDTO ventaDTO) {
        Optional<VentaEntidad> ventaExistente =
                ventaRepository.findById(ventaDTO.getCodigo_venta());

        if (ventaExistente.isEmpty()) {
            return "Venta imposible de actualizar";
        } else {
            VentaEntidad entidad = ventaExistente.get();

            entidad.setCedula_cliente(ventaDTO.getCedula_cliente());
            entidad.setCedula_usuario(ventaDTO.getCedula_usuario());
            entidad.setIvaventa(ventaDTO.getIvaventa());
            entidad.setValor_venta(ventaDTO.getValor_venta());
            entidad.setTotal_venta(ventaDTO.getTotal_venta());

            ventaRepository.save(entidad);
            return "Venta actualizada correctamente";
        }
    }

    @Override
    public String borrarVenta(int id) {
        try {
            ventaRepository.deleteById(id);
            return "Venta eliminada";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
