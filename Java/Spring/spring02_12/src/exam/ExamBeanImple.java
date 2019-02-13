package exam;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class ExamBeanImple implements
ExamBeanInter,BeanFactoryAware{

	private ExamTypeInter eti;
	private BeanFactory factory;
	@Override
	public void callExecutebean(String condition) {
		eti=factory.getBean(condition,ExamTypeInter.class);
	}

	@Override
	public String getMessageBean() {
		// TODO Auto-generated method stub
		return eti.getMessage();
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		factory=beanFactory;
	}

}
