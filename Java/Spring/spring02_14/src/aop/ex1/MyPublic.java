package aop.ex1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyPublic {
	public String todayMethod() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
}
