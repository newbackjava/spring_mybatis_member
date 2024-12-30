package com.example.demo.member.service;

import com.example.demo.member.dao.MemberMapper;
import com.example.demo.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    // BCrypt 인코더 사용
    private final PasswordEncoder passwordEncoder;
    //회원가입시, 로그인 처리시 두 개의 메서드에서 사용해야하므로
    //전역변수로 설정해둠.

    public MemberVO createMember(MemberVO memberVO) {
        String encodedPassword = passwordEncoder.encode(memberVO.getPw());
        memberVO.setPw(encodedPassword); // 암호화된 비밀번호로 설정
        System.out.println(memberVO.getPw());
        //dao에 vo를 받아서 db처리 요청!
        memberMapper.insertMember(memberVO);
        return memberVO;
    }

    public int updateMember(MemberVO memberVO) {
        return memberMapper.updateMember(memberVO);
    }

    public MemberVO getMemberById(String id) {
        return memberMapper.selectMemberById(id);
    }

    public List<MemberVO> getMemberAll() {
        return memberMapper.selectMemberAll();
    }

    public int deleteMember(String id) {
        return memberMapper.deleteMember(id);
    }
}


//@Service
//public class MemberService {
//    @Autowired
//    private MemberMapper memberMapper;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    // 로그인 검증 메서드
//    public boolean validateLogin(String id, String rawPassword) {
//        MemberVO member = memberMapper.selectMemberById(id);
//
//        if (member != null) {
//            // 데이터베이스에서 가져온 암호화된 비밀번호와 입력한 비밀번호 비교
//            return passwordEncoder.matches(rawPassword, member.getPw());
//        }
//        return false; // 회원 정보가 없는 경우
//    }
//}
