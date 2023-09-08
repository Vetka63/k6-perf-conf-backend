package ru.perfconf.k6example.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.perfconf.k6example.entities.User;


public interface UserRepository extends JpaRepository<User, UUID> {
}
