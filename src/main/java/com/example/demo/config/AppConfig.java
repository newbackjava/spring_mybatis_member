package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
// XML 설정이 로드됨
@ImportResource("classpath:applicationContext.xml")
public class AppConfig {

    //모든 post방식으로 전달된 데이터 한글 필터링 처리함.
//    @Bean
// --> 싱글톤 객체 생성됨., 해당하는 메서드 호출됨, 필터 생성하여 프로젝트 시작할 때 함수 호출됨.
// --> 모든 요청에 utf-8을 인코딩하여 request객체로 받음.
//    public CharacterEncodingFilter characterEncodingFilter() {
//        CharacterEncodingFilter filter = new CharacterEncodingFilter();
//        filter.setEncoding("UTF-8");
//        filter.setForceEncoding(true);
//        return filter;
//    }
}

//여러개의 파일일 때
//@ImportResource({
//        "classpath:applicationContext.xml",
//        "classpath:databaseConfig.xml",
//        "classpath:securityConfig.xml"
//})

