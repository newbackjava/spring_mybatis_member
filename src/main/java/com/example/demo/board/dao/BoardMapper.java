package com.example.demo.board.dao;

import com.example.demo.board.vo.BoardVO;
import com.example.demo.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insertBoard(BoardVO boardVO);
    BoardVO selectBoardByNo(int no);
    List<BoardVO> selectBoardAll();
    int updateBoard(BoardVO boardVO);
    int deleteBoard(int no);
}
