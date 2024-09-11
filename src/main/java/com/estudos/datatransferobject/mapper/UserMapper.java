package com.estudos.datatransferobject.mapper;

import com.estudos.datatransferobject.dto.UserRequest;
import com.estudos.datatransferobject.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {

    @Mapping(target = "dataAniversario", source = "date")
    UserEntity convertToUserEntity(UserRequest userRequest);

}
