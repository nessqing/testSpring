package com.example.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
	
	public void getMemberPhoto(Integer no, HttpServletResponse rep) throws IOException {
		ServletOutputStream out = rep.getOutputStream();
		MemberEntity photo = memberRepository.findByMemNo(no);
	    out.write(photo.getMemImage());
	    out.close();		

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
	public void postMember(MemberDTO memberDTO, MultipartFile multipartFile, HttpServletRequest req) throws IOException, ServletException {
		
		Part memImage = req.getPart("file");
		InputStream in = memImage.getInputStream();
		byte[] img = null;
		img = new byte[in.available()];
		in.read(img);
		in.close();
		MemberEntity memberEntity = modelMapper.map(memberDTO, MemberEntity.class);
		memberEntity.setMemImage(img);
		memberRepository.save(memberEntity);	
		
	}
	
	@Transactional
	public void putMember(MemberDTO memberDTO) throws IOException, ServletException {
		
//		Part memImage = req.getPart("file");
//		InputStream in = memImage.getInputStream();
//		byte[] img = null;
//		img = new byte[in.available()];
//		in.read(img);
//		in.close();
		MemberEntity memberEntity = modelMapper.map(memberDTO, MemberEntity.class);
//		memberEntity.setMemImage(img);
		
		memberRepository.save(memberEntity);	
		
	}
	
	
}
