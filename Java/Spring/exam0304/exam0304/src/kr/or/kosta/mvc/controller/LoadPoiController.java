package kr.or.kosta.mvc.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.kosta.dto.TrafficVO;
import kr.or.kosta.mvc.dao.LoadPoiDao;
@RestController
@RequestMapping("/traffic")
public class LoadPoiController {
	
	@Autowired
	LoadPoiDao poiDao;
	
	@RequestMapping("/traffic1")
	public List<TrafficVO> readExsels() throws IOException {
		
		List<TrafficVO> list_vo = poiDao.readExsel();
		return list_vo;
	}
	
	
	@RequestMapping("/traffic_detail")
	public TrafficVO traffic_detail(int idx) throws IOException {
			TrafficVO vo = poiDao.traffic_detail(idx);
		return vo;
	}
	
	

}
