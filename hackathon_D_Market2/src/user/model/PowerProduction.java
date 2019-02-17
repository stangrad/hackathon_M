package user.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PowerProduction {

	int userId;
	String date;
	String hour;
	double powerAmount;
	double price;

	public PowerProduction(int userId, String date, String hour, double powerAmount, double price) {
		this.date = date;
		this.hour = hour;
		this.powerAmount = powerAmount;
		this.price = price;
		this.userId = userId;
	}

	public static ArrayList<PowerProduction> loadHistoricProduction(int userId) throws IOException {
		ArrayList<PowerProduction> historicProduction = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader("res/HistoricProduction.txt"));
		String line = br.readLine();
		line = br.readLine();
		while (line != null) { //
			String[] column = line.split(",");
			if (Integer.parseInt(column[0]) == userId)
				historicProduction.add(new PowerProduction(Integer.parseInt(column[0]), column[1], column[2],
						Double.parseDouble(column[3]), Double.parseDouble(column[4])));

			line = br.readLine();
		}
		br.close();
		return historicProduction;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String gethour() {
		return hour;
	}

	public void sethour(String hour) {
		this.hour = hour;
	}

	public double getPowerAmount() {
		return powerAmount;
	}

	public void setPowerAmount(double powerAmount) {
		this.powerAmount = powerAmount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PowerCharging [date=" + date + ", powerAmount=" + powerAmount + ", price=" + price + ", userId="
				+ userId + "]";
	}

}
