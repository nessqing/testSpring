package com.example.demo.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/baseTest")
@Api(tags = "baseTest")
public class BaseController {
	private static Logger log = LogManager.getLogger(BaseController.class);
	
	@GetMapping(value = "/test")
	public ResponseEntity<String> findAllStoreInfo() {
		log.info("log4j, im alive");
		log.info("Info level log message");
		
		
		return ResponseEntity.ok("testBaseController ok");
	}

}