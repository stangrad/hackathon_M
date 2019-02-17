package market.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;

public class RootControl implements Initializable
{

	@FXML
	private Pane paneView;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		System.out.println("hello");
		loadData();
		
	}
	
	private void loadData()
	{
		paneView.getChildren().clear();
		ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
		list.add(new PieChart.Data("Production", 1000));
		list.add(new PieChart.Data("Usage", 5000));
		list.add(new PieChart.Data("Generator", 4000));
		PieChart currentChart = new PieChart(list);
		currentChart.setTitle("Current Information");
		paneView.getChildren().add(currentChart);
		
	}

	
	
}
