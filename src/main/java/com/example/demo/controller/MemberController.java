package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MemberEntity;
import com.example.demo.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
@Api(tags = "會員資料")
public class MemberController {
	
	private final MemberService memberService;
	@ApiOperation(value = "取得會員資料")
    @GetMapping("getMember")
    public ResponseEntity<MemberEntity> getOneMemberData(@RequestParam Integer no) {
        return ResponseEntity.ok().body(memberService.getMember(no));
    }

}
