package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.dao.MemberRepository;
import com.example.demo.entity.MemberEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	public MemberEntity getMember(Integer no) {
        return memberRepository.findByMemNo(no);
    }
	
	
	
	
	
	
}
