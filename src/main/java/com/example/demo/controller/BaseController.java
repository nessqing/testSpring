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
@RequestMapping("/baseTest")
@Api(tags = "baseTest")
public class BaseController {

	@GetMapping(value = "/test")
	public ResponseEntity<String> findAllStoreInfo() {

		return ResponseEntity.ok("test");
	}

}