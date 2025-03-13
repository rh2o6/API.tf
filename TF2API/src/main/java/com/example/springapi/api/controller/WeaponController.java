package com.example.springapi.api.controller;

import com.example.springapi.api.model.Weapon;
import com.example.springapi.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/weapon") // Base path for all weapon-related endpoints
public class WeaponController {

    private WeaponService weaponService;

    @Autowired
    public WeaponController(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    // Handling GET request to retrieve a weapon by name
    @GetMapping("/{name}")
    public ResponseEntity<Weapon> getWeapon(@PathVariable String name) {
        Optional<Weapon> weapon = weaponService.getWeapon(name);
        return weapon.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Handling POST request to add a new weapon
    @PostMapping
    public ResponseEntity<Weapon> addWeapon(@RequestBody Weapon weapon) {
        weaponService.addWeapon(weapon);
        return ResponseEntity.status(201).body(weapon); // 201 Created response
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteWeapon(@PathVariable String name) {
        boolean deleted = weaponService.deleteWeaponByName(name);
        if (deleted) {
            return ResponseEntity.ok("Weapon '" + name + "' deleted successfully");
        }

        else {
            return ResponseEntity.notFound().build();
        }
    }
}
