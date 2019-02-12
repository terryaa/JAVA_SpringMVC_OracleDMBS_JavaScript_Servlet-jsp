package controller;
//Model�� �������ִ� ��ü , Servlet�� �����ϴ� ��ü,
//Servlet���� ��û�� ���� ����  ������ �������� �� �������̽��� ��ȯ!

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import model.Action;
import model.HelloAction;
import model.TodayAction;

public class ActionFactory {
	// �̱��� �ۼ�!
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
			// newInstance() : Ŭ������ ��ü�� ����
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
