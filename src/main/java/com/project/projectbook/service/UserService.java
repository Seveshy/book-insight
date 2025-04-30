package com.project.projectbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.projectbook.dto.UserDto;
import com.project.projectbook.entities.User;
import com.project.projectbook.exceptions.ResourceNotFoundException;
import com.project.projectbook.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    @Transactional
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        return new UserDto(user);
    }

    @Transactional
    public List<UserDto> findAll() {
        List<User> userDtos = userRepository.findAll();
        return userDtos.stream().map(user -> new UserDto(user)).toList();
    }

    @Transactional
    public UserDto insert(UserDto userDto) {
        User user = new User();

        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());

        user = userRepository.save(user);
        return new UserDto(user); 
    }
}
