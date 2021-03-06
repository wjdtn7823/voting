package boo.web.voting.domain.members;


import boo.web.voting.domain.members.Member;
import boo.web.voting.domain.members.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;



    @GetMapping("/member/check")
    ResponseEntity duplicateEmailCheck(String email){

        Map<String, Object> map = new HashMap<>();
        memberService.duplicateCheck(email);

        map.put("msg","사용할 수 있는 아이디입니다.");
        return new ResponseEntity(map,HttpStatus.OK);
    }

    @PostMapping("/member/join")
    ResponseEntity  join(){

        //memberService.join(joinRequest);

        HttpHeaders header = new HttpHeaders();
        Member member = new Member();
        member.setName("부정수");

        header.setContentType(MediaType.TEXT_PLAIN);

        HttpEntity<String> entity = new HttpEntity<>("{\n" +
                "\t\"text\" :  \"Hello, this is some text\\nThis is more text. :tada:\"\n" +
                "}",header);


        return  new ResponseEntity(HttpStatus.OK);
    }


    @DeleteMapping("/member/delete")

    ResponseEntity deleteMember(String email, String password){
        Map<String, Object> map = new HashMap<>();
        memberService.deleteMember(email,password);
        map.put("msg","회원 탈퇴에 성공했습니다");
        return new ResponseEntity(map,HttpStatus.OK);

    }


}