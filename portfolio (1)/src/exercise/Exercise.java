package exercise;

import java.util.Scanner;

public class Exercise {

	protected String exerciseName;
	protected int exerciseCal;
	protected int exerciseTime;
	static int result;
	static Scanner sc = new Scanner(System.in);

	

	public void Exercisecal() {
		System.out.printf("▶ 오늘 %s에 소모한 시간을 분(minute) 단위로 환산해 입력해주세요.\n", exerciseName);
		exerciseTime = sc.nextInt();
		result = exerciseTime*exerciseCal;
	}

	public void print() {
		System.out.printf("▶ 오늘 %s 운동으로 소모한 칼로리는 "+result+"kcal입니다.\n", exerciseName);
	}
	
	
	public static int getResult() {
		return result;
	}

	public static void setResult(int result) {
		Exercise.result = result;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public int getExerciseCal() {
		return exerciseCal;
	}

	public void setExerciseCal(int exerciseCal) {
		this.exerciseCal = exerciseCal;
	}

	public int getExerciseTime() {
		return exerciseTime;
	}

	public void setExerciseTime(int exerciseTime) {
		this.exerciseTime = exerciseTime;
	}


}
