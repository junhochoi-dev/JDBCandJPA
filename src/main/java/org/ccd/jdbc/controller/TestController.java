package org.ccd.jdbc.controller;

import lombok.RequiredArgsConstructor;
import org.ccd.jdbc.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class TestController {
    private final TestService testService;

    @GetMapping("/test/jdbc")
    public ResponseEntity<String> testJDBC() {

        return ResponseEntity.ok("JDBC 테스트 성공");
    }

    @GetMapping("/test/jpa")
    public ResponseEntity<String> testJPA(){
        testService.testJPA();
        return ResponseEntity.ok("JPA 테스트 성공");
    }
}
