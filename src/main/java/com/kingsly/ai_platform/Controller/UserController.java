package com.kingsly.ai_platform.Controller;

import com.kingsly.ai_platform.Dto.UserDto;
import com.kingsly.ai_platform.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private  UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUser(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser());
    }


    public UserController(UserService userService){
        this.userService=userService;

    }
}
