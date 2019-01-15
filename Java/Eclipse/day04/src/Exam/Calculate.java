package Exam;

public class Calculate {

	
	private StudentDemo ca;
	
	StudentDemo studemo = new StudentDemo();
	
	public void CalculateGrade(StudentDemo ca) {
		if(studemo.getAverage() >= 80) {
			System.out.println("Ελ°ϊ");
		}
		else {
			System.out.println("€€€€");
		}
	}
}
