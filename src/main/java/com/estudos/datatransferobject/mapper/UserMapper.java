package com.estudos.datatransferobject.mapper;

import com.estudos.datatransferobject.dto.UserDTO;
import com.estudos.datatransferobject.model.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserMapper implements Function<UserDTO, User> {

    @Override
    public User apply(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.name());
        user.setAge(userDTO.age());
        user.setCpf(userDTO.cpf());

        return user;
    }

}
