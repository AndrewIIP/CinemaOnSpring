package com.polishchuk.cinema.cinema.controller;

import com.polishchuk.cinema.cinema.data.dto.UserDto;
import com.polishchuk.cinema.cinema.data.entity.User;
import com.polishchuk.cinema.cinema.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class MainController {

    private UserService userService;

    @GetMapping(value = "/getHello")
    public String getHello(){
        return "Hello World, client!";
    }

    @GetMapping(value = "/guest")
    public String helloGuest(){
        return "Hello Stranger!";
    }

    @GetMapping(value = "/user")
    public String helloUser(){
        return "Hello USER!";
    }

    @GetMapping(value = "/admin")
    public String helloAdmin(){
        return "Hello ADMIN!";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserDto userDto){
        return userService.addSimpleUserToRepo(userDto);
    }

    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }
}
