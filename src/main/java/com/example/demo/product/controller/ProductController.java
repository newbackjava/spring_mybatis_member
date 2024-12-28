package com.example.demo.product.controller;

import com.example.demo.board.vo.BoardVO;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Log4j2
@Slf4j
@Controller
@RequestMapping("board")
public class BoardController {

    @GetMapping("board")
    public String board(HttpSession session){
        session.setAttribute("userId", "apple");
        return "board/board";
    }

    @GetMapping("createPost")
    public String create() {
        return "board/createPost";
    }

    @PostMapping("createPost2")
    public String create2(BoardVO boardVO, Model model){
        model.addAttribute("boardVO", boardVO);
        return "board/createPost2";
    }

    @GetMapping("deletePost")
    public String delete(){
        return "board/deletePost";
    }

    @PostMapping("viewPost")
    public String create(int no, Model model){
      return "board/viewPost";
    }

    @GetMapping("editPost")
    public String update(){
        return "redirect:/"; //첫페이지를 클라이언트가 호출하도록 함.
        //return "update";
    }

    @PostMapping("editPost2")
    public String update2(BoardVO boardVO, Model model){
        model.addAttribute("boardVO", boardVO);
        return "board/editPost2";
    }
}
