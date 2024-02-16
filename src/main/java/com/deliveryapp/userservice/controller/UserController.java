package com.deliveryapp.userservice.controller;

import com.deliveryapp.userservice.dto.UserDto;
import com.deliveryapp.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.addUser(userDto);
        return ResponseEntity.ok().body(savedUser);
    }

    @GetMapping("/fetchUserById/{id}")
    public ResponseEntity<UserDto> fetchUserDetailsById(@PathVariable long id){
        UserDto userDto = userService.fetchUserDetailsById(id);
        if(userDto == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
