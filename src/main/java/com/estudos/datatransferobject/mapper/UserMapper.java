package com.estudos.datatransferobject.mapper;

import com.estudos.datatransferobject.dto.CreateUserDto;
import com.estudos.datatransferobject.dto.UpdateUserDto;
import com.estudos.datatransferobject.entity.User;
import org.mapstruct.*;

import java.time.Instant;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {

    @Mapping(target = "creationTimestamp", ignore = true)
    @Mapping(target = "updateTimestamp", ignore = true)
    @Mapping(target = "userId", ignore = true)
    User toEntity(CreateUserDto userDto);

    @AfterMapping
    default void setCreationTimestamp(@MappingTarget User user) {
        user.setCreationTimestamp(Instant.now());
    }

}
