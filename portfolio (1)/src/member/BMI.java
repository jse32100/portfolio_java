package member;

public class BMI {
	
	static Person person;
		
public void BMI(Person person) {
	 String BMI;
	String name = person.getName();
	double height = person.getHeight();
	double weight = person.getWeight();
	double result = weight / (height*height)*10000;

		if(result>30.0){   
			BMI = "비만";
			}
		else if(result>25.0){
			BMI ="과체중";
			}
		else if(result>18.0){
			BMI ="정상";
			}
		else{
			BMI ="저체중";
			}
		System.out.printf("%s님의  체질량 지수(BMI)는 %.2f이며, %s입니다.", name, result, BMI);
}

	public void BMI2(String name, double height, double weight) {
	String BMI;
	double result = weight / (height*height)*10000;

		if(result>30.0){   
			BMI = "비만";
			}
		else if(result>25.0){
			BMI ="과체중";
			}
		else if(result>18.0){
			BMI ="정상";
			}
		else{
			BMI ="저체중";
			}
		System.out.printf("%s님의  체질량 지수(BMI)는 %.2f이며, %s입니다.", name, result, BMI);
}

}

