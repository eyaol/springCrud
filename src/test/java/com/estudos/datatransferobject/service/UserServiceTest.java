package com.estudos.datatransferobject.service;

import com.estudos.datatransferobject.dto.CreateUserDto;
import com.estudos.datatransferobject.entity.User;
import com.estudos.datatransferobject.mapper.UserMapper;
import com.estudos.datatransferobject.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    @BeforeEach
    public void setUp() {
    }

    @Nested
    class createUser {

        @Test
        void createUserWithSuccess() {

            User input = new User(
                    UUID.randomUUID(),
                    "Enio",
                    "enio@gmail.com",
                    "senha",
                    Instant.now(),
                    Instant.now());

            var userDto = new CreateUserDto(
                    "Enio",
                    "enio@gmail.com",
                    "senha");

            doReturn(input).when(userMapper).toEntity(any());
            doReturn(input).when(userRepository).save(userArgumentCaptor.capture());

            var result = userService.createUser(userDto);

            var userCaptured = userArgumentCaptor.getValue();

            assertNotNull(result);
            assertEquals(input.getUserId(), result);
            assertEquals(input.getUsername(), userCaptured.getUsername());
            assertEquals(input.getEmail(), userCaptured.getEmail());
            assertEquals(input.getPassword(), userCaptured.getPassword());
        }

        @Test
        void returnException() {

            User userEntity = new User(
                    UUID.randomUUID(),
                    "Enio",
                    "enio@gmail.com",
                    "senha",
                    Instant.now(),
                    Instant.now()
            );

            var userDto = new CreateUserDto("", "enio@gmail.com", "senha");

            doReturn(userEntity).when(userMapper).toEntity(userDto);

            doThrow(RuntimeException.class).when(userRepository).save(any());

            assertThrows(RuntimeException.class, () -> {
                userService.createUser(userDto);
            });
        }

    }

    @Nested
    class getUserById {

        @Test
        void getUserByIdWithSuccess() {

        }
    }
}