package controller;
//Model을 관리해주는 객체 , Servlet이 접근하는 객체,
//Servlet에게 요청에 따른 모델을  다형성 생성한후 그 인터페이스를 반환!

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import model.Action;
import model.HelloAction;
import model.TodayAction;

public class ActionFactory {
	// 싱글톤 작성!
	private static ActionFactory factory;
	private Properties prop;
	private ActionFactory() {
		prop = new Properties();
	}
	public static synchronized ActionFactory getFactory() {
		if(factory == null) factory = new ActionFactory();
		return factory;
	}
	// cmd = > http://host/contextPath/cont?cmd=hello
	public Action getAction(String cmd) {
		Action action = null;
		
		try {
			prop.load(new FileInputStream("C:\\bigdataStudy\\webapp\\workspace\\webApp0211\\src\\controller\\classinfo.properties"));
			System.out.println("key:"+prop.getProperty(cmd));
			String rPath = prop.getProperty(cmd);
			if(rPath == null) {
				cmd = "index";
				rPath = prop.getProperty(cmd);
			}
			Class<Action> haClass = (Class<Action>) Class.forName(rPath);
			// newInstance() : 클래스를 객체로 생성
			action = haClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		if(cmd.equals("hello")) {
//			action = new HelloAction();
//		}else if(cmd.equals("today")) {
//			action = new TodayAction();
//		}
		return action;
	}
}
