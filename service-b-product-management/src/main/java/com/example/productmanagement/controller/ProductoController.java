package com.example.productmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final Map<String, String> productInventory = new ConcurrentHashMap<>();

    @GetMapping
    public ResponseEntity<Map<String, String>> getAllProducts() {
        return ResponseEntity.ok(productInventory);
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Map<String, String> request) {
        String productName = request.get("nombre");
        String productPrice = request.get("precio");
        productInventory.put(productName, productPrice);
        return ResponseEntity.ok("Producto agregado: " + productName);
    }

}
