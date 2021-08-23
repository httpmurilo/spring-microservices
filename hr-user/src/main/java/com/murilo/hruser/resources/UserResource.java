package com.murilo.hruser.resources;

import com.murilo.hruser.entities.User;
import com.murilo.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository repository;


    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = repository.findById(id).get();
        return ResponseEntity.ok(user);
    }
    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        User obj = repository.findByEmail(email);
        return ResponseEntity.ok(obj );
    }
}
