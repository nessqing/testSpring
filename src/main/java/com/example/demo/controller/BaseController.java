package com.example.demo.controller;


import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MemberRepository;
import com.example.demo.service.ReportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;


@RequiredArgsConstructor
@RestController
@RequestMapping("/baseTest")
@Api(tags = "baseTest")
public class BaseController {
	private static Logger log = LogManager.getLogger(BaseController.class);
	
	/**
	 * JasperReportBegin
	 */
	@Autowired
	private ReportService reportService;
	
	@ApiOperation(value = "JasperReport get all member test")
	@GetMapping(value = "/report")
	public String generateReport() throws FileNotFoundException, JRException {
		return reportService.exportReport();
	}
	/**
	 * JasperReportEnd
	 */
	
	
	@GetMapping(value = "/test")
	public ResponseEntity<String> findAllStoreInfo() {
		
		//log4j test info
		log.info("log4j, im alive");
		log.info("Info level log message");
		
		
		return ResponseEntity.ok("testBaseController ok");
	}

}