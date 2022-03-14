package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 생성자 주입 (추천)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
}

/*
    // 필드 주입 (비추 - 나중에 무엇을 수정할 방법이 없다.)
    @Autowired
    private MemberService memberService;

    // Setter 주입 (비추 - 다시 바뀔일이 없는데 퍼블릭으로 열려있음)
    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
*/
