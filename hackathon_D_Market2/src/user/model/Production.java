package user.model;

public class Production {

	String date;
	String hour;
	double powerAmount;
	int userId;
	double price;

	public Production(String date, String hour, double powerAmount, int userId, double price) {
		super();
		this.date = date;
		this.hour = hour;
		this.powerAmount = powerAmount;
		this.userId = userId;
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public double getPowerAmount() {
		return powerAmount;
	}

	public void setPowerAmount(double powerAmount) {
		this.powerAmount = powerAmount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Production [date=" + date + ", hour=" + hour + ", powerAmount=" + powerAmount + ", userId=" + userId
				+ "]";
	}

}
