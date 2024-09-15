package com.estudos.datatransferobject.service;

import com.estudos.datatransferobject.dto.CreateUserDto;
import com.estudos.datatransferobject.dto.DeleteUserDto;
import com.estudos.datatransferobject.dto.UpdateUserDto;
import com.estudos.datatransferobject.entity.User;
import com.estudos.datatransferobject.mapper.UserMapper;
import com.estudos.datatransferobject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UUID createUser(CreateUserDto userDto) {

        var mappedUser = userMapper.toEntity(userDto);
        try {
            userRepository.save(mappedUser);

            log.atInfo().setMessage("User created")
                    .addKeyValue("username", mappedUser.getUsername())
                    .log();

            return mappedUser.getUserId();

        } catch (Exception exception) {
            throw new RuntimeException("Failed to create user");
        }
    }

    public Optional<User> getUserById(String userId) {
        return userRepository.findById(UUID.fromString(userId));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUsers(DeleteUserDto ids) {
        var uuidList = ids.ids().stream().map(UUID::fromString).toList();
        userRepository.deleteAllById(uuidList);
    }

    public void updateUserById(String userId, UpdateUserDto userDto) {
        var userData = userRepository.findById(UUID.fromString(userId));

        if (userData.isPresent()) {
            var userEntity = userData.get();
            this.setUpdatedUser(userEntity, userDto);
            userRepository.save(userEntity);
        }
    }

    public void setUpdatedUser(User user, UpdateUserDto updateUserDto) {
        if (null != updateUserDto.username()) {
            user.setUsername(updateUserDto.username());
        }
        if (null != updateUserDto.password()) {
            user.setPassword(updateUserDto.password());
        }
    }

}
