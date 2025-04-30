package com.project.projectbook.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.projectbook.dto.UserDto;
import com.project.projectbook.entities.User;
import com.project.projectbook.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    
    @Autowired
    UserService userService;
    
    // public ResponseEntity<UserDto> insert(@RequestBody UserDto userDto) {
    //     userDto = userService.insert(userDto);
    // }

}
