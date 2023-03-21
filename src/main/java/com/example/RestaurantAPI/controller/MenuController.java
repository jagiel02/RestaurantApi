package com.example.RestaurantAPI.controller;

import com.example.RestaurantAPI.entity.Menu;
import com.example.RestaurantAPI.repo.MenuRepo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MenuController {

    @Autowired
    MenuRepo menuRepo;

    @PostMapping("/menu/")
    public ResponseEntity<Menu> saveMenu(@RequestBody Menu menu) {
        return new ResponseEntity<>(menuRepo.save(menu), HttpStatus.CREATED);
    }

    @GetMapping("/menu/")
    public ResponseEntity<List<Menu>> getMenu() {
        return new ResponseEntity<>(menuRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/menu/{id}")
    public ResponseEntity<Menu> getMenu(@PathVariable long id) {
        Optional<Menu> menu = menuRepo.findById(id);
        if (menu.isPresent()) {
            return new ResponseEntity<>(menu.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/menu/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable long id, @RequestBody Menu upd_menu) {
        Optional<Menu> menu = menuRepo.findById(id);
        if (menu.isPresent()) {
            menu.get().setMenuName(upd_menu.getMenuName());
            menu.get().setMenuDesc(upd_menu.getMenuDesc());
            menu.get().setMenuPrice(upd_menu.getMenuPrice());
            return new ResponseEntity<>(menuRepo.save(menu.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/menu/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable long id) {
        Optional<Menu> menu = menuRepo.findById(id);
        if (menu.isPresent()) {
            menuRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}