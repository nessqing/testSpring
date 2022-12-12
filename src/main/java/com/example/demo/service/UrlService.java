package com.example.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

@Service
public class urlService {

	public void zipurlPDF(HttpServletResponse rep) throws IOException {
		URL url = new URL(
				"https://www.megabank.com.tw/-/media/mega/files/bank/about/download/standard-contract/deposit-contract/dp-contract03.pdf?la=zh-tw&hash=58F01E643F90912D35652A63D079F8DB?v=20210225");
		
		
		InputStream in = url.openStream();
		ServletOutputStream out = rep.getOutputStream();
		System.out.println(out);
		ZipOutputStream zos = new ZipOutputStream(out);
		System.out.println(zos);
		zos.putNextEntry(new ZipEntry("test.pdf"));

		int length = -1;
		byte[] buffer = new byte[1024];
		while ((length = in.read(buffer)) > -1) {
			zos.write(buffer, 0, length);
		}
		zos.close();
		in.close();
		out.close();
		System.out.println("File downloaded");
	}

}
