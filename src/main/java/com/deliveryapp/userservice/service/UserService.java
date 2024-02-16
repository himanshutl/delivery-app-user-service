package com.deliveryapp.userservice.service;

import com.deliveryapp.userservice.dto.UserDto;
import com.deliveryapp.userservice.entity.User;
import com.deliveryapp.userservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserDto addUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    public UserDto fetchUserDetailsById(long id) {
        List<UserDto> userDto =  new ArrayList<>();
        userRepository.findById(id)
                .ifPresent(
                        user -> {
                            UserDto dto = modelMapper.map(user, UserDto.class);
                            userDto.add(dto);
                        }
                );
        return userDto.get(0);
    }
}
