package com.example.demo.controller;

import java.util.HashMap;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
public class JasperTest
{
	public static void main(String[] args)
	{
		String fileName = "/Users/haru/Desktop/project/testSpring/src/test.jrxml";
		String outFileName = "/Users/haru/Desktop/project/testSpring/src/test.pdf";
		HashMap hm = new HashMap();
		try
		{
			JasperPrint print = JasperFillManager.fillReport(
				fileName,
				hm,
				new JREmptyDataSource());
			JRExporter exporter = 
				new net.sf.jasperreports.engine.export.JRPdfExporter();
			exporter.setParameter(
				JRExporterParameter.OUTPUT_FILE_NAME,
				outFileName);
			exporter.setParameter(
			JRExporterParameter.JASPER_PRINT,print);
			exporter.exportReport();
			System.out.println("Created file: " + outFileName);
		}
		catch (JRException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
			
		}
	}
}
