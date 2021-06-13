package gui;

import gui.util.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Dao.InstanciaDao;
import model.Dao.impl.Acess;
import model.entidades.Cliente;

public class ViewRemoverController {

	@FXML
	private TextField agencia;
	@FXML
	private TextField conta;
	@FXML
	private TextField senha;
	@FXML
	private Button remover;
	@FXML
	private Button cancelar;

	@FXML
	public void onRemoverAction() {
		Cliente c = new Cliente();
		Acess acess = InstanciaDao.instanciaCliente();
		acess.LeituraCliente(c.getAgencia());
		Integer ag = Integer.parseInt(agencia.getText().toString());
		Integer ct = Integer.parseInt(conta.getText().toString());
		Integer sn = Integer.parseInt(senha.getText().toString());
		boolean ver = c.verificacao(sn, ag, ct);
		if (ver == true) {
			c.getAgencia().remove(sn);
			acess.gravacaoCLiente(c.getAgencia());
			Alerts.showAlert("Concluido.", null, "Conta removida com sucesso", AlertType.INFORMATION);
		} else {
			Alerts.showAlert("Conta inválida", null, "Conta não encontrada!", AlertType.INFORMATION);
		}
	}

	@FXML
	public void onCancelarActio(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		parentStage.close();
	}
}
