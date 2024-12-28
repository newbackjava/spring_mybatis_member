package com.example.demo.service;

import com.example.demo.mapper.MemberMapper;
import com.example.demo.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

//    public MemberService(MemberMapper memberMapper) {
//        this.memberMapper = memberMapper;
//    }

    public int createMember(MemberVO memberVO) {
        return memberMapper.insertMember(memberVO);
    }
    public int updateMember(MemberVO memberVO) {
        return memberMapper.updateMember(memberVO);
    }

    public MemberVO getMemberById(int id) {
        return memberMapper.selectMemberById(id);
    }

    public List<MemberVO> getMemberAll() {
        return memberMapper.selectMemberAll();
    }

    public int deleteMember(int id) {
        return memberMapper.deleteMember(id);
    }
}
