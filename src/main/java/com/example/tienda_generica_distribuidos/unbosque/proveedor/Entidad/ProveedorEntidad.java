package com.example.tienda_generica_distribuidos.unbosque.proveedor.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proveedores")
public class ProveedorEntidad {

    @Id
    @Column(name = "nitproveedor", nullable = false)
    private Long nitProveedor;

    @Column(name = "nombre_proveedor", nullable = false, length = 255)
    private String nombreProveedor;

    @Column(name = "direccion_proveedor", nullable = false, length = 255)
    private String direccionProveedor;

    @Column(name = "telefono_proveedor", nullable = false, length = 255)
    private String telefonoProveedor;

    @Column(name = "ciudad_proveedor", nullable = false, length = 255)
    private String ciudadProveedor;
}