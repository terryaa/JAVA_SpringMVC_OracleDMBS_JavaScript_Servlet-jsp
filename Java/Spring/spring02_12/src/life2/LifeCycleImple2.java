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
//InitializingBean -> afterPropertiesSet ==init()�η�¾�
//DisposableBean -> destroy == destroy()�θ��¾�
//BeanNameAware -> setBeanName(String name)
//������ �����̳ʿ��� �����Ǵ� bean���� id,name �������� Ȯ���Ҷ� �������ִ� �������̽��̴�.
//BeanFactoryAware -> setBeanFactroy
//ApplicationContextAware -> setApplicationConText(ApplicaionContext context)
//ApplicationContext �� ListableBean, BeanFactory�� ��ӹ޴´�. 

//ApplicationContext�� BeanFactory�� Spring Container������ �ϴ¼��̴�.
//DI�� �ؾ��ϴ� ��� ��ü�� �����ϰ�ٷ�Եȴ�.
	
//�ٸ��͵��� implements�ϴ�����? ctx����������Ű�� ApplicationContext ��ü��
//�ٸ� �����̳ʻ��� �ٸ� ���� ����Ű�Եȴ�.(thread�ϰԵǸ�)
//���� ApplicationContext���� Bean,Factory�ּҸ� �����ͼ� ���λ���ϸ� ctx�� �ٲ�
//���������ϴ��ڷḦ�����Ҽ��ֵ�.
//Spring MVS������ ���� ApplicationContext�� �ѹ��� �����Ǿ�̴� 
//Singleton�� Controller�� �־ ����Ѵ�.
	
	
	private String typename;
	private String beanname;
	private ApplicationContext ctx;
	private BeanFactory bf;
	
	
	public void setTypename(String typename) {
		this.typename = typename;
		System.out.println("������ ȣ��!");
	}
	@Override
	public void execute() {
		//ctx�� ���� ���� �����ִ� ApplicationContext.
		//�װ��� �����ͼ� other�� getBean�����μ� �����´�. DI�� XML���� ���� ��������ʾƵ�
		//DI�� �����ʾ����� �������°Ͱ�����. 
		System.out.println(typename+",execute ����");
		System.out.println("Bean name:"+beanname);
		OtherBean otbean=ctx.getBean("other",OtherBean.class);
		System.out.println("res:"+otbean.getMsg());
		// TODO Auto-generated method stub
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("init ȣ��!");
	}
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroy ȣ��!");
		
	}
	
	//setBeanName�� ��������.
	//setBeanName�� �˾Ƽ�����ȴ�.
	//Intercepter�� �������ִ��ڿ��� setBeanName�� ���ڰ��� ��ġ�ϴ� instance��
	//instanceof�� ã�Ƽ� ���ڰ����γ־��ش�.
	
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		this.beanname=name;
		System.out.println(beanname);
		
	}
	//Intercepter�� ���� : setApplicationContext���� �޼ҵ尡 ����Ǹ�
	//�ش� �޼ҵ忡 �ʿ�� �Ǿ����� ���ڰ��� ������Ÿ���� instance of �� �˻��Ͽ�
	//������ �ش��ϴ� ������Ŭ������ �ڱⰡ�������ִ� ��ü�� ���ڰ����� �����ش�.
	//�׷��������μ� �ؿ��� ctx�� applcationContext�� ���ԵǴ°��̴�.
	//Init ���� ����ȴ�.
	
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
