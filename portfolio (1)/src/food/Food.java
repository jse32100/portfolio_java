package food;

public class Food {
	
	
	 private String foodName;
	 private double foodCal;
	
	 public Food(String foodName, double foodCal) {
		super();
		this.foodName = foodName;
		this.foodCal = foodCal;
	}
		
	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getFoodCal() {
		return foodCal;
	}

	public void setFoodCal(double foodCal) {
		this.foodCal = foodCal;
	}

}
