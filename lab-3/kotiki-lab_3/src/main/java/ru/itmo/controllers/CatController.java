package ru.itmo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.dto.CatDto;
import ru.itmo.enums.Color;
import ru.itmo.services.CatServiceImpl;

@RestController
@RequestMapping("/cat")
public class CatController {

    @Autowired
    private CatServiceImpl catService;

    @GetMapping("/all")
    public ResponseEntity AllCats() {
        try {
            return ResponseEntity.ok(catService.getAllCats());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/id")
    public ResponseEntity ById(@RequestParam(value = "id") Integer id) {
        try {
            return ResponseEntity.ok(catService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/owner/catid")
    public ResponseEntity OwnerByCatId(@RequestParam(value = "catid") Integer id) {
        try {
            return ResponseEntity.ok(catService.findOwnerByCatId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/color")
    public ResponseEntity CatsWithCatColor(@RequestParam(value = "color") Color color) {
        try {
            return ResponseEntity.ok(catService.getCatsWithCatColor(color));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody CatDto catDto) {
        try {
            catService.save(catDto);
            return ResponseEntity.ok("Cat successfully saved.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/set/ownerid/catid")
    public ResponseEntity setOwnerById(@RequestParam Integer catId, @RequestParam Integer ownerId) {
        try {
            catService.setOwnerById(catId, ownerId);
            return ResponseEntity.ok("Successfully set new owner.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/id")
    public ResponseEntity delete(@RequestParam(value = "id") Integer id) {
        try {
            catService.delete(id);
            return ResponseEntity.ok("Cat successfully deleted.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}