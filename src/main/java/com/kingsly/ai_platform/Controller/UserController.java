package com.kingsly.ai_platform.Controller;

import com.kingsly.ai_platform.Dto.ResponseDto;
import com.kingsly.ai_platform.Dto.UserDto;
import com.kingsly.ai_platform.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private  UserService userService;

    @PostMapping
    public ResponseEntity<ResponseDto> createUser(@Valid @RequestBody UserDto userDto){
        ResponseDto response=new ResponseDto("User Details Created",HttpStatus.CREATED.value(), LocalDateTime.now(),userService.createUser(userDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<ResponseDto> getUser(){
        ResponseDto response=new ResponseDto("User Details Created",HttpStatus.OK.value(), LocalDateTime.now(),userService.getUser());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ResponseDto> updateUser(@PathVariable long id,@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id,userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable  long id){
        ResponseDto response=new ResponseDto("User Details Created",HttpStatus.OK.value(), LocalDateTime.now(),userService.deleteUser(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    public UserController(UserService userService){
        this.userService=userService;

    }
}
