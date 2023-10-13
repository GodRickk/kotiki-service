package ru.itmo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.dto.CatFriendsDto;
import ru.itmo.services.CatFriendsServiceImpl;

@RestController
@RequestMapping("/friends")
public class CatFriendsController {

    @Autowired
    private CatFriendsServiceImpl catFriendsService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody CatFriendsDto catFriendsDto) {
        try {
            catFriendsService.save(catFriendsDto);
            return ResponseEntity.ok("Friends pair successfully saved.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/id")
    public ResponseEntity ById(@RequestParam(value = "id") Integer catFriendsId) {
        try {
            return ResponseEntity.ok(catFriendsService.findById(catFriendsId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/id/cat-friends")
    public ResponseEntity FriendsByCatId(@RequestParam(value = "id") Integer catId) {
        try {
            return ResponseEntity.ok(catFriendsService.getFriendsByCatId(catId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/id")
    //@RequestParam
    public ResponseEntity delete(@RequestParam(value = "id") Integer catFriendsId) {
        try {
            catFriendsService.delete(catFriendsId);
            return ResponseEntity.ok("Cat successfully deleted.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity AllCatFriendsPairs() {
        try {
            return ResponseEntity.ok(catFriendsService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}