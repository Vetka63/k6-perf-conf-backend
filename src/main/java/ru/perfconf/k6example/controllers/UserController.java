package ru.perfconf.k6example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.perfconf.k6example.dto.UserCreateDTO;
import ru.perfconf.k6example.dto.UserDTO;
import ru.perfconf.k6example.dto.UserUpdateDTO;
import ru.perfconf.k6example.servises.UserService;

@RequiredArgsConstructor
@RestController
@Tag(name = "CRUD операции над сущностью User")
@Slf4j
public class UserController {

    private final UserService userService;

    @Operation(summary = "Получить всех пользователей")
    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Получить пользователя по uuid")
    @GetMapping("/users/{uuid}")
    public UserDTO getUser(@PathVariable UUID uuid) {
        return userService.getUserByUuid(uuid);
    }

    @Operation(summary = "Создание пользователя")
    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserCreateDTO user) {
        return userService.createUser(user);
    }

    @Operation(summary = "Редактирование данных пользователя")
    @PutMapping("/users/{uuid}")
    public UserDTO editUser(@PathVariable UUID uuid, @RequestBody UserUpdateDTO userUpdateDTO) {
        return userService.editUser(uuid, userUpdateDTO);
    }

    @Operation(summary = "Удаление пользователя")
    @DeleteMapping("/users/{uuid}")
    public void deleteUser(@PathVariable UUID uuid) {
        userService.deleteUser(uuid);
    }
}
