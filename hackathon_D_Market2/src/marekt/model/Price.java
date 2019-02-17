package marekt.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Price {
	String date;
	double totalCurrentPowerProduction;
	double totalMaxPowerProduction = 7200.00;
	double marketPrice;

	public Price() {
		super();
	}

	public Price(String date, double totalCurrentPowerProduction, double marketPrice) {
		this.date = date;//
		this.totalCurrentPowerProduction = totalCurrentPowerProduction;
		this.totalMaxPowerProduction = 7200.00;
		this.marketPrice = marketPrice;
	}

	public ArrayList<Price> loadHistoricPrice() throws IOException {
		ArrayList<Price> loadHistoricPrice = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader("res/priceHistory.txt"));
		String line = br.readLine();
		line = br.readLine();
		while (line != null) {
			String[] column = line.split(",");

			loadHistoricPrice.add(new Price(column[0], Double.parseDouble(column[2]),
					getMarketPrice()));
			line = br.readLine();
		}
		br.close();
		return loadHistoricPrice;
	}
	
	public double getMarketPrice() {
		//marketPrice = 3.85 - ((this.totalCurrentPowerProduction / 7200) * 0.77);
		return this.marketPrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getTotalCurrentPowerProduction() {
		return this.totalCurrentPowerProduction;
	}

	public void setTotalCurrentPowerProduction(double totalCurrentPowerProduction) {
		this.totalCurrentPowerProduction = totalCurrentPowerProduction;
	}

	public double getTotalMaxPowerProduction() {
		return totalMaxPowerProduction;
	}

	public void setTotalMaxPowerProduction(double totalMaxPowerProduction) {
		this.totalMaxPowerProduction = 7200.00;
	}

	@Override
	public String toString() {
		return "Price [date=" + date + ", totalCurrentPowerProduction=" + totalCurrentPowerProduction
				+ ", totalMaxPowerProduction=" + totalMaxPowerProduction + ", marketPrice=" + marketPrice + "]";
	}

}
