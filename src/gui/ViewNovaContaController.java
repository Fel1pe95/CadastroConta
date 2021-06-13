package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Dao.InstanciaDao;
import model.Dao.impl.Acess;
import model.entidades.Cliente;

public class ViewNovaContaController implements Initializable {
	@FXML
	private TextField nome;
	@FXML
	private TextField cpf;
	@FXML
	private TextField senha;
	@FXML
	private Button cadastrar;
	@FXML
	private Button cancelar;

	@FXML
	public void onCadastrarAction(ActionEvent event) {
		try {
			Acess acess = InstanciaDao.instanciaCliente();
			Cliente c = new Cliente();
			String nomE = nome.getText().toString();
			Integer cpF = Integer.parseInt(cpf.getText().toString());
			Integer senhA = Integer.parseInt(senha.getText().toString());
			acess.inserirCliente(c.CadastrarCliente(nomE, cpF, senhA));
			

		} catch (Exception e) {
			Alerts.showAlert("Dados inválidos!", null, "Insira os dados para cadastro!", AlertType.WARNING);
		}

	}

	@FXML
	public void onCancelarAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		parentStage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Constraints.setTextFieldInteger(cpf);
		Constraints.setTextFieldInteger(senha);
	}

}
