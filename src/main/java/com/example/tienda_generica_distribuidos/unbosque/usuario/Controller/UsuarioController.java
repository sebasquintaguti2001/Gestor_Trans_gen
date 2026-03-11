package com.example.tienda_generica_distribuidos.unbosque.usuario.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.tienda_generica_distribuidos.unbosque.usuario.DTO.UsuarioDTO;
import com.example.tienda_generica_distribuidos.unbosque.usuario.Service.UsuarioInterface;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioInterface usuarioService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            UsuarioDTO guardado = usuarioService.guardarUsuario(usuarioDTO);
            return ResponseEntity.ok(guardado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/buscar/{cedula}")
    public ResponseEntity<?> obtenerUsuarioPorCedula(@PathVariable Long cedula) {
        UsuarioDTO usuario = usuarioService.obtenerUsuarioPorCedula(cedula);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario Inexistente");
        }
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            UsuarioDTO actualizado = usuarioService.actualizarUsuario(usuarioDTO);
            return ResponseEntity.ok(actualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        try {
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {
        try {
            String usuario  = credenciales.get("usuario");
            String password = credenciales.get("password");
            UsuarioDTO dto = usuarioService.login(usuario, password);
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}