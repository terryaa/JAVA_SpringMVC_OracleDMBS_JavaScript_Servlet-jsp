package life2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class LifeCycleMain2 {
	public static void main(String[] args) {
		ApplicationContext ctx=
				new GenericXmlApplicationContext("life2/life2.xml");
		LifeCycleInter2 life2=ctx.getBean("life2",LifeCycleImple2.class);
		life2.execute();
	}

}
