package kr.or.kosta.mvc.inter;

import java.util.List;

public interface LogDao {
	public int getLogCount_All();
	public int getLogCount_CurrentDate();
	public List<Integer> getLogCount_Days();
	public List<Integer> getLogCount_Months();
	public List<Integer> getLogCount_Years();
}
