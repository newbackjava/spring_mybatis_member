package com.example.demo.controller;

import com.example.demo.vo.MemberVO;
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
@RequestMapping("member")
public class MemberController {

    @GetMapping("create")
    public String create(){
        //return "create2";
        return "member/create";
    }

    @PostMapping("create2")
    public String create2(MemberVO memberVO, Model model){
        model.addAttribute("memberVO", memberVO);
        return "member/create2";
    }

    @GetMapping("delete")
    public String delete(){
        return "member/delete";
    }

    @PostMapping("read")
    public String create(int id, Model model){
        //String id = request.getParameter("id");
        //@RequestParam("id") int id
        //==> 전달받은 파라메터이름과 저장할 변수이름이 다른 경우 사용
        model.addAttribute("id", id);
        model.addAttribute("name", "hong");
        return "member/read";
    }

    @PostMapping("login")
    public String login(int id, String pw, HttpSession session, Model model){
        if(id == 100 & pw.equals("1234")){
            session.setAttribute("id", id);
        }
        return "member/member";
    }

    /*
    //위 코드와 동일
    @GetMapping("read")
    public ModelAndView read(String id) {
        ModelAndView modelAndView = new ModelAndView("read");
        modelAndView.addObject("id", id); //Object으로 형변환되어 들어감.
        modelAndView.addObject("name", "hong");
        return modelAndView;
    }
    */



    @GetMapping("update")
    public String update(){
        return "redirect:/"; //첫페이지를 클라이언트가 호출하도록 함.
        //return "update";
    }

    @PostMapping("update2")
    public String update2(MemberVO memberVO, Model model){
        model.addAttribute("memberVO", memberVO);
        return "member/update2";
    }
}
