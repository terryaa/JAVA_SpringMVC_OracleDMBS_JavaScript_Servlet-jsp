package kr.or.kosta.mvc.dao;

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
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.kosta.dto.TrafficVO;

@Repository
public class LoadPoiDao {
	
	private String[] BROWSER = {" "," ","Chrome","IE","Safari","Firefox","Opera","Mozilla"};
	
	public List<TrafficVO> readExsel() throws IOException {
		
		List<TrafficVO> list_vo = new ArrayList<TrafficVO>();

		String path = "C:\\Users\\KOSTA\\Documents\\īī���� ���� ����\\exam0304\\exam0304\\WebContent\\resources\\data\\data1.xls";
		FileInputStream fis = new FileInputStream(path);
		// �׼������� ����
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		int rowindex = 0;
		int columnindex = 0;
		// ��Ʈ �� (ù��°���� �����ϹǷ� 0�� �ش�)
		// ���� �� ��Ʈ�� �б����ؼ��� FOR���� �ѹ��� �����ش�
		HSSFSheet sheet = workbook.getSheetAt(0);
		// ���� ��
		int rows = sheet.getPhysicalNumberOfRows();
		for (rowindex = 1; rowindex < rows; rowindex++) {
			TrafficVO vo = new TrafficVO();
//			List<Map<String, Double>> list = new ArrayList<Map<String, Double>>();
			Map<String, Double> list = new HashMap<String, Double>();
			// ���� �д´�
			HSSFRow row = sheet.getRow(rowindex);
			if (row != null) {
				// ���� ��
				int cells = row.getPhysicalNumberOfCells();
				for (columnindex = 0; columnindex <= cells; columnindex++) {
					
					// ������ �д´�
					HSSFCell cell = row.getCell(columnindex);
					String value = "";
					// ���� ���ϰ�츦 ���� ��üũ
					if (cell == null) {
						continue;
					} else {
						// Ÿ�Ժ��� ���� �б�
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_FORMULA:
							value = cell.getCellFormula();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							value = String.valueOf(cell.getNumericCellValue() + "");
							break;
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							value = cell.getBooleanCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value = cell.getErrorCellValue() + "";
							break;
						}
					}
					if (rowindex != 1) {
						if (columnindex == 1) {
							vo.setDate(value);
						} else {
							list.put(BROWSER[columnindex], Double.valueOf(value));
							if(columnindex == 7) {
								vo.setList(list);
								list_vo.add(vo);
							}
						}
					}
				}
			}
		}
//		for (TrafficVO e : list_vo) {
//			System.out.println(e.getDate() + " : " + e.getList());
//		}
		return list_vo;
	}
	
	
	public TrafficVO traffic_detail(int idx) throws IOException {
		
		List<TrafficVO> list_vo = new ArrayList<TrafficVO>();

		String path = "C:\\Users\\KOSTA\\Documents\\īī���� ���� ����\\exam0304\\exam0304\\WebContent\\resources\\data\\data1.xls";
		FileInputStream fis = new FileInputStream(path);
		// �׼������� ����
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		int rowindex = 0;
		int columnindex = 0;
		// ��Ʈ �� (ù��°���� �����ϹǷ� 0�� �ش�)
		// ���� �� ��Ʈ�� �б����ؼ��� FOR���� �ѹ��� �����ش�
		HSSFSheet sheet = workbook.getSheetAt(0);
		// ���� ��
		int rows = sheet.getPhysicalNumberOfRows();
		for (rowindex = 1; rowindex < rows; rowindex++) {
			TrafficVO vo = new TrafficVO();
//			List<Map<String, Double>> list = new ArrayList<Map<String, Double>>();
			Map<String, Double> list = new HashMap<String, Double>();
			// ���� �д´�
			HSSFRow row = sheet.getRow(rowindex);
			if (row != null) {
				// ���� ��
				int cells = row.getPhysicalNumberOfCells();
				for (columnindex = 0; columnindex <= cells; columnindex++) {
					
					// ������ �д´�
					HSSFCell cell = row.getCell(columnindex);
					String value = "";
					// ���� ���ϰ�츦 ���� ��üũ
					if (cell == null) {
						continue;
					} else {
						// Ÿ�Ժ��� ���� �б�
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_FORMULA:
							value = cell.getCellFormula();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							value = String.valueOf(cell.getNumericCellValue() + "");
							break;
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							value = cell.getBooleanCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value = cell.getErrorCellValue() + "";
							break;
						}
					}
					if (rowindex != 1) {
						if (columnindex == 1) {
							vo.setDate(value);
						} else {
							list.put(BROWSER[columnindex], Double.valueOf(value));
							if(columnindex == 7) {
								vo.setList(list);
								list_vo.add(vo);
							}
						}
					}
				}
			}
		}
//		for (TrafficVO e : list_vo) {
//			System.out.println(e.getDate() + " : " + e.getList());
//		}
		return list_vo.get(idx);
	}
	
	
	

//	public static void main(String[] args) {
//		TestLoadPoi poi = new TestLoadPoi();
//		try {
//			List<TrafficVO> aa = poi.readExsel();
//			for (TrafficVO e : aa) {
//			System.out.println(e.getDate() + " : " + e.getList());
//		}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}


}
