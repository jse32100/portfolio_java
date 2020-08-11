package exercise;

import java.util.Scanner;

public class running {
		
		
	Exercise ex;
	private static int result;
	private static int time;
	static Scanner sc = new Scanner(System.in);
	
	public static void Exercisecal() {
		System.out.println("▶ 오늘 달리기 운동에 소모한 시간을 분(minute) 단위로 환산해 입력해주세요.");
		time = sc.nextInt();
		result = time*7;
		
	}

	public static void print() {
		System.out.println("▶ 오늘 달리기 운동으로 소모한 칼로리는 "+result+"kcal입니다.");
	}

	public static int getResult() {
		return result;
	}

	public static void setResult(int result) {
		running.result = result;
	}







	}

