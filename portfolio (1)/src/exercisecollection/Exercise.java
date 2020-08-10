package exercisecollection;

public class Exercise {
	
	public String exerciseName;
	public double exerciseCal;
	public static int exerciseTime;

	public Exercise(String exerciseName, double exerciseCal) {
		super();
		this.exerciseName = exerciseName;
		this.exerciseCal = exerciseCal;
		this.exerciseTime = exerciseTime;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public double getExerciseCal() {
		return exerciseCal;
	}

	public void setExerciseCal(double exerciseCal) {
		this.exerciseCal = exerciseCal;
	}

	public static int getExerciseTime() {
		return exerciseTime;
	}

	public void setExerciseTime(int exerciseTime) {
		this.exerciseTime = exerciseTime;
	}


}
