package com.estudos.datatransferobject.service;

import com.estudos.datatransferobject.dto.UserRequest;
import com.estudos.datatransferobject.entity.UserEntity;

public interface UserService {
    UserEntity createUser(UserRequest userRequest);
}
