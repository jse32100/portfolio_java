package foodcollection;

public class Food {
	
	
	 private String foodName;
	 private double foodCal;
	 private String categoryName;
	
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
	public void printDetail(int num) {
		System.out.printf("음식명 : %s, 칼로리 : %d", foodName, foodCal);
	}
}

//	 public void foodType() {
//	Food morning = new Food("갈치조림 정식", 300);
//	morning.setCategoryName("아침");
//	morningFood[0] = morning;
//	morning = new Food("김치찌개 정식", 400);
//	morningFood[1] = morning;
//	morning = new Food("된장찌개 정식", 500);
//	morningFood[2] = morning;
//	morning = new Food("공복", 0);
//	morningFood[3] = morning;
//	
//	Food afternoon = new Food("칼로리바", 100);
//	afternoon.setCategoryName("점심");
//	afternoonFood[0] = afternoon;
//	afternoon = new Food("샌드위치", 800);
//	afternoonFood[1] = afternoon;
//	afternoon = new Food("라면", 600);
//	afternoonFood[2] = afternoon;
//	afternoon = new Food("공복", 0);
//	afternoonFood[3] = afternoon;
//	
//	Food night = new Food("삶은 계란", 200);
//	night.setCategoryName("저녁");
//	nightFood[0] = night;
//	night = new Food("비빔 국수", 650);
//	nightFood[1] = night;
//	night = new Food("오리고기 볶음밥", 700);
//	nightFood[2] = night;
//	night = new Food("공복", 0);
//	nightFood[3] = night;
//	
//}
