package com.example.demo.board.controller;

import com.example.demo.board.service.BoardService;
import com.example.demo.board.vo.BoardVO;
import com.example.demo.board.vo.BoardVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@Log4j2
@Slf4j
@Controller
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {

    final BoardService boardService;

    @GetMapping("board")
    public String board(Model model){
        List<BoardVO> list = boardService.getAllBoards();
        model.addAttribute("list", list);
        return "board/board";
    }

    @GetMapping("create")
    public String create(BoardVO boardVO, Model model) {
        return "board/create";
    }

    @PostMapping("create2")
    public String create2(BoardVO boardVO, Model model) {
        try {
            int result = boardService.insertBoard(boardVO);
            if (result == 1) {
                model.addAttribute("boardVO", boardVO);
                return "board/create2";
            } else {
                return "error/error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error/error";
        }
    }


    @GetMapping("delete")
    public String delete(){
        return "board/deletePost";
    }

    @GetMapping("read")
    public String read(int no, Model model){
        BoardVO boardVO = boardService.getBoardByNo(no);
        if(boardVO != null){
            model.addAttribute("boardVO", boardVO);
        }
      return "board/read";
    }

    @GetMapping("update")
    public String update(){
        return "redirect:/"; //첫페이지를 클라이언트가 호출하도록 함.
        //return "update";
    }

    @PostMapping("update2")
    public String update2(BoardVO boardVO, Model model){
        model.addAttribute("boardVO", boardVO);
        return "board/update2";
    }
}
