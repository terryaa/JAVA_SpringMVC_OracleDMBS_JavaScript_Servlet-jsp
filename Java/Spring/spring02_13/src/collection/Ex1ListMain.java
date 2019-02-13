package collection;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex1ListMain {
	public static void main(String[] args) {
		ApplicationContext ctx=
				new GenericXmlApplicationContext("collection/list.xml");
		Ex1List list1=ctx.getBean("list1",Ex1List.class);
		
		Ex1List list2=ctx.getBean("list2",Ex1List.class);
		List<String> strList=list1.getItems();
		List<Float> floatList=list2.getItemsf();
		
		for( String s : strList) {
			System.out.println(s);
		}
		for(Float f:floatList) {
			System.out.println(f);
		}
		list2=ctx.getBean("list3",Ex1List.class);
		floatList=list2.getItemsf();
		for(Float f:floatList) {
			System.out.println(f);
		}
	}

}
