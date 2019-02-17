package market;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MarketMain extends Application {


	@Override
	public void start(Stage primaryStage) {
		try
		{
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("view/MarketMainScreen.fxml"));
			Parent root = (Parent) fxmlloader.load();
			primaryStage.setTitle("Market Manager");
			primaryStage.setScene(new Scene(root, 580, 600));
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (IOException e)
		{
			e.printStackTrace();
		}		
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}