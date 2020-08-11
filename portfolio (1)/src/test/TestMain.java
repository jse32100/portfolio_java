package test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import exercise.running;
import exercise.swimming;
import exercise.walking;
import food.MidcalFood;
import food.Food;
import food.HighcalFood;
import food.LowcalFood;
import member.BMI;
import member.Person;
import member.RecommendCal;

public class TestMain {
	
		//스캐너
		Scanner scan = new Scanner(System.in);
		
		Food[] highcalFoods = new Food[4];
		Food[] midcalFoods = new Food[4];
		Food[] lowcalFoods = new Food[4];
		
		//날짜 
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy년 MM월 dd일");
		Date date = new Date();
		String time = format.format(date);
	
		//외부 호출 선언
		BMI myBMI = new BMI();
		RecommendCal myRecommendCal = new RecommendCal();
		Person person;
		
		//시작/식사/운동 선택 버튼
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

		
		//기본자 입력
		int id = 0;
		int menu = 0;
		
		// 시작
		public static void main(String[] args) {
			
		TestMain test = new TestMain();
		test.foodType();
		test.start();

	}

	public void start() {
		
	System.out.println("◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈");
	System.out.println("◈          식사와 칼로리 계산 사이트의      ◈");
	System.out.println("◈                   방문을 환영합니다!                 ◈");
	System.out.println("◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈");
	System.out.println("▶  로그인 방식을 선택해주세요.");
	System.out.println("☞ 1. 비회원 로그인");
	System.out.println("☞ 2. 기존 회원 로그인");

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
			System.out.println("아무 버튼이나 누르면, 다시 초기화면으로 돌아갑니다.");
			scan.nextLine();
			scan.nextLine();
			start();
	}
	}
	
	private void notExistingMem() {
		
		System.out.println("☞ 비회원 로그인을 진행합니다.");
		System.out.println("이용에 필요한 정보를 입력해주세요.");
		scan.nextLine();
		String name = getStrInput("▶ 이름 : ");
		double height = getDouInput("▶ 키(cm) : ");
		double weight = getDouInput("▶ 몸무게(kg) : ");

		if(name.equals(name)) {
			System.out.println("☞ "+name+"님의 정보를 입력받았습니다☺!");
			System.out.println("현재 "+name+"님의 상태를 알려드립니다.");
			System.out.println("─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ");
			myBMI.BMI2(name, height, weight);
			System.out.println();
			System.out.println(name+"님의 하루 권장 칼로리는 <"+myRecommendCal.RecommendCal2(height, weight)+"kcal>입니다.");
			System.out.println("계속 진행하시고 싶으시다면, 아무 버튼이나 눌러주세요.");
			scan.nextLine();
			scan.nextLine();
			selectFood();
		}
		
	}


	private double getDouInput(String string) {
		try {
			System.out.println(string);				
			return scan.nextDouble();
		} catch (Exception e) {
			System.out.println("올바른 숫자를 입력해주세요.");
			System.out.println("엔터키를 누르면, 다시 초기화면으로 돌아갑니다.");
			scan.nextLine();
			scan.nextLine();
			notExistingMem();
		}
		System.out.println(string);				
		return scan.nextDouble();

	}

	private String getStrInput(String string) {
		
		try {
			System.out.println(string);				
			return scan.nextLine();
		} catch (Exception e) {
			System.out.println("올바른 숫자를 입력해주세요.");
			System.out.println("엔터키를 누르면, 다시 초기화면으로 돌아갑니다.");
			scan.nextLine();
			scan.nextLine();
			notExistingMem();
		}
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
		System.out.println("☞ "+person.getName()+"님 어서오세요☺!");
		System.out.println("현재 "+person.getName()+"님의 상태를 알려드립니다.");
		System.out.println("─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ");
		myBMI.BMI(person);
		System.out.println("\n"+person.getName()+"님의 하루 권장 칼로리는 <"+myRecommendCal.RecommendCal(person)+"kcal>입니다.");
		System.out.println("오늘 칼로리 소모량을 체크하고 싶으시다면, 아무 버튼이나 눌러주세요.");
		scan.nextLine();
		scan.nextLine();
		selectFood();
		break;
		
	case 2:
		person = person2;
		System.out.println("☞ "+person.getName()+"님 어서오세요☺!");
		System.out.println("현재 "+person.getName()+"님의 상태를 알려드립니다.");
		System.out.println("─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ");
		myBMI.BMI(person);
		System.out.println("\n"+person.getName()+"님의 하루 권장 칼로리는 <"+myRecommendCal.RecommendCal(person)+"kcal>입니다.");
		System.out.println("오늘 칼로리 소모량을 체크하고 싶으시다면, 아무 버튼이나 눌러주세요.");
		scan.nextLine();
		scan.nextLine();
		selectFood();
		break;
	default :
		System.out.println("잘못된 입력입니다.");
		System.out.println("엔터키를 누르면, 다시 회원 선택으로 돌아갑니다.");
		scan.nextLine();
		scan.nextLine();
		existingMem();
	}	
}

	//음식 선택
	public void selectFood() {
		System.out.println( "▶ "+time+".\n오늘의 식사 정보 입력을 시작합니다.");
		System.out.println("오늘 식사하신 메뉴를 선택해주세요.");
		System.out.println("┏━━━━━━<식 사>━━━━━━━┓");
		System.out.println("┃1. 고칼로리 식사               ┃");
		System.out.println("┃2. 평균 칼로리 식사           ┃");
		System.out.println("┃3. 저칼로리 식사               ┃");
		System.out.println("┃0. 식사 입력 완료              ┃");
		System.out.println("┗━━━━━━<Food>━━━━━━┛");
		System.out.println("→ 입력할 버튼을 눌러주세요.");
		
		foodChoice = scan.nextInt();
		printFoodList();

	}
	
	// 식사 목록
	 public void foodType() {

			highcalFoods[0] = new HighcalFood("후라이드 치킨 반마리", 871.05);
			highcalFoods[1] = new HighcalFood("빅맥 세트", 1155.20);
			highcalFoods[2] = new HighcalFood("포테이토 피자 3조각", 603.45);
			highcalFoods[3] = new HighcalFood("짬뽕 1그릇", 690.80);
			
			midcalFoods[0] = new MidcalFood("오리고기 볶음밥", 454.4);
			midcalFoods[1] = new MidcalFood("서브웨이 터키 샌드위치", 310);
			midcalFoods[2] = new MidcalFood("라면", 495);
			midcalFoods[3] = new MidcalFood("된장찌개 정식", 480.10);
			
			lowcalFoods[0] = new LowcalFood("삶은 계란 2개", 145.2);
			lowcalFoods[1] = new LowcalFood("칼로리바", 165);
			lowcalFoods[2] = new LowcalFood("바나나 2개", 210.0);
			lowcalFoods[3] = new LowcalFood("공복", 0);
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
				foodSelect(highcalFoods);
				break;
			case 2:
				foodSelect(midcalFoods);
				break;
			case 3:
				foodSelect(lowcalFoods);
				break;
			default:
				System.out.println("올바른 번호를 입력해주세요.");
				System.out.println("엔터키를 누르면, 다시 식사 선택으로 돌아갑니다.");
				scan.nextLine();
				scan.nextLine();
				selectFood();
				
		}
	}

	public void foodSelect(Food[] Foods) {
		System.out.println("**************************");
		for (int i = 0; i < Foods.length; i++) {
			System.out.printf((i+1)+". %s, %.2fkcal\n", 
					Foods[i].getFoodName(), Foods[i].getFoodCal());
		}
		System.out.println("**************************");
		
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
			
			System.out.println("올바른 번호를 입력해주세요.");
			System.out.println("엔터키를 누르면, 다시 식사 선택으로 돌아갑니다.");
			scan.nextLine();
			scan.nextLine();
			selectFood();
		}
	}
	

	private void putCart(Food food) {
		
	if (food.getFoodCal() >= 0) {
			
			cart.add(food);
			totalFood += food.getFoodCal();
						
			System.out.printf("%s(%.2fkcal)을 선택하셨습니다.\n현재 총 소모 칼로리는 %.2fkcal입니다.\n", food.getFoodName(), food.getFoodCal(), totalFood);
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
		 System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		 System.out.println("==== 식단 목록 ====");
		 System.out.println(" 식사 이름\t   ▏  식사 칼로리");
		 
		 for (int i = 0; i < cart.size(); i++) {		
				System.out.printf(" %s ▏  %.2fkcal \n", cart.get(i).getFoodName(), cart.get(i).getFoodCal());
			}
		 System.out.println("────────────────────────────");
		 System.out.printf("☞ "+"총 식사 칼로리는 %.2fkcal입니다.\n", totalFood);
		 System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		 System.out.println("오늘 운동 소모량을 체크하고 싶으시다면, 엔터키를 눌러주세요.");
			scan.nextLine();
			scan.nextLine();

	}

	private void calFinish() throws IOException {
		// 식사 칼로리 계산 뒤 출력할 함수
		printFood();
		System.out.println("*************************");
		System.out.println("▶ 오늘의 운동 정보 입력을 시작합니다.");
		selectExercise();
	}

	private void selectExercise() throws IOException {
		
		System.out.println("오늘 완료한 운동을 선택해주세요.");
		System.out.println("┏━━━━━━<운 동>━━━━━━┓");
		System.out.println("┃ 1. 걷기                       ┃");
		System.out.println("┃ 2. 달리기                    ┃");
		System.out.println("┃ 3. 수영                       ┃");
		System.out.println("┃ 0. 운동 입력 완료         ┃");
		System.out.println("┗━━━━<Exercise>━━━┛");
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
					System.out.println("엔터키를 누르면, 다시 운동 선택으로 돌아갑니다.");
					scan.nextLine();
					scan.nextLine();
					selectExercise();
					break;
		}
		
		exerciseChoice = scan.nextInt();
		printExercise();
		
	}
	
	
	private void printExercise() throws IOException {
		System.out.println("☞"+"[1]번을 누르면 운동 선택으로 돌아갑니다.");
		System.out.println("☞"+"[2]번을 누르면 최종 운동 칼로리 계산으로 이동합니다.");

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
		System.out.println("☞ 오늘 총 운동 소모 칼로리는 "+totalExercise+"kcal입니다.");
		System.out.printf("☞ 오늘 총 식사 칼로리는 %.2fkcal입니다.\n", totalFood);
		System.out.printf("☞ 오늘 총 소모 칼로리는  %.2fkcal입니다.\n", totalFood-totalExercise);
		System.out.println("☺ 오늘 하루도 고생 많으셨습니다 ☺ ");
		System.out.println("☺ 내일도 파이팅! ☺ ");

	}
	


}
