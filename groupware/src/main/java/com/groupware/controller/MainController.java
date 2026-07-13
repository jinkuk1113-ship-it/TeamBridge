package com.groupware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // 로그인 성공 시 SecurityConfig의 defaultSuccessUrl("/main")이 이동시키는 곳.
    // 지금은 로그인 흐름 확인용으로 화면만 띄우고, 대시보드 데이터(공지·결재 요약 등)는
    // 대시보드 기능 작업할 때 채운다.
    @GetMapping("/main")
    public String main() {
        return "main";
    }

}
