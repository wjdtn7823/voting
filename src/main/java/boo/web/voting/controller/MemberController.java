package boo.web.voting.controller;


import boo.web.voting.service.user.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;


    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Object> duplicateEx(Exception e)
    {
        Map <String ,String> map = new HashMap<>();

        map.put("msg",e.getMessage());
        return new ResponseEntity<Object>(map,HttpStatus.FORBIDDEN);
    }


    @PostMapping("/user/checkemail")
    ResponseEntity<Object> check(String email){
        memberService.findByEmail(email);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/user/join")
    ResponseEntity<Object> join(){

        return ResponseEntity.ok().body(" ");
    }
}
