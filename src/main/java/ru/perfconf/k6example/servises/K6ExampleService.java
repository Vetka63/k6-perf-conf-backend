package ru.perfconf.k6example.servises;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class K6ExampleService {

    public static final int DEFAULT_LENGTH = 5;

    public String getStringByLength(Integer length) {
        String result = RandomStringUtils.randomAscii(Objects.requireNonNullElse(length, DEFAULT_LENGTH));
        log.info(result);
        return result;
    }
}
