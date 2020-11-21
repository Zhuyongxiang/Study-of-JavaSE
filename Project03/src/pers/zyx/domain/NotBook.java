package pers.zyx.domain;

public class NotBook implements Equipment {
	private String model;
	private double price;
	
	public NotBook() {
		super();
	}
	public NotBook(String model, double price) {
		super();
		this.model = model;
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String getDescription() {
		return model + "(" + price + ")";
	}

}
