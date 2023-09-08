package ru.perfconf.k6example.servises;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.perfconf.k6example.dto.UserCreateDTO;
import ru.perfconf.k6example.dto.UserDTO;
import ru.perfconf.k6example.dto.UserUpdateDTO;
import ru.perfconf.k6example.entities.User;
import ru.perfconf.k6example.mappers.UserMapper;
import ru.perfconf.k6example.repositories.UserRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public UserDTO createUser(UserCreateDTO user) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(new UserDTO(null, user.name(), user.age()))));
    }

    @Transactional
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public UserDTO getUserByUuid(UUID uuid) {
        return userMapper.toDto(userRepository.findById(uuid).orElseThrow());
    }

    @Transactional
    public UserDTO editUser(UUID uuid, UserUpdateDTO userUpdateDTO) {
        User user = userRepository.findById(uuid).orElseThrow();
        user.setName(userUpdateDTO.name());
        user.setAge(userUpdateDTO.age());
        return userMapper.toDto(userRepository.save(user));
    }

    @Transactional
    public void deleteUser(UUID uuid) {
        userRepository.deleteById(uuid);
    }
}
