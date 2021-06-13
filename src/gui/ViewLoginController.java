package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Dao.InstanciaDao;
import model.Dao.impl.Acess;
import model.entidades.Funcionario;

public class ViewLoginController implements Initializable {

	@FXML
	private TextField usuario;
	@FXML
	private TextField senha;
	@FXML
	private Button entrar;
	@FXML
	private Label StatusDados;

	@FXML
	public void onEntrarAction() {
		Funcionario f = new Funcionario();
		Acess acess = InstanciaDao.instanciaCliente();
		acess.acessoFuncionario(f.getMap());

		try {
			String user = usuario.getText().toString();
			Integer sn = Integer.parseInt(senha.getText().toString());
			
			boolean ver = f.verFuncionario(user, sn, f.getMap());
			if (ver == true) {
				Utils util = new Utils();
				util.loadView("/gui/ViewMenu.fxml");
			} else {
				Alerts.showAlert("usuario inválido!", null, "usuario e senha fornecidos não cadastrados",
						AlertType.INFORMATION);
			}
		} catch (Exception e) {
			Alerts.showAlert("Exception", null, e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		boolean verificacao = Acess.bancoDeDados();
		if (verificacao == false) {
			StatusDados.setText("Novo banco de Dados criado!");
		}
		
		Constraints.setTextFieldInteger(senha);

	}

}
