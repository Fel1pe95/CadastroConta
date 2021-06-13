package gui;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ViewMenuController {
	
	@FXML
	private Button novaConta;
	@FXML
	private Button consulta;
	@FXML
	private Button remover;
	@FXML
	private Button sair;
	
	@FXML
	public void onNovaContaAction(ActionEvent event) {
		Utils util = new Utils();
		Stage parentStage = Utils.currentStage(event);
		util.formulario(parentStage, "/gui/ViewNovaConta.fxml", "Cadastro de cliente");
		
		
	}
	@FXML
	public void onConsultaAction(ActionEvent event) {
		Utils util = new Utils();
		Stage parentStage = Utils.currentStage(event);
		util.formulario(parentStage, "/gui/ViewConsulta.fxml", "Consulta de contas");
		
	}
	@FXML
	public void onRemoverAction() {}
	@FXML
	public void onSariAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		parentStage.close();
		
	}
	
	
	

}
