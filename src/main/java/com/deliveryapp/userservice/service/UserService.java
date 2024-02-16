package com.deliveryapp.userservice.service;

import com.deliveryapp.userservice.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    public UserService(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    public UserDto addUser(UserDto userDto) {

    }

    public UserDto fetchUserDetailsById(long id) {
    }


}
