package kr.or.kosta.mvc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.or.kosta.dto.MiniBoardDTO;

@Controller
public class UploadDemoController {

	
		@GetMapping("/upform")
		public String upform() {
			return "upform";
		}
		
		@GetMapping("upup")
		public String upup() {
			return "upup";
		}
		
		/*
		 * MultiPartFile mfile : 업로드 파라미터를 처리
		 * CommonsMultipartResolver 라는 별도의 Resolver
		 * Commom관련 라이브러리가 필요
		 */
		@PostMapping("/upload")
		public String uploadFile(
				MultipartFile mfile,
					Model m, HttpServletRequest request) {
			String img_path = "resources//img";
			String r_path = request.getRealPath("/");
			String oriFn = mfile.getOriginalFilename();
			long size = mfile.getSize();
			String contentType = mfile.getContentType();
			System.out.println(r_path);
			System.out.println("파일명:"+oriFn);
			System.out.println("파일크기:"+size);
			System.out.println("Type :"+contentType);
			StringBuffer path = new StringBuffer();
			path.append(r_path).append(img_path).append("\\");
			path.append(oriFn);
			System.out.println("경로 : " + path);
			File f = new File(path.toString());
			System.out.println(f.exists());
			
			//파일 업로드 진행
			try {
				mfile.transferTo(f);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			m.addAttribute("imgName", oriFn);
			//끝난 이미지의 이름은 imgName
			return "uploadSuccess";
		}
		
		@PostMapping("/upupload")
		public String upupload(
				MiniBoardDTO dto,
				Model m, HttpServletRequest request) {
			String img_path = "resources//img";
			String r_path = request.getRealPath("/");
			MultipartFile mfile = dto.getMfile();
			String writt = dto.getWriter();
			String oriFn = mfile.getOriginalFilename();
			long size = mfile.getSize();
			String contentType = mfile.getContentType();
			System.out.println(r_path);
			System.out.println("파일명:"+oriFn);
			System.out.println("파일크기:"+size);
			System.out.println("Type :"+contentType);
			StringBuffer path = new StringBuffer();
			path.append(r_path).append(img_path).append("\\");
			path.append(oriFn);
			System.out.println(path);
			File f = new File(path.toString());
			System.out.println(f.exists());
			
			//파일 업로드 진행
			try {
				mfile.transferTo(f);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			m.addAttribute("imgName", oriFn);
			m.addAttribute("dto", dto);
			//끝난 이미지의 이름은 imgName
			return "uploadSuccessss";
		}
		
		
		
}
