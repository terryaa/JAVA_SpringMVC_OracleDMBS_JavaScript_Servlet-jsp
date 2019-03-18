package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import kr.or.kosta.dto.TrafficVO;

public class TestLoadPoi {
	private List<Double> list = new ArrayList<Double>();;
	public void readExsel() throws IOException {
		
		List<TrafficVO> list_vo = new ArrayList<TrafficVO>();

		TrafficVO vo = new TrafficVO();
		

		String path = "C:\\bigdatastudy\\spring\\workspace\\spring_MVC\\WebContent\\resources\\xls\\data.xls";
		FileInputStream fis = new FileInputStream(path);
		// 액셀파일을 생성
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		int rowindex = 0;
		int columnindex = 0;
		// 시트 수 (첫번째에만 존재하므로 0을 준다)
		// 만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
		HSSFSheet sheet = workbook.getSheetAt(0);
		// 행의 수
		int rows = sheet.getPhysicalNumberOfRows();
		for (rowindex = 1; rowindex < rows; rowindex++) {
			// 행을 읽는다
			HSSFRow row = sheet.getRow(rowindex);
			if (row != null) {
				// 셀의 수
				int cells = row.getPhysicalNumberOfCells();
				for (columnindex = 0; columnindex <= cells; columnindex++) {
					// 셀값을 읽는다
					HSSFCell cell = row.getCell(columnindex);
					String value = "";
					// 셀이 빈값일경우를 위한 널체크
					if (cell == null) {
						continue;
					} else {
						// 타입별로 내용 읽기
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
							
							list.add(Double.valueOf(value));
							
						}
					}
//					System.out.print("각 셀 내용 :" + value);

				}
				vo.setList(list);
				list_vo.add(vo);
			}
			
			
//			System.out.println("==============================");
		}
		for (TrafficVO e : list_vo) {
			System.out.println(e.getDate() + " : " + e.getList());
		}
	}

	public static void main(String[] args) throws IOException {
		TestLoadPoi poi = new TestLoadPoi();
		poi.readExsel();
	}

}
