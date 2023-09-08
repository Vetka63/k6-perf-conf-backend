package ru.perfconf.k6example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.perfconf.k6example.servises.K6ExampleService;

@RequiredArgsConstructor
@RestController
@Tag(name = "Контроллер с GET запросами для примеров НТ")
@Slf4j
public class K6ExampleGetApi {

    private final K6ExampleService k6ExampleService;

    @Operation(summary = "")
    @GetMapping("/")
    public String getWithQueryOrWithoutQuery(Integer length) {
        return k6ExampleService.getStringByLength(length);
    }

    @Operation(summary = "")
    @GetMapping("/{value}")
    public String getWithPathParam(@PathVariable Integer value) {
        return k6ExampleService.getStringByLength(value);
    }
}
