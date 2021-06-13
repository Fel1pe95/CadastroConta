package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	private static Scene mainScene;
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ViewLogin.fxml"));
			AnchorPane pane = loader.load();
			mainScene = new Scene(pane);
			primaryStage.setScene(mainScene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Scene getMainScene() {
		return mainScene;
	}
	
	public static void main(String[] args) {
		launch(args);
		
		
		
		
	}
}
