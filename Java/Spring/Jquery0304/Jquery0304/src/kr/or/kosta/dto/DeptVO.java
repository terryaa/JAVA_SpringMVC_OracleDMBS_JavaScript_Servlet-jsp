package kr.or.kosta.dto;

import java.util.List;

public class DeptVO {
	private int deptno;
	private String dname,loc;
	
	
	public DeptVO() {
	}	
	public DeptVO(Integer deptno, String dname) {
		this.deptno = deptno;
		this.dname = dname;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
