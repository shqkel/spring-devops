package com.sh.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HomeController {

    @Value("${profile.value}")
    String value;

    @GetMapping("/")
    public ResponseEntity<?> home() {
        log.info("인덱스 페이지");
        log.debug("value = {}", value);
        return ResponseEntity.ok(value);
    }
}
