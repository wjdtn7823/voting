package boo.web.voting.domain.members;


import boo.web.voting.domain.members.Member;
import boo.web.voting.domain.members.MemberService;
import boo.web.voting.web.dto.UserCreateRequestDto;
import boo.web.voting.web.dto.UserDeleteRequestDto;
import boo.web.voting.web.dto.UserLoginRequestDto;
import boo.web.voting.web.dto.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MemberController {


    private final MemberService memberService;

    @GetMapping("/member/check")
    ResponseEntity duplicateEmailCheck(@RequestParam("email") String email){

        Map<String, Object> map = new HashMap<>();
        memberService.duplicateCheck(email);

        map.put("msg","사용할 수 있는 아이디입니다.");
        return new ResponseEntity(map,HttpStatus.OK);
    }

    @PostMapping("/member")
    Long  join(@RequestBody UserCreateRequestDto requestDto){

        return memberService.createUser(requestDto);

    }

    @DeleteMapping("/member/")
    ResponseEntity deleteMember(@RequestBody  UserDeleteRequestDto requestDto){
        Map<String, Object> map = new HashMap<>();
        memberService.deleteMember(requestDto);
        map.put("msg","회원 탈퇴에 성공했습니다");
        return new ResponseEntity(map,HttpStatus.OK);

    }
    @PutMapping("/member/")
    ResponseEntity updateMember(@RequestParam("email") String email, UserUpdateRequestDto dto){
        Map<String, Object> map = new HashMap<>();
        memberService.updateMember(email,dto);
        map.put("msg","회원 수정에 성공했습니다");
        return new ResponseEntity(map,HttpStatus.OK);
    }

}