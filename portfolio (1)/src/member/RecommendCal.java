package member;

public class RecommendCal {
	static Person person;
	
 public int RecommendCal(Person person) {
	
		double height = person.getHeight();
		int result;
		result = (int)((height-100)*0.9*25);
		return result;
}

@Override
public String toString() {
	return "RecommendCal [toString()=" + super.toString() + "]";
}

public int RecommendCal2(double height, double weight) {
	int result;
	result = (int)((height-100)*0.9*25);
	return result;
}
}

