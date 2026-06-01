package com.example.memberss.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.memberss.dto.MemberDto;
import com.example.memberss.mapper.MemberSqlMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberSqlMapper memberSqlMapper;

    @Transactional
    public void createMember(MemberDto memberDto){
        memberSqlMapper.createMember(memberDto);
    }

    public MemberDto getMemberById(int id){
        return memberSqlMapper.findById(id);
    }

    public List<MemberDto> getAllMembers(){
        return memberSqlMapper.findAll();
    }

    @Transactional
    public void updateMember(MemberDto memberDto){
        memberSqlMapper.updateMember(memberDto);
    }

    @Transactional
    public void removeMember(int id){
        memberSqlMapper.deleteById(id);
    }

}
