package com.example.memberss.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.memberss.dto.MemberDto;
import com.example.memberss.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberContoller {
    private final MemberService memberService;

    @PostMapping
    public String createMember(@RequestBody MemberDto memberDto){
        memberService.createMember(memberDto);
        return "회원 등록 성공";
    }

    @GetMapping("/{id}")
    public MemberDto getMemberById(@PathVariable("id")int id){
        return memberService.getMemberById(id);
    }

    @GetMapping
    public List<MemberDto> getAllMembers(){
        return memberService.getAllMembers();
    }

    @PutMapping
    public String updateMember(@RequestBody MemberDto memberDto){
        memberService.updateMember(memberDto);
        return "회원정보 수정 성공";
    }

    @DeleteMapping("/{id}")
    public String removeMember(@PathVariable("id") int id){
        memberService.removeMember(id);
        return "회원 삭제 성공";
    }
}
