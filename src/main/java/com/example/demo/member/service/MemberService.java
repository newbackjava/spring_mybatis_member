package com.example.demo.member.service;

import com.example.demo.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    // BCrypt 인코더 사용
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //회원가입시, 로그인 처리시 두 개의 메서드에서 사용해야하므로
    //전역변수로 설정해둠.

    public MemberVO createMember(MemberVO memberVO) {
        String encodedPassword = passwordEncoder.encode(memberVO.getPw());
        memberVO.setPw(encodedPassword); // 암호화된 비밀번호로 설정
        System.out.println(memberVO.getPw());
        //dao에 vo를 받아서 db처리 요청!
        return memberVO;
    }

    public int updateMember(MemberVO memberVO) {
        return 1;
    }

    public MemberVO getMemberById(int id) {
        return null;
    }

    public List<MemberVO> getMemberAll() {
        return null;
    }

    public int deleteMember(int id) {
        return 1;
    }
}
