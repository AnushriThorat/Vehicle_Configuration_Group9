package com.vehiclecfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vehiclecfg.entities.User;
import com.vehiclecfg.services.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://localhost:3000"
})
public class UserController {

    @Autowired
    private UserService service;

    // ==================== CREATE ====================

    @PostMapping
    public ResponseEntity<User> save(
            @RequestBody User user) {

        User savedUser =
                service.save(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUser);

    }

    // ==================== GET ALL ====================

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        return ResponseEntity.ok(
                service.getAllUsers()
        );

    }

    // ==================== GET BY ID ====================

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                service.getUserById(id)
        );

    }

    // ==================== GET BY USERNAME ====================

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getByUsername(
            @PathVariable String username) {

        return ResponseEntity.ok(
                service.getByUsername(username)
        );

    }

    // ==================== UPDATE ====================

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Integer id,
            @RequestBody User user) {

        User updatedUser =
                service.updateUser(id, user);

        return ResponseEntity.ok(updatedUser);

    }

    // ==================== DELETE ====================

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Integer id) {

        service.deleteUser(id);

        return ResponseEntity.noContent().build();

    }

}