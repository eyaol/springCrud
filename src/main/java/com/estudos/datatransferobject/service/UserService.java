package com.estudos.datatransferobject.service;

import com.estudos.datatransferobject.dto.UserDTO;
import com.estudos.datatransferobject.model.User;

public interface UserService {
    User createUser(UserDTO userDTO);
}
