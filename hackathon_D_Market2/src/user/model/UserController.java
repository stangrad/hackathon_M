package user.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UserController
{

	private static ArrayList<User> userList = new ArrayList<>();
	//Scanner kb = new Scanner(System.in);
	private String userDataPath = "res/userData.txt";
	private String hisProdDataPath = "res/HistoricProduction.txt";
	private String hisUsagDataPath = "res/HistoricUsage.txt";

	public UserController() throws IOException {
		loadUserData();
	}
	
	
	private void loadUserData() throws IOException {
		String line ="";
		BufferedReader bfReader = new BufferedReader(new FileReader(userDataPath));
		//header
		line = bfReader.readLine();
		//data starting
		line = bfReader.readLine();
		while(line != null) {
			String field [] = line.split(",");
			userList.add(new User(field[0],field[1],field[2],field[3],field[4],field[5], field[6], Double.parseDouble(field[7]), Double.parseDouble(field[8])));
			line = bfReader.readLine();
		}
		//printOut();
	}
	
	public static ArrayList<User> getAllUsers()
	{
		return userList;
	}
	
	public static User getUser(String userId)
	{
		User singleUser = null;
		for(int i=0; i<userList.size(); i++) {
			if(userList.get(i).getId().matches(userId)){
				singleUser = userList.get(i);				
			}			
		}
		return singleUser;		
	}
	/**
	 * Method description - ttlCurrentProduction()
	 * Calculate total current Production from database
	 * @return double total_CurrentProduction
	 */
	public double getTotalCurrentProduction() {
		double total_CurrentProduction=0.0;
		for(User e: userList) {
			total_CurrentProduction+=e.getCurrentProduction();
		}
		// System.out.println(total_CurrentProduction);
		return total_CurrentProduction;
	}

	public ArrayList<Production> getHistoricProduction(String userId) throws IOException
	{
		ArrayList<Production> prodHist = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(hisProdDataPath));
		String line = br.readLine();
		line = br.readLine();
		while(line != null)
		{
			String[] column = line.split(",");
			if (column[0].equals(userId))
			{
				prodHist.add(new Production(column[1], column[2], Double.parseDouble(column[3]), Integer.parseInt(column[0]), Double.parseDouble(column[4])));
			}
			line = br.readLine();
		}
		return prodHist;
	}
	
	public ArrayList<PowerUsage> getHistoricUsage(String userId) throws IOException
	{
		ArrayList<PowerUsage> usageHist = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(hisUsagDataPath));
		String line = br.readLine();
		line = br.readLine();
		while(line != null)
		{
			String[] column = line.split(",");
			if (column[0].equals(userId))
			{
				usageHist.add(new PowerUsage(Integer.parseInt(column[0]), column[1], column[2], Double.parseDouble(column[3]), Double.parseDouble(column[4])));
			}
			line = br.readLine();
		}
		return usageHist;
	}


}
