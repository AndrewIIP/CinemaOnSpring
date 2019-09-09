package com.polishchuk.cinema.cinema.service;

import com.polishchuk.cinema.cinema.data.dto.UserDto;
import com.polishchuk.cinema.cinema.data.entity.User;
import com.polishchuk.cinema.cinema.data.mapper.UserMapper;
import com.polishchuk.cinema.cinema.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    public String addSimpleUserToRepo(UserDto userDto){
        userRepository.save(userMapper.dtoToUser(userDto));
        return "All Ok";
    }

    public List<UserDto> getAllUsers(){
        return userRepository.findAll().stream().map(e -> userMapper.userToDto(e)).collect(Collectors.toList());
    }
}
