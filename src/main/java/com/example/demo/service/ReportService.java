package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

//import org.springframework.util.ResourceUtils;
import com.example.demo.dao.MemberRepository;
import com.example.demo.entity.MemberEntity;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	public String exportReport() throws FileNotFoundException, JRException {
		
		//your jrxml will export path
		String path = "/Users/haru/Desktop";
		List<MemberEntity> members = memberRepository.findAll();
		File file = ResourceUtils.getFile("src/test.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(members);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Haru");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		
		//export to PDF or HTML
//		JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "/member.html");
		JasperExportManager.exportReportToPdfFile(jasperPrint, path + "/member.pdf");
		return "report at :" + path + "/member.pdf";
	}

}
