package market.view;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import marekt.model.MarketController;
import marekt.model.Price;
import market.MarketMain;

public class MarketMainScreenController implements Initializable
{
	
	public MarketMain driver;
	public Label lblCurrentPrice;
	public Accordion accordion;
	public TitledPane paneCurrent;
	public Pane paneView;
	public Pane panePrice;
	public Pane paneProd;

	private MarketController mk = new MarketController();
	private PieChart currentChart;

	
/*	public void loadDate()
	{
		SimpleDateFormat dateFormat  = new SimpleDateFormat("MMMM dd, YYYY");
		Calendar now = Calendar.getInstance();
		//txtDate.setText(dateFormat.format(now.getTime()));
		//txtDate.setText(value);
	}*/
	
	@FXML
	private void loadCurrentData()
	{
		
		lblCurrentPrice.setText(String.format("%.2f", mk.getCurrentPrice()) + "");
		
		Random rnd = new Random();
		ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
		list.add(new PieChart.Data("Usage", mk.getTotalCurrentUsage()));
		list.add(new PieChart.Data("Generator", mk.getTotalCurrentUsage() -  (mk.getTotalCurrentProduction()*30)));
		list.add(new PieChart.Data("Home Production", mk.getTotalCurrentProduction()*30));
		currentChart = new PieChart(list);
		
/*		Thread thread = new Thread(new Runnable()
				{
					@Override
					public void run()
					{
						while(true)
						{
							
							
							try {
								Thread.sleep(2000);
							}catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
			
				});*/
		paneView.getChildren().clear();
		paneView.getChildren().add(currentChart);
		//thread.start();

	
	}

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		//loadDate();
		loadCurrentData();
		loadHistory();
		accordion.setExpandedPane(paneCurrent);
	}
	
	private void loadHistory()
	{
		loadHistPrices();
		loadHistProduc();
	}
	
	private void loadHistPrices()
	{
		ArrayList<Price> pricesHist = mk.getHistoryPrice();
		//for (Price p: pricesHist)
			//System.out.println(p.getMarketPrice());
		
		panePrice.getChildren().clear();
		NumberAxis xAxis = new NumberAxis(0,23,1);
		xAxis.setLabel("Days");
		NumberAxis yAxis = new NumberAxis(2.5,5,0.5);
		yAxis.setLabel("Price (cents)");
		LineChart<Number, Number> pricesChart = new LineChart<Number, Number>(xAxis, yAxis);
		//pricesChart.setTitle("Titulo");
		XYChart.Series<Number, Number> series = new XYChart.Series<>();
		series.setName("cents / kilowatt");
		int i = 0;
		for (Price p: pricesHist)
		{
			i++;
			series.getData().add(new XYChart.Data<>(i, (Number)p.getMarketPrice()));
		}
		pricesChart.getData().add(series);
		panePrice.getChildren().add(pricesChart);		
	}

	private void loadHistProduc()
	{
		ArrayList<Price> productionHist = mk.getHistoryProduction();
		//for (Price p: pricesHist)
			//System.out.println(p.getMarketPrice());
		
		paneProd.getChildren().clear();
		NumberAxis xAxis = new NumberAxis(0,23,1);
		xAxis.setLabel("Days");
		NumberAxis yAxis = new NumberAxis(0,9000,1000);
		yAxis.setLabel("Kilowatts");
		LineChart<Number, Number> pricesChart = new LineChart<Number, Number>(xAxis, yAxis);
		//pricesChart.setTitle("Titulo");
		XYChart.Series<Number, Number> series = new XYChart.Series<>();
		series.setName("kilowatt");
		int i = 0;
		for (Price p: productionHist)
		{
			i++;
			series.getData().add(new XYChart.Data<>(i, (Number)p.getTotalCurrentPowerProduction()));
		}
		pricesChart.getData().add(series);
		paneProd.getChildren().add(pricesChart);		
	}

}
