package pers.zyx.exe1;

public class GeometricObject {
	protected String color;
	protected double weight;

	protected GeometricObject(String color, double weight) {
		this.color = color;
		this.weight = weight;
	}

	protected GeometricObject() {
		super();
		this.color = "white";
		this.weight = 1.0;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
