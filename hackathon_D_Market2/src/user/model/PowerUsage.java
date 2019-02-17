package user.model;

public class PowerUsage
{

	private int userid;
	private String date;
	private String hour;
	private double powerAmount;
	private double price;
	/**
	 * Initializes the newly created PowerUsage.
	 * @param userid
	 * @param date
	 * @param hour
	 * @param powerAmount
	 * @param price
	 */
	public PowerUsage(int userid, String date, String hour, double powerAmount, double price)
	{
		super();
		this.userid = userid;
		this.date = date;
		this.hour = hour;
		this.powerAmount = powerAmount;
		this.price = price;
	}
	/**
	 * Returns the userid.
	 * @return the userid
	 */
	public int getUserid()
	{
		return userid;
	}
	/**
	 * Returns the date.
	 * @return the date
	 */
	public String getDate()
	{
		return date;
	}
	/**
	 * Returns the hour.
	 * @return the hour
	 */
	public String getHour()
	{
		return hour;
	}
	/**
	 * Returns the powerAmount.
	 * @return the powerAmount
	 */
	public double getPowerAmount()
	{
		return powerAmount;
	}
	/**
	 * Returns the price.
	 * @return the price
	 */
	public double getPrice()
	{
		return price;
	}
	/**
	 * Sets the value of userid.
	 * @param userid the userid to set
	 */
	public void setUserid(int userid)
	{
		this.userid = userid;
	}
	/**
	 * Sets the value of date.
	 * @param date the date to set
	 */
	public void setDate(String date)
	{
		this.date = date;
	}
	/**
	 * Sets the value of hour.
	 * @param hour the hour to set
	 */
	public void setHour(String hour)
	{
		this.hour = hour;
	}
	/**
	 * Sets the value of powerAmount.
	 * @param powerAmount the powerAmount to set
	 */
	public void setPowerAmount(double powerAmount)
	{
		this.powerAmount = powerAmount;
	}
	/**
	 * Sets the value of price..
	 * @param price the price to set
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	@Override
	public String toString()
	{
		return "userId: " + this.getUserid() + " date: " + this.getDate() + " hour: " + this.getHour() + " powerAmount: " + this.getPowerAmount() + " price: " + this.getPrice();
	}
	
}
