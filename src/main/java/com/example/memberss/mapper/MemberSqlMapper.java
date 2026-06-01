package com.example.memberss.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.memberss.dto.MemberDto;

@Mapper
public interface MemberSqlMapper {

    //Create
    void createMember(MemberDto memberDto);

    //Read
    MemberDto findById(int id);

    List<MemberDto> findAll();

    //Update
    void updateMember(MemberDto memberDto);

    //Delete
    void deleteById(int id);

}
