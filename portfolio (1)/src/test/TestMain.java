package test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import basic.BMI;
import basic.BMI2;
import basic.Person;
import basic.RecommendCal;
import exercisecollection.running;
import exercisecollection.swimming;
import exercisecollection.walking;
import foodcollection.AfternoonFood;
import foodcollection.Food;
import foodcollection.MorningFood;
import foodcollection.NightFood;

public class TestMain {
	
		//스캐너
		Scanner scan = new Scanner(System.in);
		
		Food[] morningFoods = new Food[4];
		Food[] afternoonFoods = new Food[4];
		Food[] nightFoods = new Food[4];
		
		//외부 함수 호출 선언
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy년 MM월 dd일");
		Date date = new Date();
		String time = format.format(date);
		
		BMI myBMI = new BMI();
		RecommendCal myRecommendCal = new RecommendCal();
		Person person;
		
		//식사와 운동 담은 것
		int startChoice;
		int foodChoice;
		int exerciseChoice;
		
		//총 칼로리 소모량
		double totalFood = 0;
		double totalExercise = 0;

		// 식사 추가를 위한 카트
		ArrayList<Food> cart = new ArrayList<Food>();
		
		//고객 정보 입력
		ArrayList<Person> personList = new ArrayList<>();
		
		Person person1 = new Person("김자바", 175, 80);
		Person person2 = new Person("이클립스", 185, 70);
		
		private void mem() {
			personList.add(person1);
			personList.add(person2);
		}

		
		//기본자 입력
		int id = 0;
		int menu = 0;
		
		public static void main(String[] args) {
			
		TestMain test = new TestMain();
		test.foodType();
		test.start();

	}

	//start
	public void start() {
		
	System.out.println("◈ 방문을 환영합니다 ◈");
	System.out.println("1. 비회원 로그인");
	System.out.println("2. 기존 회원 로그인");

	startChoice = scan.nextInt();
	switch(startChoice) {
		case 1: //비회원 로그인
			notExistingMem();
			break;
		case 2: //기존회원 로그인
			existingMem();
			break;
		default:
			System.out.println("올바른 번호를 입력해주세요.");
			System.exit(0); 
			break;	
	}
	}
	
	private void notExistingMem() {
		scan.nextLine();
		String name = getStrInput("이름 : ");
		double height = getDouInput("키 : ");
		double weight = getDouInput("몸무게 : ");
		
		if(name.equals(name)) {
			System.out.println(name+"님의 정보를 입력받았습니다☺!");
			System.out.println("현재 "+name+"님의 상태를 알려드립니다.");
			myBMI.BMI2(name, height, weight);
			System.out.println();
			System.out.println(name+"님의 권장 칼로리는 "+myRecommendCal.RecommendCal2(height, weight)+"kcal입니다.");
			System.out.println("오늘 칼로리 소모량을 체크하고 싶으시다면,아무 버튼이나 눌러주세요.");
			scan.nextLine();
			scan.nextLine();
			selectFood();
		}
		
	}


	private double getDouInput(String string) {
		System.out.println(string);
		return scan.nextDouble();
	}

	private String getStrInput(String string) {
		System.out.println(string);
		return scan.nextLine();
	}

	private void existingMem() {

	System.out.println("↓ 기존 아이디를 선택해주세요. ↓");
	System.out.println("1. 김자바");
	System.out.println("2. 이클립스");
	
	id = scan.nextInt();
	
	switch (id) {
	case 1:
		person = person1;
		System.out.println(person.getName()+"님 어서오세요☺!");
		System.out.println("현재 "+person.getName()+"님의 상태를 알려드립니다.");
		myBMI.BMI(person);
		System.out.println();
		System.out.println(person.getName()+"님의 권장 칼로리는 "+myRecommendCal.RecommendCal(person)+"kcal입니다.");
		System.out.println("오늘 칼로리 소모량을 체크하고 싶으시다면, 아무 버튼이나 눌러주세요.");
		scan.nextLine();
		scan.nextLine();
		selectFood();
		break;
		
	case 2:
		person = person2;
		System.out.println(person.getName()+"님 어서오세요☺!");
		System.out.println("현재 "+person.getName()+"님의 상태를 알려드립니다.");
		myBMI.BMI(person);
		System.out.println();
		System.out.println(person.getName()+"님의 권장 칼로리는 "+myRecommendCal.RecommendCal(person)+"kcal입니다.");
		System.out.println("오늘 칼로리 소모량을 체크하고 싶으시다면, 아무 버튼이나 눌러주세요.");
		scan.nextLine();
		scan.nextLine();
		selectFood();
		break;
	default :
		System.out.println("잘못된 입력입니다.");
	}	
}

	//음식 선택
	public void selectFood() {
		System.out.println( "▶ " +time+".오늘의 식사 정보 입력을 시작합니다.");
		System.out.println("식사하신 시간대를 선택해주세요.");
		System.out.println("1. 아침");
		System.out.println("2. 점심");
		System.out.println("3. 저녁");
		System.out.println("0. 식사 입력 완료");
		System.out.println("→ 입력할 식사를 선택해주세요.");
		
		foodChoice = scan.nextInt();
		printFoodList();

	}
	
	// 식사 목록
	 public void foodType() {

			morningFoods[0] = new MorningFood("갈치구이 정식", 449.41);
			morningFoods[1] = new MorningFood("김치찌개 정식", 546.65);
			morningFoods[2] = new MorningFood("된장찌개 정식", 501.20);
			morningFoods[3] = new MorningFood("공복", 0);
			
			afternoonFoods[0] = new AfternoonFood("칼로리바", 165);
			afternoonFoods[1] = new AfternoonFood("샌드위치", 321);
			afternoonFoods[2] = new AfternoonFood("라면", 495);
			afternoonFoods[3] = new AfternoonFood("공복", 0);
			
			nightFoods[0] = new NightFood("삶은 계란 2개", 310.2);
			nightFoods[1] = new NightFood("비빔 국수", 489.3);
			nightFoods[2] = new NightFood("오리고기 볶음밥", 454.4);
			nightFoods[3] = new NightFood("공복", 0);
		}
	 
	public void printFoodList() {
		switch(foodChoice) {
			case 0:
			try {
				calFinish();
			} catch (IOException e) {
				e.printStackTrace();
			} 
				break;
			case 1:
				foodSelect(morningFoods);
				break;
			case 2:
				foodSelect(afternoonFoods);
				break;
			case 3:
				foodSelect(nightFoods);
				break;
			default:
				System.out.println("올바른 번호를 입력해주세요.");
				System.exit(0); 
				break;
		}
	}

	public void foodSelect(Food[] Foods) {
		System.out.println("******************");
		for (int i = 0; i < Foods.length; i++) {
			System.out.printf((i+1)+". %s, %.2fkcal\n", 
					Foods[i].getFoodName(), Foods[i].getFoodCal());
		}
		System.out.println("******************");
		
		System.out.println("[0] : 식단을 계산합니다.");
		System.out.printf("선택 -> ");
		
		foodChoice = scan.nextInt();
		if (foodChoice == 0) {
			try {
				calFinish();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else if (foodChoice == 1 || foodChoice == 2 || foodChoice == 3 || foodChoice == 4) {
			
			putCart(Foods[foodChoice-1]);
		} else {
			
			System.out.println("범위를 벗어났습니다. 프로그램을 종료합니다.");
			System.exit(0);
		}
	}
	

	private void putCart(Food food) {
		
	if (food.getFoodCal() >= 0) {
			
			cart.add(food);
			totalFood += food.getFoodCal();
						
			System.out.printf("%s(%.2fkcal)을 선택하셨습니다. 현재 총 소모 칼로리는 %.2fkcal입니다.\n", food.getFoodName(), food.getFoodCal(), totalFood);
			System.out.println("아무 문자나 입력하시면 카테고리 목록이 출력됩니다.");
		} else {
			
			System.out.println("=========================");
			System.out.println("잘못 누르셨습니다.");
		}
		
		scan.nextLine();
		scan.nextLine(); // 입력 버퍼 지우기
		
		selectFood();	
	
}
	
	 public void printFood() {
		 System.out.println("**************");
		 System.out.println("===식단 목록====");
		 System.out.println(" 식사 이름\t   ▏  식사 칼로리");
		 
		 for (int i = 0; i < cart.size(); i++) {		
				System.out.printf(" %s ▏  %.2fkcal \n", cart.get(i).getFoodName(), cart.get(i).getFoodCal());
			}
		 System.out.printf("총 식사 칼로리는 %.2fkcal입니다.", totalFood);
		 System.out.println();
		 System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		 System.out.println("오늘 운동 소모량을 체크하고 싶으시다면, 아무 버튼이나 눌러주세요.");
			scan.nextLine();
			scan.nextLine();

	}

	private void calFinish() throws IOException {
		// 식사 칼로리 계산 뒤 출력할 함수
		printFood();
		System.out.println("-------");
		System.out.println("오늘의 운동을 체크합니다.");
		selectExercise();
	}

	private void selectExercise() throws IOException {
		
		System.out.println("오늘 완료한 운동을 선택해주세요.");
		System.out.println("1. 걷기");
		System.out.println("2. 달리기");
		System.out.println("3. 수영");
		System.out.println("0. 운동 입력 완료");
		System.out.println("-> 입력할 운동을 선택해주세요.");
		exerciseChoice = scan.nextInt();
		printExerciseList();
		
	}

	private void printExerciseList() throws IOException{
		switch(exerciseChoice) {
			case 0:
			exerciseFinish(); 
					break;
				case 1:
				walking.Exercisecal();
				walking.print();
				printExercise();
					break;
				case 2:
				running.Exercisecal();
				running.print();
				printExercise();
					break;
				case 3:
				swimming.Exercisecal();
				swimming.print();
				printExercise();
					break;
				default:
					System.out.println("올바른 번호를 입력해주세요.");
					System.exit(0); 
					break;
		}
		
		exerciseChoice = scan.nextInt();
		printExercise();
		
	}
	
	
	private void printExercise() throws IOException {
		System.out.println("1번을 누르면 운동 선택으로.");
		System.out.println("2번을 누르면 운동 계산으로 출력됩니다.");

		int snum = 0;
		try {
			snum = System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (snum == '1') {
			selectExercise();
		}
		else if (snum == '2') {
			exerciseFinish();
		}
		else {
			System.out.println("올바른 번호를 입력해주세요.");
			System.exit(0); 
		}
		
	}

	private void exerciseFinish() {
		totalExercise = walking.getResult()+running.getResult()+swimming.getResult();
		System.out.println("오늘 총 운동 소모 칼로리는 "+totalExercise+"kcal입니다.");
		System.out.printf("오늘 총 식사 칼로리는 %.2fkcal입니다.\n", totalFood);
		System.out.printf("오늘 총 소모 칼로리는  %.2fkcal입니다.", totalFood-totalExercise);

	}
	


}
