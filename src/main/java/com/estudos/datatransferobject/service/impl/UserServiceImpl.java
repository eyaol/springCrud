package com.estudos.datatransferobject.service.impl;

import com.estudos.datatransferobject.dto.UserRequest;
import com.estudos.datatransferobject.exception.UserCreationException;
import com.estudos.datatransferobject.mapper.UserMapper;
import com.estudos.datatransferobject.entity.UserEntity;
import com.estudos.datatransferobject.repository.UserRepository;
import com.estudos.datatransferobject.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserEntity createUser(UserRequest userRequest) {

        try {
            return userRepository.save(userMapper.convertToUserEntity(userRequest));
        } catch (Exception e) {
            throw new UserCreationException("Fail to create user");
        }

    }
}
