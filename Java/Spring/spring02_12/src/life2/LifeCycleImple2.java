package life2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class LifeCycleImple2 implements 
LifeCycleInter2,InitializingBean,DisposableBean,
BeanNameAware,ApplicationContextAware,BeanFactoryAware{
//InitializingBean -> afterPropertiesSet ==init()부루는애
//DisposableBean -> destroy == destroy()부르는애
//BeanNameAware -> setBeanName(String name)
//스프링 컨테이너에서 관리되는 bean내부 id,name 의정보를 확인할때 제공해주는 인터페이스이다.
//BeanFactoryAware -> setBeanFactroy
//ApplicationContextAware -> setApplicationConText(ApplicaionContext context)
//ApplicationContext 는 ListableBean, BeanFactory를 상속받는다. 

//ApplicationContext와 BeanFactory가 Spring Container역할을 하는셈이다.
//DI를 해야하는 모든 객체를 생산하고다루게된다.
	
//다른것들을 implements하는이유? ctx변수가가르키는 ApplicationContext 객체는
//다른 컨테이너사용시 다른 곳을 가르키게된다.(thread하게되면)
//따라서 ApplicationContext안의 Bean,Factory주소를 가져와서 따로사용하면 ctx가 바뀌어도
//원래참조하던자료를참조할수있따.
//Spring MVS에서는 따라서 ApplicationContext를 한번만 생성되어쓰이는 
//Singleton의 Controller에 넣어서 사용한다.
	
	
	private String typename;
	private String beanname;
	private ApplicationContext ctx;
	private BeanFactory bf;
	
	
	public void setTypename(String typename) {
		this.typename = typename;
		System.out.println("생성자 호출!");
	}
	@Override
	public void execute() {
		//ctx는 현재 빈이 속해있는 ApplicationContext.
		//그것을 가져와서 other를 getBean함으로서 가져온다. DI를 XML에서 따로 명시하지않아도
		//DI가 되지않았지만 가져오는것과같다. 
		System.out.println(typename+",execute 실행");
		System.out.println("Bean name:"+beanname);
		OtherBean otbean=ctx.getBean("other",OtherBean.class);
		System.out.println("res:"+otbean.getMsg());
		// TODO Auto-generated method stub
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("init 호출!");
	}
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroy 호출!");
		
	}
	
	//setBeanName도 마찬가지.
	//setBeanName도 알아서실행된다.
	//Intercepter가 가지고있는자원중 setBeanName의 인자값과 일치하는 instance를
	//instanceof로 찾아서 인자값으로넣어준다.
	
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		this.beanname=name;
		System.out.println(beanname);
		
	}
	//Intercepter의 역할 : setApplicationContext같은 메소드가 실행되면
	//해당 메소드에 필요로 되어지는 인자값의 데이터타입을 instance of 로 검사하여
	//맞으면 해당하는 데이터클래스의 자기가가지고있는 객체를 인자값으로 보내준다.
	//그렇게함으로서 밑에서 ctx에 applcationContext가 들어가게되는것이다.
	//Init 전에 실행된다.
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.ctx=applicationContext;
		System.out.println(ctx);
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		this.bf=beanFactory;
		System.out.println(bf);
	}

}
