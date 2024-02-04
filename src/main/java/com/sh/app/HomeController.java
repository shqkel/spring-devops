package com.sh.app;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * @ResponseBody + @SessionAttributes 함께 사용시 session생성이 늦어 속성저장이 안되는 이슈 있으므로, 직접 session객체에 속성을 저장한다.
     * https://github.com/spring-projects/spring-framework/issues/17475
     *
     */
    @GetMapping("/msg/set")
    public ResponseEntity<?> setMsgToSession(@RequestParam("msg") String msg, HttpSession session) {
        session.setAttribute("msg", msg);
        return ResponseEntity.ok("msg=%s 세션에 저장되었습니다.".formatted(msg));
    }

    /**
     * @SessionAttribute 속성에 대한 getter
     */
    @GetMapping("/msg/get")
    public ResponseEntity<?> getMsgFromSession(@SessionAttribute("msg") String msg) {
        log.debug("msg = {}", msg);
        return ResponseEntity.ok(msg);
    }
}
