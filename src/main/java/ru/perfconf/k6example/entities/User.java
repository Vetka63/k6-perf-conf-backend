package ru.perfconf.k6example.entities;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "k6_example")
public class User {

    /**
     * Уникальный идентификатор события
     */
    @Id
    @Column(name = "uuid", nullable = false, updatable = false)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID uuid;

    /**
     * Имя пользователя
     */
    @Column(name = "name")
    private String name;

    /**
     * Возраст пользователя
     */
    @Column(name = "age")
    private Integer age;
}
