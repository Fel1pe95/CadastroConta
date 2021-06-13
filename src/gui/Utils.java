package gui;

import java.io.IOException;

import application.Main;
import gui.util.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Utils {

	public static Stage currentStage(ActionEvent event) {
		return (Stage)((Node) event.getSource()).getScene().getWindow();
	}
	
	public void formulario(Stage parentStage, String view, String title) {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(view));
		Pane pane = loader.load();
		
		Stage formStage = new Stage();
		formStage.setTitle(title);
		formStage.setScene(new Scene(pane));
		formStage.setResizable(false);
		formStage.initOwner(parentStage);
		formStage.initModality(Modality.WINDOW_MODAL);
		formStage.showAndWait();
		
		
		}catch(Exception e) {
			Alerts.showAlert("Exception", null, e.getMessage(), AlertType.ERROR);
			e.printStackTrace();
		}
		
	}
	public void loadView(String view) {

		try {
			Scene login = Main.getMainScene();

			FXMLLoader loader = new FXMLLoader(getClass().getResource(view));
			AnchorPane pane = loader.load();

			AnchorPane mainPane = (AnchorPane) ((AnchorPane) login.getRoot());

			mainPane.getChildren().clear();

			mainPane.getChildren().addAll(pane);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
