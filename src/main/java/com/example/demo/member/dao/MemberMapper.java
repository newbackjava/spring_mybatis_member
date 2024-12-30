package com.example.demo.member.dao;

import com.example.demo.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    int insertMember(MemberVO memberVO);
    MemberVO selectMemberById(String id);
    List<MemberVO> selectMemberAll();
    int updateMember(MemberVO memberVO);
    int deleteMember(String id);
}
