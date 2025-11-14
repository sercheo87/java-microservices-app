package com.example.usermanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final List<String> usuarios = new CopyOnWriteArrayList<>();

    @GetMapping
    public ResponseEntity<List<String>> getUsuarios() {
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<String> createUsuario(@RequestBody String usuario) {
        if (usuario == null || usuario.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre de usuario no puede estar vacío");
        }
        String trimmed = usuario.trim();
        usuarios.add(trimmed);
        return ResponseEntity.ok("Usuario creado exitosamente: " + trimmed);
    }

}
