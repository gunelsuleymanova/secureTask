package com.example.user.controller;


import com.example.user.dto.UserLoginDto;
import com.example.user.dto.UserRequestDto;
import com.example.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

//register

    @PostMapping("/save")
    public void saveUser(@RequestBody UserRequestDto d){
        userService.save(d);
    }
//login
    @PostMapping("/login")
    public String save(@RequestBody UserLoginDto s){
        return userService.sinin(s);
    }
//login
    @PostMapping("/sign")
    public ResponseEntity<String> sign(@RequestBody UserLoginDto d){
        return ResponseEntity.ok(userService.sinin(d));
    }

    @GetMapping("/get/{id}")
    public UserRequestDto get(@PathVariable Long id){
        return userService.get(id);
    }








}
