package kr.or.kosta.dto;

import java.util.List;

public class JsonVO {
	//True, False
	private boolean success;
	private List<customerVO> list;
	//List �� �� CustomerVO�� ����
	private int total_cnt;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<customerVO> getList() {
		return list;
	}
	public void setList(List<customerVO> list) {
		this.list = list;
	}
	public int getTotal_cnt() {
		return total_cnt;
	}
	public void setTotal_cnt(int total_cnt) {
		this.total_cnt = total_cnt;
	}
}
