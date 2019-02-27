package kr.or.kosta.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebjsoupController {
	
	@GetMapping("/jsoup")
	public String jsoup(Model m) {
		String URL = "https://weather.naver.com/rgn/cityWetrMain.nhn";
		Document doc;
		try {
			doc=Jsoup.connect(URL).get();
			Elements elem = doc.select("#content>table>tbody>tr:nth-child(1)");
			//데이터만 추출할 경우
			String[] str = elem.text().split(" ");
			for(String e: str) {
				System.out.println(e);
			}
			//element를 추출할 경우 - tr까지 다 적용 table <tr>
			System.out.println("elem :"+elem);
			System.out.println("str :"+str);
			m.addAttribute("elem",elem);
			
			//이미지만 추출할 경우
			Elements elem2 = doc.select("#content>table>tbody>tr:nth-child(1) img");		
			System.out.println("elem2 :"+elem2);
			m.addAttribute("elem2",elem2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "jsoup1";
	}
	
	
	@GetMapping("/jsoup2")
	public String webtoon(String url,String selector,Model m) {
		Document document;
		try {
			document = Jsoup.connect(url).get();
			Elements elements = document.select(selector);
			List<String> list = new ArrayList<String>();
//			String[] str = elements.text().split(" ");
			for(Element e: elements) {
				System.out.println(e);
				list.add(e.text());
			}
			m.addAttribute("list",list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "jsoup2";
	}
	
	@GetMapping("/jsoup3")
	public String inputweb() {
		return "jsoup3";
	}
}
