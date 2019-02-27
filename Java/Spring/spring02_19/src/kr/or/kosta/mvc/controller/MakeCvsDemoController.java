package kr.or.kosta.mvc.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MakeCvsDemoController {
	@GetMapping("/cstart")
	public String loadCvs() {
		String path="C:\\bigdata\\KOSTA_MAC\\Java\\Spring\\spring02_19\\WebContent\\resources\\data\\newData.csv";
		PrintWriter pw = null;
		try {
			pw=new PrintWriter(new File(path));
			StringBuffer sb = new StringBuffer();
			String cNameList = "Id,Name";
			sb.append(cNameList+"\n");
			for(int i =0; i<10; i++) {
				sb.append((i+1)).append(",");
				sb.append("park").append((i+1));
				sb.append("\n");
			}
			pw.write(sb.toString());
			pw.close();
			System.out.println("¸¶¹«¸®");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "success";
	}
}
