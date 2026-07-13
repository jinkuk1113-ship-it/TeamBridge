package com.groupware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // SecurityConfig의 loginPage("/login")가 가리키는 화면을 보여주는 역할.
    // POST /login(폼 제출)은 Security가 자동으로 가로채 처리하므로 여기엔 GET만 있으면 됨.
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

}
