package com.vkr.user_service.mapper;

import com.vkr.user_service.dto.CreateUserDto;
import com.vkr.user_service.dto.UserDto;
import com.vkr.user_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper {


    public abstract UserDto toDto(User user);

    public abstract User toEntity(CreateUserDto userDto);

    public abstract void updateEntity(@MappingTarget User user, CreateUserDto userDto);
}
