package com.rhfy.toyproject.controller;

import com.rhfy.toyproject.dao.MemberDao;
import com.rhfy.toyproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity<List<MemberDao>> getAllMembers() {
        return new ResponseEntity<>(memberService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<MemberDao> getMemberById(@PathVariable("id") String id) {
        Optional<MemberDao> member = memberService.findById(id);
        return new ResponseEntity<MemberDao>(member.get(), HttpStatus.OK);
    }

    @PostMapping(value = "/member/save", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MemberDao> save(HttpServletRequest request, @RequestBody MemberDao memberDao) {
        return new ResponseEntity<>(memberService.save(memberDao), HttpStatus.OK);
    }

    @PutMapping(value = "/member/update/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MemberDao> updateMember(@PathVariable("id") String id, @RequestBody MemberDao memberDao) {
        Optional<MemberDao> member = memberService.updateById(id, memberDao);
        return new ResponseEntity<MemberDao>(member.get(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/member/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteMember(@PathVariable("id") String id) {
        memberService.deleteById(id);
    }
}
