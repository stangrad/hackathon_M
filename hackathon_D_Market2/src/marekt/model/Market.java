package marekt.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Market {

	String date;
	String hour;
	double totalMaxPowerProduction = 7200.00;
	double totalCurrentPowerProduction;
	double marketPrice;

	public Market() {
		super();
	}

	public Market(String date, String hour, double totalMaxPowerProduction, double totalCurrentPowerProduction,
			double marketPrice) {
		super();
		this.date = date;
		this.hour = hour;
		this.totalMaxPowerProduction = 7200.00;
		this.totalCurrentPowerProduction = totalCurrentPowerProduction;
		this.marketPrice = getMarketPrice(totalCurrentPowerProduction, totalMaxPowerProduction);
	}

	public ArrayList<Price> getHistoryPrice() {
		ArrayList<Price> historyPrice = new ArrayList<Price>();
		historyPrice.add(new Price(date, totalCurrentPowerProduction, 0));
		return historyPrice;
	}

	public double getMarketPrice(double totalCurrentPowerProduction, double totalMaxPowerProduction) {
		marketPrice = 3.85 - (getTotalCurrentPowerProduction() / getTotalMaxPowerProduction() * 0.77);
		return marketPrice;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
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

	public double getTotalMaxPowerProduction() {
		return totalMaxPowerProduction;
	}

	public void setTotalMaxPowerProduction(double totalMaxPowerProduction) {
		this.totalMaxPowerProduction = 7200.00;
	}

	public double getTotalCurrentPowerProduction() {
		return totalCurrentPowerProduction;
	}

	public void setTotalCurrentPowerProduction(double totalCurrentPowerProduction) throws IOException {
		this.totalCurrentPowerProduction = 0;

		BufferedReader br = new BufferedReader(new FileReader("res/userData.txt"));
		String line = br.readLine();
		line = br.readLine();
		while (line != null) {
			String[] column = line.split(",");
			totalCurrentPowerProduction += Double.parseDouble(column[8]);
			line = br.readLine();
		}
		br.close();

	}

	@Override
	public String toString() {
		return "Market [date=" + date + ", hour=" + hour + ", totalMaxPowerProduction=" + totalMaxPowerProduction
				+ ", totalCurrentPowerProduction=" + totalCurrentPowerProduction + "]";
	}

}
