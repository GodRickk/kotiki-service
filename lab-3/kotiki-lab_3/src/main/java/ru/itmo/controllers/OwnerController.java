package ru.itmo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.dto.OwnerDto;
import ru.itmo.services.OwnerServiceImpl;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerServiceImpl ownerService;

    @GetMapping("/all")
    public ResponseEntity AllOwners() {
        try {
            return ResponseEntity.ok(ownerService.getAllOwners());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/cats/owner-id")
    public ResponseEntity CatsByOwnerId(@RequestParam(value = "owner-id") Integer ownerId) {
        try {
            return ResponseEntity.ok(ownerService.getCatsByOwnerId(ownerId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody OwnerDto ownerDto) {
        try {
            ownerService.save(ownerDto);
            return ResponseEntity.ok("Owner successfully saved.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/owner/id")
    public ResponseEntity ById(@RequestParam(value = "id")Integer id) {
        try {
            return ResponseEntity.ok(ownerService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/id")
    public ResponseEntity delete(@RequestParam(value = "id") Integer id) {
        try {
            ownerService.delete(id);
            return ResponseEntity.ok("Owner successfully deleted.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
