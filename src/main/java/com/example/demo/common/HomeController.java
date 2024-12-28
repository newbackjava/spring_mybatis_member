package com.example.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    //호출하나당 함수 하나
    //사이트의 첫 페이지 설정
    //기본 설정이 templates아래 index.html로 되어있음.
    @GetMapping("/")
    public String index(){
        log.info("INFO: Log example method called");
        log.debug("DEBUG: Debugging log example");
        log.error("ERROR: An error occurred in log example");
        return "index";
        //templates아래 index.html을 호출
    }
}
