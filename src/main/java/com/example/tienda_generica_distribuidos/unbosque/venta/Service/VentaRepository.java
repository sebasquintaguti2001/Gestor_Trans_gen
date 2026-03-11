package com.example.tienda_generica_distribuidos.unbosque.venta.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tienda_generica_distribuidos.unbosque.venta.Entidad.VentaEntidad;

public interface VentaRepository extends JpaRepository<VentaEntidad, Integer> {
}
