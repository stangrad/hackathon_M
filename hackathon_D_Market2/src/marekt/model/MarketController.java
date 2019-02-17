package marekt.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MarketController {
	
//	private String hisProdDataPath = "res/HistoricProduction.txt";
	private String priceHistory = "res/priceHistory.txt";
	private String userDataPath = "res/HistoricUsage.txt";
	ArrayList <Price> periodPrice = new ArrayList<>();
	ArrayList <Double> periodProduction = new ArrayList<>();	
	ArrayList <User> userList = new ArrayList<>();
	ArrayList<Price> priceList = new ArrayList<>();
	ArrayList<Price> prodList = new ArrayList<>();
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-YYYY");
	Market market = new Market();
	
	public MarketController()  {		
		loadData();		
	}
	
	public double getTotalCurrentProduction()
	{
		double total = 0;
		for (User u: userList)
		{
			total += u.getCurrentProduction();
		}
		return total;
	}
	
	public double getCurrentPrice()
	{
		return 3.85 - ((this.getTotalCurrentProduction()/7200)*0.77);
	}
	
	public double getTotalCurrentUsage()
	{
		double total = 0;
		for (User u: userList)
		{
			total += u.getCurrentUsage();
		}
		return total;		
	}
	
	private void loadData()
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("res/userData.txt"));
			String line = br.readLine();
			//line = br.readLine();
			while (line != null)
			{
				String[] column = line.split(",");
				userList.add(new User(column[0], column[1], column[2], column[3], column[4], column[5], column[6], Double.parseDouble(column[7]), Double.parseDouble(column[8])));
				line = br.readLine();
			}
			br.close();
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*
=======
>>>>>>> branch 'master' of https://github.com/stangrad/hackathon_D_market.git
	*//**
	 * 
	 * @param startDate Start Date
	 * @param endDate End Date
	 * @return ArrayList<double> periodUsage
	 * @throws IOException
	 * @throws ParseException
	 *//*
<<<<<<< HEAD
	public void cntPeroidProduction(String starDate, String endDate) throws ParseException, IOException {
		double production =0.0;
		BufferedReader br = new BufferedReader(new FileReader(hisProdDataPath));
		Date sDay = sdf.parse(starDate);
=======
	
	private ArrayList<Double> cntPeroidUsage(String startDate, String endDate) throws IOException, ParseException {
		ArrayList <Double> periodUsage = new ArrayList <>();
		double usage=0.0;
		BufferedReader br = new BufferedReader(new FileReader(userDataPath));
		Date sDay = sdf.parse(startDate);
>>>>>>> branch 'master' of https://github.com/stangrad/hackathon_D_market.git
		Date eDay = sdf.parse(endDate);
		//cDay = compare day
		Date cDay;
		int i=0;
		String line = br.readLine();
		line = br.readLine();
		while (line != null) { 
			String[] column = line.split(",");
			cDay = sdf.parse(column[1]);
			if(cDay.after(sDay) && cDay.before(eDay) && i < 6) {
					i+=1;
					usage+=Double.parseDouble(column[3]);
				}else if(i==6) {
					i=0;
					usage=0;
				}
			periodUsage.add(usage);
			line = br.readLine();	
		}
		
		br.close();
		return periodUsage;
		
	}*/
	/**
	 * 
	 * @param totalCurrentPowerProduction
	 * @param totalMaxPowerProduction
	 * @return (double)currentMarkPrice
	 */
/*
	private double getCurrentMarkPrice(double totalCurrentPowerProduction, double totalMaxPowerProduction) {
		double currentMarkPrice = market.getMarketPrice(totalCurrentPowerProduction, totalMaxPowerProduction);
		return currentMarkPrice;
	}*/
/**
 * 
 * @return (double)totalCurrentPowerProduction
 *//*
	private double totalCurrentPowerProduction() {
		double totalCurrentPowerProduction = market.getTotalCurrentPowerProduction();
		
		return totalCurrentPowerProduction;
	}
*/
	/**
	 * 
	 * @param starDate starDate
	 * @param endDate  endDate
	 * @return arraylist<double> periodProduction
	 * @throws IOException
	 * @throws ParseException
	 */
/*
	public ArrayList<Double> cntPeroidProduction(String startDate, String endDate) throws ParseException, IOException {
		ArrayList <Double> periodProduction = new ArrayList<>();
		double production =0.0;
		BufferedReader br = new BufferedReader(new FileReader(hisProdDataPath));
		Date sDay = sdf.parse(startDate);
		Date eDay = sdf.parse(endDate);
		//cDay = compare day
		Date cDay;
		int i=0;
		String line = br.readLine();
		line = br.readLine();
		while (line != null) { 
			String[] column = line.split(",");
			cDay = sdf.parse(column[1]);
			if(cDay.after(sDay) && cDay.before(eDay) && i < 6) {
					i+=1;
					production+=Double.parseDouble(column[3]);
				}else if(i==6) {
					i=0;
					production=0;
				}
			periodProduction.add(production);
			line = br.readLine();	
		}
		br.close();
		return periodProduction;
	}*/

/**
 * 
 * @param starDate starDate
 * @param endDate  endDate
 * @return 
 * @throws IOException
 * @throws ParseException
 */

	public ArrayList<Price> getHistoryPrice() {
		
		priceList.clear();
		BufferedReader br;
		try
		{
			br = new BufferedReader(new FileReader(priceHistory));
			String line = br.readLine();
			line = br.readLine();
			while (line != null)
			{
				String[] col = line.split(",");
				priceList.add(new Price(col[0], Double.parseDouble(col[1]), Double.parseDouble(col[3])));
				line = br.readLine();
			}
			br.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return priceList;
	}

	/**
	 * 
	 * @return totalCurrentUsage
	 * @throws IOException
	 */

	public double totalCurrentUsage() throws IOException {
		BufferedReader bfReader = new BufferedReader (new FileReader(userDataPath));
		double totalCurrentUsage = 0.0;
		String line = bfReader.readLine();
		while(line != null) {	
			String [] field = line.split(",");
			totalCurrentUsage += Double.parseDouble(field[7]);
		}
		bfReader.close();
		return totalCurrentUsage;
	}

	public ArrayList<Price> getHistoryProduction()
	{
		prodList.clear();
		BufferedReader br;
		try
		{
			br = new BufferedReader(new FileReader(priceHistory));
			String line = br.readLine();
			line = br.readLine();
			while (line != null)
			{
				String[] col = line.split(",");
				prodList.add(new Price(col[0], Double.parseDouble(col[1]), Double.parseDouble(col[3])));
				line = br.readLine();
			}
			br.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return prodList;
	}
}