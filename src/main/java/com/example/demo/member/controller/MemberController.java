package com.example.demo.member.controller;

import com.example.demo.member.service.MemberService;
import com.example.demo.member.vo.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("member")
    public String member(){
        return "member/member";
        //return하는 String인 member에 index.html을 만들어 호출하여 http응답함.
        //templates아래 member.html을 호출
    }


    @GetMapping("create")
    public String create(){
        log.info("create 요청됨.");
        //return "create2";
        return "member/create";
    }

    @PostMapping("create2")
    public String create2(MemberVO memberVO, Model model){
        log.info("create2 요청됨.");
        MemberVO memberVO2 = memberService.createMember(memberVO);
        System.out.println("insert 결과 ====> " + memberVO2);
        model.addAttribute("memberVO", memberVO);
        return "member/create2";
    }

    @GetMapping("delete")
    public String delete(String id, HttpSession session) {
        int result = memberService.deleteMember(id);
        if (result == 1) {
            session.removeAttribute("id");
        }
        return "redirect:/";
    }

    @PostMapping("read")
    public String create(String id, Model model){
        //String id = request.getParameter("id");
        //@RequestParam("id") int id
        //==> 전달받은 파라메터이름과 저장할 변수이름이 다른 경우 사용
        System.out.println("id >>>>>>>>>>>>>>>>>>>>>" + id);
        MemberVO memberVO = memberService.getMemberById(id);
        System.out.println(memberVO);
        model.addAttribute("memberVO", memberVO);
        return "member/read";
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


    @PostMapping("login")
    public String login(String id, String pw, HttpSession session, Model model){
        MemberVO memberVO = memberService.getMemberById(id);
        if(memberVO != null) {
            if (pw.equals(memberVO.getPw())) {
                session.setAttribute("id", id);
            }
        }else{
            model.addAttribute("result", "로그인 실패! 재입력 해주세요.!");
        }
        System.out.println("세션값 설정 완료>> " + session.getAttribute("id") );
        return "/member/member";
    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("id");
        System.out.println("삭제된 세션값 설정 완료>> " + session.getAttribute("id") );
        return "redirect:/";
    }

    @GetMapping("update")
    public String update(String id, Model model){
        System.out.println("id >>>>>>>>>>>>>>>>>>>>>" + id);
        MemberVO memberVO = memberService.getMemberById(id);
        System.out.println("memberVO >>>>>>>>>>>>>>>>>>>>>" + memberVO);
        model.addAttribute("memberVO", memberVO);
        return "member/update";
    }

    @PostMapping("update2")
    public String update2(MemberVO memberVO, Model model){
        int result = memberService.updateMember(memberVO);
        if(result == 1){
            System.out.println("memberVO >>>>>>>>>>>>>>>>>>>>>" + memberVO);
            model.addAttribute("memberVO", memberVO);
        }
        return "member/update2";
    }
}


//        @PostMapping("login")
//        public String login(String id, String pw, HttpSession session){
//            // 서비스 계층에서 로그인 검증 처리
//            boolean isLoginSuccessful = memberService.validateLogin(id, pw);
//
//            if (isLoginSuccessful) {
//                session.setAttribute("id", id); // 로그인 성공 시 세션에 ID 저장
//                System.out.println("로그인 성공, 세션값 설정 완료>> " + session.getAttribute("id"));
//                return "/member/member";
//            } else {
//                System.out.println("로그인 실패: 아이디 또는 비밀번호 불일치");
//                return "/member/login"; // 로그인 실패 시 로그인 페이지로 이동
//            }
//        }
