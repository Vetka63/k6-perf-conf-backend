package ru.perfconf.k6example.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.perfconf.k6example.dto.UserDTO;
import ru.perfconf.k6example.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);

    @Mapping(target = "uuid", ignore = true)
    User toEntity(UserDTO userDTO);
}
