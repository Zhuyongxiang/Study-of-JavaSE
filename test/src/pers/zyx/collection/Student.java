package pers.zyx.collection;

public class Student {
	private String name;
	private int score;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Student() {
		
	}
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String toString() {
		String str = name + " ³É¼¨£º" + score;
		return str;
	}
}
