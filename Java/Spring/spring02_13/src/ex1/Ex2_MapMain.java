package ex1;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex2_MapMain {
	public static void main(String[] args) {
		ApplicationContext ctx=new GenericXmlApplicationContext("ex1/map.xml");
		Ex2_Map ex2map=ctx.getBean("map2",Ex2_Map.class);
		Map<String,Integer> map=ex2map.getMap();
		for(Entry<String, Integer> elem : map.entrySet()) {
			System.out.println("도시이름:"+elem.getKey()+", 값:"+elem.getValue());
		}

	}

}
