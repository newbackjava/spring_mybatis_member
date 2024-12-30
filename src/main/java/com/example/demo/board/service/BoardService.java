package com.example.demo.board.service;

import com.example.demo.board.dao.BoardMapper;
import com.example.demo.board.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardMapper boardMapper;

    @Autowired
    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public int insertBoard(BoardVO boardVO) {
        return boardMapper.insertBoard(boardVO);
    }

    public BoardVO getBoardByNo(int no) {
        return boardMapper.selectBoardByNo(no);
    }

    public List<BoardVO> getAllBoards() {
        return boardMapper.selectBoardAll();
    }

    public int updateBoard(BoardVO boardVO) {
        return boardMapper.updateBoard(boardVO);
    }

    public int deleteBoard(int no) {
        return boardMapper.deleteBoard(no);
    }
}
