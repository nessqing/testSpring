package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.MemberEntity;
import com.example.demo.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
@Api(tags = "會員")
public class MemberController {

	private final MemberService memberService;

	@ApiOperation(value = "取得單筆會員資料")
	@GetMapping("getMember")
	public ResponseEntity<MemberEntity> getOneMember(@RequestParam Integer no) {
		return ResponseEntity.ok().body(memberService.getMember(no));
	}
	
	@ApiOperation(value = "取得單筆會員照片")
	@GetMapping("getMemberPhoto")
	public void getOneMemberPhoto(@RequestParam Integer no, HttpServletResponse rep) throws IOException {
		rep.setHeader("Content-Disposition", "attachment; filename=member.jpeg");
		memberService.getMemberPhoto(no, rep);
	}

	@ApiOperation(value = "取得還是會員的資料(testpostContainDoGet)")
	@PostMapping("getAllMember")
	public ResponseEntity<List<MemberEntity>> getALLMember() {
		return ResponseEntity.ok().body(memberService.getMemberByState());
	}

	@ApiOperation(value = "取得全會員資料")
	@GetMapping("getAllRegisteredMember")
	public ResponseEntity<List<MemberEntity>> getAllRegisteredMember() {
		return ResponseEntity.ok().body(memberService.getAllMember());
	}

	@ApiOperation(value = "取得特定性別全會員資料")
	@GetMapping("getGenderMember")
	public ResponseEntity<List<MemberEntity>> getGenderMember(
			@ApiParam(value = "male:1, female:2") @RequestParam Integer gender) {
		return ResponseEntity.ok().body(memberService.getGenderMember(gender));
	}

	@ApiOperation(value = "用email搜尋單筆會員資料")
	@GetMapping("getMemberByMail")
	public ResponseEntity<MemberEntity> getMemberByMail(@RequestParam String mail) {
		return ResponseEntity.ok().body(memberService.getMemberByMail(mail));
	}

	@ApiOperation(value = "用mobile搜尋單筆會員資料")
	@GetMapping("getMemberByMobile")
	public ResponseEntity<MemberEntity> getMemberByMobile(@RequestParam String mobile) {
		return ResponseEntity.ok().body(memberService.getMemberByMobile(mobile));
	}
	
	@ApiOperation(value = "新增會員")
	@PostMapping("postMember")
	public ResponseEntity<MemberDTO> postMember(@RequestBody MemberDTO memberDTO,@RequestPart("file") MultipartFile multipartFile, HttpServletRequest req) throws IOException, ServletException {
		memberService.postMember(memberDTO, multipartFile, req);
		return ResponseEntity.ok().body(memberDTO);
	}
	
	@ApiOperation(value = "修改會員資料")
	@PutMapping("putMember")
	public ResponseEntity<MemberDTO> putMember(@RequestParam Integer no ,@RequestBody MemberDTO memberDTO) {
		memberService.putMember(no, memberDTO);
		return ResponseEntity.ok().body(memberDTO);
	}

}
