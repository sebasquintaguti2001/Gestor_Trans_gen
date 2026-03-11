package com.example.tienda_generica_distribuidos.unbosque.usuario.Service;

import com.example.tienda_generica_distribuidos.unbosque.usuario.DTO.UsuarioDTO;

import java.util.List;

public interface UsuarioInterface {

    UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO);

    List<UsuarioDTO> listarUsuarios();

    UsuarioDTO obtenerUsuarioPorCedula(Long cedula);

    UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO);

    void eliminarUsuario(Long cedula);

    UsuarioDTO login(String usuario, String password);
}