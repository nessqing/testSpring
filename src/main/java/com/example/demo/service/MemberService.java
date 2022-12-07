package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.MemberRepository;
import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.MemberEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
	
	private final MemberRepository memberRepository;
	ModelMapper modelMapper = new ModelMapper();
	
	
	public MemberEntity getMember(Integer no) {
        return memberRepository.findByMemNo(no);
    }
	
	public List<MemberEntity> getMemberByState() {
        return memberRepository.findByMemStateTrue();
    }
	
	public List<MemberEntity> getAllMember() {
        return memberRepository.findAll();
    }
	
	public List<MemberEntity> getGenderMember(Integer gender) {
        return memberRepository.findByMemSex(gender);
    }
	
	public MemberEntity getMemberByMail(String mail) {
        return memberRepository.findByMemMail(mail);
    }
	
	public MemberEntity getMemberByMobile(String mobile) {
        return memberRepository.findByMemMobile(mobile);
    }
	
	@Transactional
	public void postMember(MemberDTO memberDTO) {
		
		MemberEntity memberEntity = modelMapper.map(memberDTO, MemberEntity.class);
		memberRepository.save(memberEntity);	
		
	}
	
	@Transactional
	public void putMember(Integer memberNo, MemberDTO memberDTO) {
		MemberEntity memberEntity = memberRepository.findByMemNo(memberNo);
		memberEntity = modelMapper.map(memberDTO, MemberEntity.class);
		memberEntity.setMemNo(memberNo);
		memberRepository.save(memberEntity);	
		
	}
	
	
}
