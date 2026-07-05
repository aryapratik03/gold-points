package com.loyalty.gold_points_api.controllers;

import com.loyalty.gold_points_api.dto.request.UserRequest;
import com.loyalty.gold_points_api.dto.response.UserResponse;
import com.loyalty.gold_points_api.entities.User;
import com.loyalty.gold_points_api.services.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> findOne(@PathVariable Long userId) {
        User user =userService.findUserById(userId);

        return ResponseEntity.ok(userService.toResponse(user));
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.createUser(userRequest));
    }
}
