package com.example.user.mapper;

import com.example.user.dao.entity.UserEntity;
import com.example.user.dto.UserRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity dtoToEntity(UserRequestDto d);

}
